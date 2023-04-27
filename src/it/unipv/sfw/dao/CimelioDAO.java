package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import it.unipv.sfw.model.museo.Cimelio;

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
		this.schema = "CIMELI";  //(id, TipoCimelio, Anno, Descrizione)
	}
	
	@Override
	public boolean insertCimelio(Cimelio cim) {
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO CIMELI VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setInt(1, cim.getId());
			st1.setString(2, cim.getTipo());
			st1.setInt(3, cim.getAnno());
			st1.setString(4, cim.getDescrizione());
			
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
			String query = "UPDATE CIMELI SET DESCRIZIONE=? WHERE ID=?";
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

}
