package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.model.store.*;

public class StoreItemDAO implements IStoreItemDAO {

	private String schema;
	private Connection conn;
	
	public StoreItemDAO() {
		super();
		this.schema = "STOREITEMS";  // (id, tipo, prezzo, quantitaRimanente) 
	}
	
	@Override
	public boolean updatePrezzoItem(Merchandising merch, double newPrezzo) {
		
		conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try
		{
			String query = "UPDATE STOREITEMS SET PREZZO=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setDouble(1, newPrezzo);                  
			st1.setInt(2, merch.getId());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean updateQuantitaItem(Merchandising merch, int newQuantita) {
		
		conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try
		{
			String query = "UPDATE STOREITEMS SET QUANTITA=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setDouble(1, newQuantita);                  
			st1.setInt(2, merch.getId());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean insertStoreItem(Merchandising merch, int quantita) {
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO STOREITEMS VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setInt(1, merch.getId());
			st1.setString(2, "" + merch.getTipoMerch());
			st1.setDouble(3, merch.getPrezzo());
			st1.setInt(4, quantita);
			
			st1.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
}
