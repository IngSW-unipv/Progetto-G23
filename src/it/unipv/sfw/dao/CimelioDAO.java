package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

	private String schema;
	private Connection conn;
	
	public CimelioDAO() {
		super();
		this.schema = "MUSEO_ITEMS";  //(id, TipoCimelio, Anno, Descrizione)
	}
	
	@Override
	public boolean insertCimelio(Cimelio cim) {
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO " + this.schema + " VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, cim.getTipo());
			st1.setInt(2, cim.getAnno());
			st1.setString(3, cim.getDescrizione());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean updateDescrizione(Cimelio cimelio) {
		
		conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try
		{
			String query = "UPDATE " + this.schema + " SET DESCRIZIONE=? WHERE ID=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, cimelio.getDescrizione());                  
			st1.setInt(2, cimelio.getId());       
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public ArrayList<Cimelio> selectAll() {
		
		ArrayList<Cimelio> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + this.schema;
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String tipo = rs1.getString(4);
				if(tipo.equals("" + TipoCimelio.Fotografia) || tipo.equals("" + TipoCimelio.Ricordo)) {
					TipoCimelio tipoc = TipoCimelio.valueOf(TipoCimelio.class, tipo);
					Cimelio c = new Cimelio (rs1.getString(4), tipoc, rs1.getInt(1), rs1.getInt(3));
					result.add(c);
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
	public Cimelio selectById(Cimelio item) {
		
		Cimelio result = null;
		
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
				TipoCimelio tipoc = TipoCimelio.valueOf(TipoCimelio.class, tipo);
				result = new Cimelio (rs1.getString(4), tipoc, rs1.getInt(1), rs1.getInt(3));
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		DBConnection.closeConnection(conn); 
		return result;
	}

}
