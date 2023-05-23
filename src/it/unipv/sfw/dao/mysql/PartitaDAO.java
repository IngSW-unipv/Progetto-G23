package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import it.unipv.sfw.dao.DBConnection;
import it.unipv.sfw.dao.IPartitaDAO;
import it.unipv.sfw.dao.IPostoDAO;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.partita.Partita.Squadre;

/**
 * Classe DAO per {@link it.unipv.sfw.model.partita.Partita}.
 * @author Federico Romano
 * @see it.unipv.sfw.model.partita.Partita
 */
public class PartitaDAO implements IPartitaDAO {

	private static final String SCHEMA = "PARTITE";
	private final int bigliettiTot = 80000;
	
	@Override
	public ArrayList<Partita> selectAll() {
		
		ArrayList<Partita> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss", Locale.ITALY);
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA;
			rs1 = st1.executeQuery(query);
			
			
			while(rs1.next()) {
				
				String dateInString = rs1.getString(1);
				Date date = (Date) sdf.parse(dateInString);
				Calendar data = Calendar.getInstance();
				data = new GregorianCalendar();
				data.setTime(date);
				
				Squadre ospiti = Squadre.valueOf(Squadre.class, rs1.getString(2));
				
				Partita p = new Partita(data, ospiti);
				result.add(p);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}

	@Override
	public Partita selectPartitaByData(Calendar dataPartita) {
		
		Partita result = null;
		
		PreparedStatement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss", Locale.ITALY);
			
			String query = "SELECT * FROM " + SCHEMA + " WHERE DATA=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + dataPartita);
			
			rs1 = st1.executeQuery();
			
			rs1.next();
				
			String dateInString = rs1.getString(1);
			Date date = (Date) sdf.parse(dateInString);
			Calendar data = Calendar.getInstance();
			data = new GregorianCalendar();
			data.setTime(date);
			Squadre ospiti = Squadre.valueOf(Squadre.class, rs1.getString(2));
				
			Partita p = new Partita(data, ospiti);
			result = p;
		
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public boolean insertPartita(Partita newPartita) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, newPartita.getData());
			st1.setString(2, newPartita.getOspiti());
			st1.setInt(3, bigliettiTot);	
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
	
	@Override
	public boolean updatePartita(Partita newPartita) {
		
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	IPostoDAO pDao = new PostoDAO();
    	
    	try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "UPDATE " + SCHEMA + " SET BIGLIETTIRIMANENTI=? WHERE DATA=?";
			st1 = conn.prepareStatement(query);
			
			st1.setInt(1, bigliettiTot - pDao.selectCount(newPartita.getCalendarDate()));
			st1.setString(2, newPartita.getData());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
    	
		return esito;
	}
}
