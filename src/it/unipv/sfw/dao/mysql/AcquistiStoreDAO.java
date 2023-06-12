package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.dao.IAcquistiStoreDAO;
import it.unipv.sfw.dao.IClienteDAO;
import it.unipv.sfw.model.store.AcquistoStore;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Cliente;

/**
 * Classe DAO per gli acquisti nello store .
 * @author Federico Romano
 * @see it.unipv.sfw.model.store.Merchandising
 */
public class AcquistiStoreDAO implements IAcquistiStoreDAO {
		
	private static final String SCHEMA = "ACQUISTI_STORE";
		
	@Override
	public ArrayList<AcquistoStore> selectAllWithPrice() {
			
		ArrayList<AcquistoStore> result= new ArrayList<>();
			
		Statement st1;
		ResultSet rs1;
			
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();	
			
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ITALY);
			st1 = conn.createStatement();
			String query = "SELECT ITEM, BUYER, QUANTITA, B.NOME, PREZZO, QUANTITA_RIMANENTE, DESCRIZIONE,"
					+ " C.NOME, COGNOME, PASS, NASCITA "
					+ "FROM " + SCHEMA + " A JOIN STORE_ITEMS B on A.ITEM=B.ID JOIN UTENTI C on A.BUYER=C.EMAIL";
			
			rs1 = st1.executeQuery(query);
				
			while(rs1.next()) {
				
				Merchandising m = new Merchandising(rs1.getString(4), rs1.getDouble(5), rs1.getInt(1), rs1.getString(7));
				
				String dateInString = rs1.getString(11);
				Date date = (Date) sdf.parse(dateInString);
				Calendar data = Calendar.getInstance();
				data = new GregorianCalendar();
				data.setTime(date);
				Cliente c = new Cliente(rs1.getString(8), rs1.getString(9), rs1.getString(2), rs1.getString(10), data);
				
				AcquistoStore a = new AcquistoStore(m, c, rs1.getInt(3));
				
				result.add(a);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
		
	@Override
	public boolean insertAcquisto(AcquistoStore acquisto) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + "(ITEM, BUYER, QUANTITA) VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setInt(1, acquisto.getItem().getId());
			st1.setString(2, acquisto.getBuyer().getEmail());
			st1.setInt(3, acquisto.getQuantita());
			
			st1.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
		
}
