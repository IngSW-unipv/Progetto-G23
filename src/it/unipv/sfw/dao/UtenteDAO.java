package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	private String schema;
	private Connection conn;
	
	public UtenteDAO() {
		super();
		this.schema = "UTENTI";
	}
	
	@Override
	public ArrayList<Utente> selectAll() {
		
		ArrayList<Utente> result = new ArrayList<>();;
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{
			st1 = conn.createStatement();
			String query = "SELECT * FROM UTENTI";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(4);
				if(tipo.equals("" + Type.ADMIN)) {
					Admin a = new Admin (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
					result.add(a);
				} else if(tipo.equals("" + Type.CLIENTE) || tipo.equals("" + Type.GIORNALISTA)) {
					Cliente c = new Cliente (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
					result.add(c);
				}
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean insertUtente(Utente u) {

		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try {
			
			String query = "INSERT INTO UTENTI VALUES(?,?,?,?,?)";
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
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public Utente selectByEmail(String email) {
		
		Utente result = null;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
	
		try
		{
			String query = "SELECT * FROM UTENTI WHERE EMAIL=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, email);
			rs1 = st1.executeQuery();
			
			String tipo = rs1.getString(4);
			if(tipo.equals("" + Type.ADMIN)) {
				result = new Admin (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
			} else if(tipo.equals("" + Type.CLIENTE) || tipo.equals("" + Type.GIORNALISTA)) {
				result = new Cliente (rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		DBConnection.closeConnection(conn); 
		return result;
	}
	
	@Override
	public Type selectByEmailAndPassword(String email, String password) {
		
		Type tipoSelected = null;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query = "SELECT TIPO FROM UTENTI WHERE EMAIL=? AND PASSWORD LIKE ?";
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
		
		DBConnection.closeConnection(conn); 
		return tipoSelected;
	}
}
