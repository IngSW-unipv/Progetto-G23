package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.utente.Admin;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.model.utente.Utente.Type;

/**
 * Classe DAO per {@link it.unipv.sfw.model.utente.Utente}.
 * @author Federico Romano
 * @see it.unipv.sfw.model.utente.Utente
 */
public class UtenteDAO implements IUtenteDAO {
	
	private static final String SCHEMA  = "UTENTI";
	
	@Override
	public ArrayList<Utente> selectAll() {
		
		ArrayList<Utente> result = new ArrayList<>();;
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA;
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(4);
				if(tipo.equals("" + Type.ADMIN)) {
					Admin a = new Admin (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
					result.add(a);
				} else if(tipo.equals("" + Type.CLIENTE) || tipo.equals("" + Type.GIORNALISTA)) {
					String str = rs1.getString(6);
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ITALY);
					cal.setTime(sdf.parse(str));
					Cliente c = new Cliente (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), cal);
					result.add(c);
				}
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public boolean insertUtente(Utente u) {

		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " VALUES(?,?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, u.getNome());
			st1.setString(2, u.getCognome());
			st1.setString(3, u.getEmail());
			st1.setString(4, u.getPassword());
			st1.setString(5, "" + u.getType());
			
			st1.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
			esito = false;
		}
		
		return esito;
	}
	
	@Override
	public Utente selectByEmail(String email) {
		
		Utente result = null;
		
		PreparedStatement st1;
		ResultSet rs1;
	
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM " + SCHEMA + " WHERE EMAIL=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, email);
			rs1 = st1.executeQuery();
			
			String tipo = rs1.getString(4);
			if(tipo.equals("" + Type.ADMIN)) {
				result = new Admin (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
			} else if(tipo.equals("" + Type.CLIENTE) || tipo.equals("" + Type.GIORNALISTA)) {
				String str = rs1.getString(6);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ITALY);
				cal.setTime(sdf.parse(str));
				result = new Cliente (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), cal);
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public boolean updatePassword(String newPassword, Utente account) {
		
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
	public Type selectByEmailAndPassword(String email, String password) {
		
		Type tipoSelected = null;
		
		PreparedStatement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT TIPO FROM " + SCHEMA + " WHERE EMAIL=? AND PASSWORD LIKE ?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, email);
			st1.setString(2, password);
			rs1 = st1.executeQuery();
			
			String tipo = rs1.getString(4);
			if(tipo.equals("" + Type.ADMIN)) {
				tipoSelected = Type.ADMIN;
			} else if(tipo.equals("" + Type.CLIENTE) || tipo.equals("" + Type.GIORNALISTA)) {
				tipoSelected = Type.CLIENTE;
			}
		} catch (Exception e) {e.printStackTrace();}
		
		return tipoSelected;
	}
}
