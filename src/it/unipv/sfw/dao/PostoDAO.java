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

import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente.Type;

/**
 * Classe DAO per {@link it.unipv.sfw.model.partita.Posto}
 * @author Federico Romano
 * @see it.unipv.sfw.model.partita.Posto
 */
public class PostoDAO implements IPostoDAO {
	
	private String schema;
	private Connection conn;
	
	public PostoDAO() {
		super();
		this.schema = "POSTI";  //(data, settore, blocco, anello, posto, email)
	}
	
	@Override
	public int selectCount(String email) {
		
		int numeroBiglietti = 0;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query = "SELECT COUNT(*) FROM " + this.schema + " WHERE EMAIL LIKE ?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, email);
			
			rs1 = st1.executeQuery();
			
			rs1.next(); //A ResultSet cursor is initially positioned before the first row
			numeroBiglietti = rs1.getInt(1);
			
		} catch (Exception e){e.printStackTrace();}
		
		DBConnection.closeConnection(conn);
		return numeroBiglietti;
	}
	
	@Override
	public int selectCount(Calendar dataPartita) {
		
		int numeroposti = 0;
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;
		
		try
		{
			String query = "SELECT COUNT(*) FROM " + this.schema + " WHERE DATA=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + dataPartita);
			
			rs1 = st1.executeQuery();
			
			rs1.next(); //A ResultSet cursor is initially positioned before the first row
			numeroposti = rs1.getInt(1);
			
		} catch (Exception e){e.printStackTrace();}
		
		DBConnection.closeConnection(conn);
		return numeroposti;
	}
	
	@Override
	public ArrayList<Posto> selectAllOrderBydata() {	//posti occupati
		
		ArrayList<Posto> result = new ArrayList<>();
		
		conn = DBConnection.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;
		
		try
		{	
			SimpleDateFormat sdf = new SimpleDateFormat("dd / MMM / YYYY - hh:mm", Locale.ITALY);
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + this.schema + " ORDER BY DATA";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				String dateInString = rs1.getString(1);
				Date date = (Date) sdf.parse(dateInString);
				Calendar data = Calendar.getInstance();
				data = new GregorianCalendar();
				data.setTime(date);
				Posto p = new Posto(rs1.getInt(2), rs1.getInt(3), rs1.getInt(4), rs1.getInt(5), data);
				result.add(p);
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		DBConnection.closeConnection(conn);
		return result;
	}


	@Override
	public boolean insertPosto(Posto posto, Cliente cliente) {
		
		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;
		boolean esito = true;
		
		try
		{
			String query = "INSERT INTO " + this.schema + " VALUES(?,?,?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1,"" + posto.getData());
			st1.setInt(2, posto.getNSettore());
			st1.setInt(3, posto.getNBlocco());
			st1.setInt(4, posto.getNAnello());
			st1.setInt(5, posto.getNPosto());
			st1.setString(6, cliente.getEmail());
			
			st1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}
		
		DBConnection.closeConnection(conn);
		return esito;
	}
		
}
