package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.unipv.sfw.model.museo.Riconoscimento;

public class RiconoscimentoDAO implements IRiconoscimentoDAO {

	private String schema;
	private Connection conn;
	
	public RiconoscimentoDAO() {
		super();
		this.schema = "Riconoscimenti";  //(id, TipoRiconoscimento, Anno, Descrizione)
	}
	
	@Override
	public boolean insertRiconoscimento(Riconoscimento riconoscimento) {
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO RICONOSCIMENTI VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setInt(1, riconoscimento.getId());
			st1.setString(2, riconoscimento.getTipo());
			st1.setInt(3, riconoscimento.getAnno());
			st1.setString(4, riconoscimento.getDescrizione());
			
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
			String query = "UPDATE RICONOSCIMENTI SET DESCRIZIONE=? WHERE ID=?";
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
	
}
