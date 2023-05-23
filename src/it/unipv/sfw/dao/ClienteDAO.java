package it.unipv.sfw.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import it.unipv.sfw.model.utente.Admin;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente.Type;

/**
 * Classe DAO per {@link it.unipv.sfw.model.utente.Cliente}
 * @author Federico Romano
 * @see it.unipv.sfw.model.utente.Cliente   //(email, nome, cognome, pass, tipo, nascita)
 */
public class ClienteDAO implements IClienteDAO {
	
	private static final String SCHEMA  = "UTENTI";

	@Override
	public ArrayList<Cliente> selectAll() {
		
		ArrayList<Cliente> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			st1 = conn.createStatement();
			String query = "SELECT NOME, COGNOME, EMAIL, PASS, NASCITA FROM " + SCHEMA + " WHERE TIPO='CLIENTE'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String str = rs1.getString(6);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ITALY);
				cal.setTime(sdf.parse(str));
				Cliente c = new Cliente(rs1.getString(2), rs1.getString(3), rs1.getString(1), rs1.getString(4), cal);
				result.add(c);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public Cliente selectByEmail(String email) {
		
		Cliente result = null;
		
		PreparedStatement st1;
		ResultSet rs1;
	
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM " + SCHEMA + " WHERE EMAIL=? AND TIPO='CLIENTE'";
			st1 = conn.prepareStatement(query);
			st1.setString(1, email);
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				String str = rs1.getString(6);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);
				cal.setTime(sdf.parse(str));
				result = new Cliente(rs1.getString(2), rs1.getString(3), rs1.getString(1), rs1.getString(4), cal);
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public boolean updatePassword(String newPassword, Cliente account) {
		
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
	public boolean insertCliente(Cliente clienteInput) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " VALUES(?,?,?,?,'" + Type.CLIENTE + "',?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(3, clienteInput.getNome());
			st1.setString(2, clienteInput.getCognome());
			st1.setString(1, clienteInput.getEmail());
			st1.setString(4, clienteInput.getPassword());
			st1.setString(5, clienteInput.getDataNascita());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
	
}
