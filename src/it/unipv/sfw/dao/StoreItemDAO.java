package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.HashMap;

import it.unipv.sfw.model.store.*;

/**
 * Classe DAO per {@link it.unipv.sfw.model.store.Merchandising}.
 * @author Federico Romano
 * @see it.unipv.sfw.model.store.Merchandising
 */
public class StoreItemDAO implements IStoreItemDAO {

	private static final String SCHEMA = "STORE_ITEMS";
	
	@Override
	public boolean updatePrezzoItem(Merchandising merch, double newPrezzo) {
		
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "UPDATE " + SCHEMA + " SET PREZZO=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setDouble(1, newPrezzo);                  
			st1.setInt(2, merch.getId());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
	
	@Override
	public boolean updateQuantitaItem(Merchandising merch, int newQuantita) {
		
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "UPDATE " + SCHEMA + " SET QUANTITA_RIMANENTE=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setDouble(1, newQuantita);                  
			st1.setInt(2, merch.getId());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
	
	@Override
	public boolean insertStoreItem(Merchandising merch, int quantita) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + "(TIPO, PREZZO, QUANTITA_RIMANENTE, DESCRIZIONE) VALUES(?,?,?,?)";
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
		
		return esito;
	}
	
	@Override
	public HashMap<Merchandising, Integer> selectAll() {
		
		HashMap<Merchandising, Integer> result = new HashMap<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA;
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				int q =  rs1.getInt(4);
				Merchandising c = new Merchandising(rs1.getString(2), rs1.getDouble(3), rs1.getInt(1), rs1.getString(5));
				result.put(c, q);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public HashMap<Merchandising, Integer> selectStillInStock() {
		
		HashMap<Merchandising, Integer> result = new HashMap<>();
		
		Statement st1;
		ResultSet rs1;
	
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA + " WHERE QUANTITA_RIMANENTE > 0";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				int q =  rs1.getInt(4);
				Merchandising c = new Merchandising(rs1.getString(2), rs1.getDouble(3), rs1.getInt(1), rs1.getString(5));
				result.put(c, q);
			}
			
		} catch (Exception e) {e.printStackTrace();}
		 
		return result;
	}
	
	@Override
	public AbstractMap.SimpleEntry<Merchandising, Integer> selectById(Merchandising merch) {
		
		AbstractMap.SimpleEntry<Merchandising, Integer> result = null;
		
		PreparedStatement st1;
		ResultSet rs1;
	
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM " + SCHEMA + " WHERE ID=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, merch.getId());
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				int q = rs1.getInt(4);
				Merchandising m = new Merchandising(rs1.getString(2), rs1.getDouble(3), rs1.getInt(1), rs1.getString(5));
				result = new AbstractMap.SimpleEntry<>(m, q);
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		return result;
	}
	
}
