package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

	private String schema;
	private Connection conn;
	
	public RiconoscimentoDAO() {
		super();
		this.schema = "MUSEO_ITEMS";  //(id, TipoRiconoscimento, Anno, Descrizione, imgid)
	}
	
	@Override
	public boolean insertRiconoscimento(Riconoscimento riconoscimento) {
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO " + this.schema + " VALUES(?,?,?,?)";
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
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean updateDescrizione(Riconoscimento riconoscimento) {
		
		conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try
		{
			String query = "UPDATE " + this.schema + " SET DESCRIZIONE=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, riconoscimento.getDescrizione());                  
			st1.setInt(2, riconoscimento.getId());       
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public ArrayList<Riconoscimento> selectAll() {
		
		ArrayList<Riconoscimento> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + this.schema;
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(2);
				if(tipo.equals("" + TipoCimelio.Fotografia) || tipo.equals("" + TipoCimelio.Ricordo)) {} 
				else {
					TipoRiconoscimento tipor = TipoRiconoscimento.valueOf(TipoRiconoscimento.class, tipo);
					Riconoscimento r = new Riconoscimento (rs1.getInt(3), rs1.getString(4), tipor, rs1.getInt(1), rs1.getString(5));
					result.add(r);
				}
			}
			
			
		} catch (Exception e){
			
			e.printStackTrace();
			result = null;
		}
		
		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public Riconoscimento selectById(Riconoscimento item) {
		
		Riconoscimento result = null;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
	
		try
		{
			String query = "SELECT * FROM " + this.schema + " WHERE ID=?";
			st1 = conn.prepareStatement(query);
			st1.setInt(1, item.getId());
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				String tipo = rs1.getString(2);
				TipoRiconoscimento tipor = TipoRiconoscimento.valueOf(TipoRiconoscimento.class, tipo);
				result = new Riconoscimento (rs1.getInt(3), rs1.getString(4), tipor, rs1.getInt(1), rs1.getString(5));
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		DBConnection.closeConnection(conn); 
		return result;
	}
	
	@Override
	public ArrayList<Riconoscimento> selectAllOrderByData() {
		
		
		ArrayList<Riconoscimento> result = new ArrayList<>();
				
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
				
		try
		{
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + this.schema + " ORDER BY ANNO";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(2);
				if(tipo.equals("" + TipoCimelio.Fotografia) || tipo.equals("" + TipoCimelio.Ricordo)) {} 
				else {
					TipoRiconoscimento tipor = TipoRiconoscimento.valueOf(TipoRiconoscimento.class, tipo);
					Riconoscimento r = new Riconoscimento (rs1.getInt(3), rs1.getString(4), tipor, rs1.getInt(1), rs1.getString(5));
					result.add(r);
				}
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
			result = null;
		}
				
		DBConnection.closeConnection(conn);
		return result;
	}
	
}
