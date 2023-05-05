package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.model.store.*;
import it.unipv.sfw.model.store.Merchandising.Merch;
import it.unipv.sfw.model.utente.Cliente;

/**
 * Classe DAO per {@link it.unipv.sfw.model.store.Merchandising}.
 * @author Federico Romano
 * @see it.unipv.sfw.model.store.Merchandising
 */
public class StoreItemDAO implements IStoreItemDAO {

	private final String schema;
	private Connection conn;
	
	public StoreItemDAO() {
		super();
		this.schema = "STORE_ITEMS";  // (id, tipo, prezzo, quantita_rimanente, descrizione) 
	}
	
	@Override
	public boolean updatePrezzoItem(Merchandising merch, double newPrezzo) {
		
		conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try
		{
			String query = "UPDATE " + this.schema + " SET PREZZO=? WHERE ID=?";
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
			String query = "UPDATE " + this.schema + " SET QUANTITA_RIMANENTE=? WHERE ID=?";
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
			String query = "INSERT INTO " + this.schema + "(TIPO, PREZZO, QUANTITA_RIMANENTE, DESCRIZIONE) VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + merch.getTipoMerch());
			st1.setDouble(2, merch.getPrezzo());
			st1.setInt(3, quantita);
			st1.setString(4, merch.getDescrizione());
			
			st1.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public ArrayList<Merchandising> selectAll() {
		
		ArrayList<Merchandising> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{
			st1 = conn.createStatement();
			String query = "SELECT * FROM STORE_ITEMS";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				Merchandising c = new Merchandising(rs1.getString(2), rs1.getDouble(3), rs1.getInt(1), rs1.getInt(4), rs1.getString(5));
				result.add(c);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public ArrayList<Merchandising> selectStillInStock() {
		
		ArrayList<Merchandising> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
	
		try
		{
			st1 = conn.createStatement();
			String query = "SELECT * FROM STORE_ITEMS WHERE QUANTITA_RIMANENTE > 0";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				Merchandising c = new Merchandising(rs1.getString(2), rs1.getDouble(3), rs1.getInt(1), rs1.getInt(4), rs1.getString(5));
				result.add(c);
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		DBConnection.closeConnection(conn); 
		return result;
	}
	
	@Override
	public Merchandising selectById(Merchandising merch) {
		
		Merchandising result = null;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
	
		try
		{
			String query = "SELECT * FROM UTENTI WHERE ID=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, merch.getId());
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				result = new Merchandising(rs1.getString(2), rs1.getDouble(3), rs1.getInt(1), rs1.getInt(4), rs1.getString(5));
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		DBConnection.closeConnection(conn); 
		return result;
	}
	
}
