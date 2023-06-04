package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.dao.ICartaPagamentoDAO;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.pagamento.Carta;

public class CartaPagamentoDAO implements ICartaPagamentoDAO{

	private static final String SCHEMA = "CARTA_PAGAMENTO";
	
	@Override
	public ArrayList<Carta> selectAll() {
			
		ArrayList<Carta> result= new ArrayList<>();
			
		Statement st1;
		ResultSet rs1;
			
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();	
			
			st1 = conn.createStatement();
			String query = "SELECT NOME, COGNOME, NUMERO, SCADENZA_MESE, SCADENZA_ANNO"
						 + "FROM " + SCHEMA + " WHERE A = EMAIL";
			
			
			rs1 = st1.executeQuery(query);
				
			while(rs1.next()) {
				Carta carta = new Carta(rs1.getString(1), rs1.getString(2), rs1.getInt(3), rs1.getInt(4), rs1.getInt(5), 0);
				result.add(carta);
			}
			
		} catch (Exception e){e.printStackTrace();}
		
		return result;
	}
	
	@Override
	public boolean insertCarta(Carta carta) {
		
		PreparedStatement st1;
		boolean esito = true;
		
		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();
			
			String query = "INSERT INTO " + SCHEMA + "(EMAIL, NOME, COGNOME, NUMERO, SCADENZA_MESE, SCADENZA_ANNO) VALUES(?,?,?,?,?,?)";
			st1 = conn.prepareStatement(query);
			
			st1.setString(1, Sessione.getIstance().getCurrentUtente().getEmail());
			st1.setString(2, carta.getNome());
			st1.setString(3, carta.getCognome());
			st1.setInt(4, carta.getnCartaCredito());
			st1.setInt(5, carta.getMeseScadenza());
			st1.setInt(6, carta.getAnnoScadenza());
			
			st1.executeUpdate(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		} 
		
		return esito;
	}

}
