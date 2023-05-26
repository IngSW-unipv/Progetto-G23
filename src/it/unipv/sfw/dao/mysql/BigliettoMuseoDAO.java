package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.unipv.sfw.dao.IBigliettoMuseoDAO;
import it.unipv.sfw.model.biglietti.Biglietto;

/**
 * Classe DAO per {@link it.unipv.sfw.model.biglietto.Biglietto}. 
 * @author Federico Romano
 * @see it.unipv.sfw.model.biglietti.Biglietto
 */
public class BigliettoMuseoDAO implements IBigliettoMuseoDAO {
	
	private static final String SCHEMA = "BIGLIETTIMUSEO";
	
	@Override
	public boolean insertBigliettiMuseo(Biglietto ticket) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " (EMAIL, DATA, ORA) VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + ticket.getEmail());
			st1.setString(2, "" + ticket.getData());
			st1.setTime(3, ticket.getOra());
			
			st1.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}

}
