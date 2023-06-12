package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import it.unipv.sfw.dao.IBigliettoMuseoDAO;
import it.unipv.sfw.model.biglietti.Biglietto;
import it.unipv.sfw.model.utente.Cliente;

/**
 * Classe DAO per {@link it.unipv.sfw.model.biglietto.Biglietto}. 
 * @author Federico Romano
 * @see it.unipv.sfw.model.biglietti.Biglietto
 */
public class BigliettoMuseoDAO implements IBigliettoMuseoDAO {
	
	private static final String SCHEMA = "BIGLIETTI_MUSEO";
	
	@Override
	public boolean insertBigliettiMuseo(Biglietto ticket, int numeroPersone) throws SQLIntegrityConstraintViolationException{
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " (EMAIL, EMAIL_CONFERMA, NUMERO_PERSONE, DAT, ORA) VALUES(?,?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + ticket.getEmail());
			st1.setString(2, "" + ticket.getEmailConferma());
			st1.setInt(3, numeroPersone);
			st1.setDate(4, new java.sql.Date(ticket.getData().getTimeInMillis()));
			st1.setTime(5, ticket.getOra());
			
			st1.executeUpdate(); 
			
		} catch (SQLException e) {
			throw new SQLIntegrityConstraintViolationException();
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}
		
		return esito;
	}
	
	@Override 
	public void removeLast() {
		
		Statement st1;
		
		try (
			DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			st1 = conn.createStatement();
			String query = "DELETE FROM " + SCHEMA + " ORDER BY NUMERO DESC LIMIT 1";
			st1.executeUpdate(query);
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<Biglietto> selectAll() {
		
		ArrayList<Biglietto> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA;
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String str = rs1.getString(4);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ITALY);
				cal.setTime(sdf.parse(str));
				Biglietto c = new Biglietto(rs1.getString(1), rs1.getString(2), rs1.getDouble(3)* Biglietto.prezzoMuseo , cal, rs1.getTime(5));
				result.add(c);
			}
			
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
	

}
