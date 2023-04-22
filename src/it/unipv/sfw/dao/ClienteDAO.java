package it.unipv.sfw.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente.Type;

public class ClienteDAO implements IClienteDAO {
	
	private String schema;
	private Connection conn;
	
	public ClienteDAO() {
		super();
		this.schema = "UTENTI";
	}
	
	@Override
	public ArrayList<Cliente> selectAll() {
		
		ArrayList<Cliente> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{
			st1 = conn.createStatement();
			String query = "SELECT NOME, COGNOME, EMAIL, PASS FROM UTENTI WHERE TIPO='CLIENTE'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				Cliente c = new Cliente(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
				result.add(c);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public Cliente selectByEmail(String email) {
		
		Cliente result = null;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
	
		try
		{
			String query = "SELECT * FROM UTENTI WHERE EMAIL=? AND TIPO='CLIENTE'";
			st1 = conn.prepareStatement(query);
			st1.setString(1, email);
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				result = new Cliente(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4));
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		DBConnection.closeConnection(conn); 
		return result;
	}
	
	@Override
	public boolean insertCliente(Cliente clienteInput) {
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO UTENTI VALUES(?,?,?," + Type.CLIENTE + ")";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, clienteInput.getNome());
			st1.setString(2, clienteInput.getCognome());
			st1.setString(3, clienteInput.getEmail());
			st1.setString(4, clienteInput.getPassword());
			
			st1.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
}
