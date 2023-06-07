package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import it.unipv.sfw.dao.IPostoDAO;
import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.utente.Cliente;

/**
 * Classe DAO per {@link it.unipv.sfw.model.partita.Posto}
 * @author Federico Romano
 * @see it.unipv.sfw.model.partita.Posto
 */
public class PostoDAO implements IPostoDAO {
	
	private static final String SCHEMA = "POSTI";
	
	@Override
	public int selectCount(String email) {
		
		int numeroBiglietti = 0;
		
		PreparedStatement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT COUNT(*) FROM " + SCHEMA + " WHERE EMAIL LIKE ?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, email);
			
			rs1 = st1.executeQuery();
			
			rs1.next(); 		// A ResultSet cursor is initially positioned before the first row
			numeroBiglietti = rs1.getInt(1);
			
		} catch (Exception e){e.printStackTrace();}
		
		return numeroBiglietti;
	}
	
	@Override
	public int selectCount(Calendar dataPartita) {
		
		int numeroposti = 0;
		
		PreparedStatement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "SELECT COUNT(*) FROM " + SCHEMA + " WHERE DAT=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, "" + dataPartita);
			
			rs1 = st1.executeQuery();
			
			rs1.next(); //A ResultSet cursor is initially positioned before the first row
			numeroposti = rs1.getInt(1);
			
		} catch (Exception e){e.printStackTrace();}
		
		return numeroposti;
	}
	
	@Override
	public ArrayList<Posto> selectAllOrderBydata() {
		
		ArrayList<Posto> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();	
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ITALY);
			
			st1 = conn.createStatement();
			String query = "SELECT * FROM " + SCHEMA + " ORDER BY DAT";
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
		
		return result;
	}

	@Override
	public ArrayList<Posto> selectByData(Calendar dataPartita) {
		
		ArrayList<Posto> result = new ArrayList<>();
		
		PreparedStatement st1;
		ResultSet rs1;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ITALY);
			
			String query = "SELECT * FROM " + SCHEMA + " WHERE DAT=?";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, sdf.format(dataPartita.getTime()));
			
			rs1 = st1.executeQuery();
			
			while(rs1.next()) {
				String dateInString = rs1.getString(1);
				Date date = sdf.parse(dateInString);
				Calendar data = Calendar.getInstance();
				data = new GregorianCalendar();
				data.setTime(date);
				Posto p = new Posto(rs1.getInt(2), rs1.getInt(3), rs1.getInt(4), rs1.getInt(5), data);
				result.add(p);
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		return result;
	}

	@Override
	public boolean insertPosto(Posto posto, Cliente cliente) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + " VALUES(?,?,?,?,?,?)";
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
		
		return esito;
	}
		
}
