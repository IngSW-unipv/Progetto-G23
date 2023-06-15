package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.unipv.sfw.dao.IAbbonamentoDAO;
import it.unipv.sfw.model.abbonamento.Abbonamento;
import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente;

/**
 * Classe DAO per {@link it.unipv.sfw.model.abbonamento.Abbonamento}.
 * @author Federico Romano
 * @see TipoAbb
 * @see it.unipv.sfw.model.abbonamento.Abbonamento
 */
public class AbbonamentoDAO implements IAbbonamentoDAO {
	
	private static final String SCHEMA = "ABBONAMENTI";
	
	@Override
	public Abbonamento selectAbbonamentoOfClient(Cliente c) {

    	PreparedStatement st1;
    	ResultSet rs1;
    	Abbonamento res = null;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
    		Connection conn = db.getConnection();
    		
			String query = "SELECT GRADO FROM " + SCHEMA + " WHERE EMAIL=?";
			st1 = conn.prepareStatement(query);

			st1.setString(1, c.getEmail());
			rs1 = st1.executeQuery();
			
			if (rs1.next()) {
				res = new Abbonamento(TipoAbb.valueOf(rs1.getString(1)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return res;
	}
	
	@Override
	public Abbonamento selectAbbonamentoOfUtente(Utente u) {

    	PreparedStatement st1;
    	ResultSet rs1;
    	Abbonamento res = null;
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
    		Connection conn = db.getConnection();
    		
			String query = "SELECT GRADO FROM " + SCHEMA + " WHERE EMAIL=?";
			st1 = conn.prepareStatement(query);

			st1.setString(1, u.getEmail());
			rs1 = st1.executeQuery();
			
			if (rs1.next()) {
				res = new Abbonamento(TipoAbb.valueOf(rs1.getString(1)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return res;
	}
	
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
    		
			String query = "UPDATE " +  SCHEMA + " SET GRADO=? WHERE EMAIL=?";
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
	

