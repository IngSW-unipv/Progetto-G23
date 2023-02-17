package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Cliente;

public class AbbonamentoDAO implements IAbbonamentoDAO {
	
	private String schema;
	private Connection conn;
	
	public AbbonamentoDAO() {
		super();
		this.schema = "ABBONAMENTI"; //(email, livello)
	}
	
    @Override
	public boolean insertAbbonamento(Cliente nuovoAbbonato) {
    	
    	conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try
		{
			String query = "INSERT INTO ABBONAMENTI VALUES(?,?) WHERE CLIENTE.EMAIL=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, nuovoAbbonato.getEmail());
			st1.setString(2, "" + nuovoAbbonato.getAbb().getTipoAbb());
			st1.setString(3, nuovoAbbonato.getEmail());
			
			st1.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
    
    @Override
	public boolean updateAbbonamento(Cliente nuovoAbbonato, TipoAbb livello) {
    	
    	conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try
		{
			String query = "UPDATE ABBONAMENTI SET LIVELLO=? WHERE EMAIL=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + livello);
			st1.setString(2, nuovoAbbonato.getEmail());
			
			st1.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
    	
}
	

