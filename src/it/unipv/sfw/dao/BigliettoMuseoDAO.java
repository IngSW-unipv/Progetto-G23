package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import it.unipv.sfw.model.biglietti.Biglietto;


public class BigliettoMuseoDAO implements IBigliettoMuseoDAO {
	
	private String schema;
	private Connection conn;
	
	public BigliettoMuseoDAO() {
		super();
		this.schema = "BIGLIETTIMUSEO";  //(email, data, ora)
	}
	
@Override
public boolean insertBigliettiMuseo(Biglietto ticket) {
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO BIGLIETTIMUSEO (EMAIL, DATA, ORA) VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + ticket.getEmail());
			st1.setString(2, "" + ticket.getData());
			st1.setTime(3, ticket.getOra());
			
			st1.executeUpdate(query); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}

}
