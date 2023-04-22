package it.unipv.sfw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente.Type;

public class PartitaDAO implements IPartitaDAO {

	private String schema;
	private Connection conn;
	final int bigliettiTot = 80000;
	
	public PartitaDAO() {
		super();
		this.schema = "PARTITE";  //(data, ospite, biglietti rimanenti)
	}
	
	@Override
	public ArrayList<Partita> selectAll() {
		
		ArrayList<Partita> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd / MMM / YYYY - hh:mm", Locale.ITALY);
			st1 = conn.createStatement();
			String query = "SELECT * FROM PARTITE";
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
		
		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public Partita selectPartitaByData(Calendar dataPartita) {
		
		Partita result = null;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd / MMM / YYYY - hh:mm", Locale.ITALY);
			
			String query = "SELECT * FROM PARTITE WHERE DATA=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + dataPartita);
			
			rs1 = st1.executeQuery(query);
			
			
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
		
		DBConnection.closeConnection(conn);
		return result;
	}
	
	@Override
	public boolean insertPartita(Partita newPartita) {
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO PARTITE VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, newPartita.getData());
			st1.setString(2, newPartita.getOspiti());
			st1.setInt(3, bigliettiTot);	
			
			st1.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
	
	@Override
	public boolean updatePartita(Partita newPartita) {
		
		conn = DBConnection.startConnection(conn, schema);
    	PreparedStatement st1;
    	boolean esito = true;
    	
    	IPostoDAO pDao = new PostoDAO();
    	
    	try
		{
			String query = "UPDATE PARTITE SET BIGLIETTIRIMANENTI=? WHERE DATA=?";
			st1 = conn.prepareStatement(query);
			
			st1.setInt(1, bigliettiTot - pDao.selectCount(newPartita.getCalendarDate()));
			st1.setString(2, newPartita.getData());
			
			st1.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		DBConnection.closeConnection(conn);
		return esito;
	}
}