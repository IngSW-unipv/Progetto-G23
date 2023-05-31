package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.dao.IRiconoscimentoDAO;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Cimelio.TipoCimelio;
import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.model.museo.Riconoscimento.TipoRiconoscimento;
import it.unipv.sfw.model.utente.Admin;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente.Type;

/**
 * Classe DAO per {@link it.unipv.sfw.model.museo.Riconoscimento}.
 * @author Federico Romano
 * @see it.unipv.sfw.model.museo.Riconoscimento
 */
public class RiconoscimentoDAO implements IRiconoscimentoDAO {

	private static final String SCHEMA = "MUSEO_ITEMS";
	
	@Override
	public boolean insertRiconoscimento(Riconoscimento riconoscimento) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, riconoscimento.getTipo());
			st1.setInt(2, riconoscimento.getAnno());
			st1.setString(3, riconoscimento.getDescrizione());
			st1.setString(4, riconoscimento.getImgid());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
	
	@Override
	public boolean updateDescrizione(Riconoscimento riconoscimento) {
		
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "UPDATE " + SCHEMA + " SET DESCRIZIONE=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, riconoscimento.getDescrizione());                  
			st1.setInt(2, riconoscimento.getId());       
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
	
	@Override
	public ArrayList<Riconoscimento> selectAll() {
		
		ArrayList<Riconoscimento> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA;
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(2);
				if(tipo.equals("" + TipoRiconoscimento.Coppa)  || tipo.equals("" + TipoRiconoscimento.Trofeo)) {
					TipoRiconoscimento tipor = TipoRiconoscimento.valueOf(TipoRiconoscimento.class, tipo);
					Riconoscimento r = new Riconoscimento (rs1.getInt(3), rs1.getString(4), tipor, rs1.getInt(1), rs1.getString(5));
					result.add(r);
				}
			}
			
			
		} catch (Exception e){
			
			e.printStackTrace();
			result = null;
		}
		
		return result;
	}
	
	@Override
	public Riconoscimento selectById(Riconoscimento item) {
		
		Riconoscimento result = null;
		
		PreparedStatement st1;
		ResultSet rs1;
	
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT * FROM " + SCHEMA + " WHERE ID=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, item.getId());
			rs1 = st1.executeQuery();
			
			rs1.next();
			String tipo = rs1.getString(2);
			TipoRiconoscimento tipor = TipoRiconoscimento.valueOf(TipoRiconoscimento.class, tipo);
			result = new Riconoscimento (rs1.getInt(3), rs1.getString(4), tipor, rs1.getInt(1), rs1.getString(5));
			
		} catch (Exception e) {e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public ArrayList<Riconoscimento> selectAllOrderByData() {
		
		ArrayList<Riconoscimento> result = new ArrayList<>();
				
		Statement st1;
		ResultSet rs1;
				
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " +SCHEMA + " ORDER BY ANNO";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(2);
				if(tipo.equals("" + TipoRiconoscimento.Coppa)  || tipo.equals("" + TipoRiconoscimento.Trofeo)) {
					TipoRiconoscimento tipor = TipoRiconoscimento.valueOf(TipoRiconoscimento.class, tipo);
					Riconoscimento r = new Riconoscimento (rs1.getInt(3), rs1.getString(4), tipor, rs1.getInt(1), rs1.getString(5));
					result.add(r);
				}
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
			result = null;
		}
				
		return result;
	}
	
}
