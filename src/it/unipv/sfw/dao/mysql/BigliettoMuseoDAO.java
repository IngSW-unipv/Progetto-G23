package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import it.unipv.sfw.dao.IBigliettoMuseoDAO;
import it.unipv.sfw.model.biglietti.Biglietto;

/**
 * Classe DAO per {@link it.unipv.sfw.model.biglietto.Biglietto}. 
 * @author Federico Romano
 * @see it.unipv.sfw.model.biglietti.Biglietto
 */
public class BigliettoMuseoDAO implements IBigliettoMuseoDAO {
	
	private static final String SCHEMA = "BIGLIETTI_MUSEO";
	
	@Override
	public boolean insertBigliettiMuseo(Biglietto ticket, int numeroPersone, String emailConferma) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " (EMAIL, EMAIL_CONFERMA, NUMERO_PERSONE, DAT, ORA) VALUES(?,?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + ticket.getEmail());
			st1.setString(2, "" + emailConferma);
			st1.setInt(3, numeroPersone);
			st1.setDate(4, new java.sql.Date(ticket.getData().getTimeInMillis()));
			st1.setTime(5, ticket.getOra());
			
			st1.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}

}
