package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.unipv.sfw.dao.IAbbonamentoDAO;
import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Cliente;

/**
 * Classe DAO per {@link it.unipv.sfw.model.abbonamento.Abbonamento}.
 * @author Federico Romano
 * @see TipoAbb
 * @see it.unipv.sfw.model.abbonamento.Abbonamento
 */
public class AbbonamentoDAO implements IAbbonamentoDAO {
	
	private static final String SCHEMA = "ABBONAMENTI";
	
    @Override
	public boolean insertAbbonamento(Cliente nuovoAbbonato) {

    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
    		Connection conn = db.getConnection();
    		
			String query = "INSERT INTO " +  SCHEMA + " VALUES(?,?)";
			st1 = conn.prepareStatement(query);

			st1.setString(1, nuovoAbbonato.getEmail());
			st1.setString(2, nuovoAbbonato.getAbb().getTipoAbb().toString());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
       
    @Override
	public boolean updateAbbonamento(Cliente nuovoAbbonato, TipoAbb livello) {
    	
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
    		Connection conn = db.getConnection();
    		
			String query = "UPDATE " +  SCHEMA + " SET LIVELLO=? WHERE EMAIL=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + livello);
			st1.setString(2, nuovoAbbonato.getEmail());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
    	
		return esito;
	}
    	
}
	

