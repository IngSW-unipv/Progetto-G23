package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import it.unipv.sfw.dao.IAcquistiStoreDAO;
import it.unipv.sfw.model.store.Merchandising;

//(item id, email, quantita)
// -------  -----

/**
 * Classe DAO per gli acquisti nello store .
 * @author Federico Romano
 * @see it.unipv.sfw.model.store.Merchandising
 */
public class AcquistiStoreDAO implements IAcquistiStoreDAO {
		
	private static final String SCHEMA = "ACQUISTI_STORE";
		
	@Override
	public HashMap<Merchandising, Integer> selectAllWithPrice() {
			
		HashMap<Merchandising, Integer> result = new HashMap<>(); //chiave: item, valore: quantita acquistata
			
		Statement st1;
		ResultSet rs1;
			
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
				
			st1 = conn.createStatement();
			String query = "SELECT ITEM, BUYER, QUANTITA, NOME, PREZZO, QUANTITA_RIMANENTE, DESCRIZIONE "
					+ "FROM " + SCHEMA + " a JOIN STORE_ITEMS b on a.ITEM=b.ID";
			
			rs1 = st1.executeQuery(query);
				
			while(rs1.next()) {
				int q =  rs1.getInt(3);
				Merchandising c = new Merchandising(rs1.getString(4), rs1.getDouble(5), rs1.getInt(1), rs1.getString(7));
				result.put(c, q);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
		
	@Override
	public boolean insertAcquisto(Merchandising item, String email, int quantita) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + "(ITEM, BUYER, QUANTITA) VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setInt(1, item.getId());
			st1.setString(2, email);
			st1.setInt(3, quantita);
			
			st1.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}
		
}
