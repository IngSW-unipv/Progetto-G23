package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import it.unipv.sfw.dao.IAdminDAO;
import it.unipv.sfw.model.utente.Admin;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.model.utente.Utente.Type;

/**
 * Classe DAO per {@link it.unipv.sfw.model.utente.Admin}.
 * @author Federico Romano
 * @see it.unipv.sfw.model.utente.Admin
 */
public class AdminDAO implements IAdminDAO {
	
	private static final String SCHEMA = "UTENTI";
	
	@Override
	public ArrayList<Admin> selectAll() {
		
		ArrayList<Admin> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			st1 = conn.createStatement();
			String query = "SELECT (NOME, COGNOME, EMAIL, PASSWORD,NASCITA) FROM " + SCHEMA + " WHERE TIPO='ADMIN'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String str = rs1.getString(6);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ITALY);
				cal.setTime(sdf.parse(str));
				Admin a = new Admin(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),cal);
				result.add(a);
			}
			
		} catch (Exception e){e.printStackTrace();}

		return result;
	}
	
	@Override
	public Admin selectByEmail(String email) {
		
		Admin result = null;
		
		PreparedStatement st1;
		ResultSet rs1;
	
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM " + SCHEMA + " WHERE EMAIL=? AND TIPO='ADMIN'";
			st1 = conn.prepareStatement(query);
			st1.setString(1, email);
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				String str = rs1.getString(6);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ITALY);
				cal.setTime(sdf.parse(str));
				result = new Admin (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),cal);
			}
			
		} catch (Exception e) {e.printStackTrace();}

		return result;
	}
	
	@Override
	public boolean updatePassword(String newPassword, Admin account) {
		
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "UPDATE " + SCHEMA + " SET PASSWORD=? WHERE EMAIL=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, newPassword);
			st1.setString(2, account.getEmail());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
    	
		return esito;
	}
	
	@Override
	public boolean insertAdmin(Admin adminInput) {
		// Assicura che l'email sia in lowercase.
		adminInput.setEmail(adminInput.getEmail().toLowerCase());
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " VALUES(?,?,?," + Type.ADMIN + ")";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, adminInput.getNome());
			st1.setString(2, adminInput.getCognome());
			st1.setString(3, adminInput.getEmail());
			st1.setString(4, adminInput.getPassword());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		return esito;
	}
}
