package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.dao.DBConnection;
import it.unipv.sfw.dao.ICimelioDAO;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.model.museo.Cimelio.TipoCimelio;
import it.unipv.sfw.model.museo.Riconoscimento.TipoRiconoscimento;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Admin;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente.Type;

/**
 * Classe DAO per {@link it.unipv.sfw.model.museo.Cimelio}.
 * @author Federico Romano
 * @see it.unipv.sfw.model.museo.Cimelio
 */
public class CimelioDAO implements ICimelioDAO {

	private static final String SCHEMA = "MUSEO_ITEMS";
	
	@Override
	public boolean insertCimelio(Cimelio cim) {
	
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			String query = "INSERT INTO " + SCHEMA + " VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, cim.getTipo());
			st1.setInt(2, cim.getAnno());
			st1.setString(3, cim.getDescrizione());
			st1.setString(4, cim.getImgid());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 

		return esito;
	}
	
	@Override
	public boolean updateDescrizione(Cimelio cimelio) {
		
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			String query = "UPDATE " + SCHEMA + " SET DESCRIZIONE=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, cimelio.getDescrizione());                  
			st1.setInt(2, cimelio.getId());       
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
	
	@Override
	public ArrayList<Cimelio> selectAll() {
		
		ArrayList<Cimelio> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA;
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(4);
				if(tipo.equals("" + TipoCimelio.Fotografia) || tipo.equals("" + TipoCimelio.Ricordo)) {
					TipoCimelio tipoc = TipoCimelio.valueOf(TipoCimelio.class, tipo);
					Cimelio c = new Cimelio (rs1.getString(4), tipoc, rs1.getInt(1), rs1.getInt(3), rs1.getString(5));
					result.add(c);
				} 
			}	
		} catch (Exception e){
			
			e.printStackTrace();
			result = null;
		}
		
		return result;
	}
	
	@Override
	public Cimelio selectById(Cimelio item) {
		
		Cimelio result = null;
		
		PreparedStatement st1;
		ResultSet rs1;
	
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			String query = "SELECT * FROM " + SCHEMA + " WHERE ID=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, item.getId());
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				String tipo = rs1.getString(2);
				TipoCimelio tipoc = TipoCimelio.valueOf(TipoCimelio.class, tipo);
				result = new Cimelio (rs1.getString(4), tipoc, rs1.getInt(1), rs1.getInt(3), rs1.getString(5));
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public ArrayList<Cimelio> selectAllOrderByData() {
		
		ArrayList<Cimelio> result = new ArrayList<>();
				
		Statement st1;
		ResultSet rs1;
				
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA + "ORDER BY ANNO";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(2);
				TipoCimelio tipoc = TipoCimelio.valueOf(TipoCimelio.class, tipo);
				Cimelio c = new Cimelio (rs1.getString(4), tipoc, rs1.getInt(1), rs1.getInt(3), rs1.getString(5));
				result.add(c);
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
			result = null;
		}
				
		return result;
	}

}
