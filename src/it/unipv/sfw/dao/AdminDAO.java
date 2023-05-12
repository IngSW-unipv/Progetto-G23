package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.model.utente.Admin;
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
			String query = "SELECT (NOME, COGNOME, EMAIL, PASSWORD) FROM " + SCHEMA + " WHERE TIPO='ADMIN'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				Admin a = new Admin(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
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
				result = new Admin (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
			}
			
		} catch (Exception e) {e.printStackTrace();}

		return result;
	}
	
	@Override
	public boolean insertAdmin(Admin adminInput) {
		
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
