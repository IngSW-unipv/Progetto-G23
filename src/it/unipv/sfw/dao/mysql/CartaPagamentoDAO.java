package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.dao.ICartaPagamentoDAO;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.pagamento.Carta;

/**
 * Classe DAO per {@link it.unipv.sfw.pagammento.Carta}.
 *
 * @author Federico Romano
 * @see it.unipv.sfw.pagammento.Carta
 */
public class CartaPagamentoDAO implements ICartaPagamentoDAO {

	private static final String SCHEMA = "CARTA_PAGAMENTO";

	@Override
	public boolean insertCarta(Carta carta, Utente c) throws SQLIntegrityConstraintViolationException {

		PreparedStatement st1;
		boolean esito = true;

		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();

			String query = "INSERT INTO " + SCHEMA
					+ "(EMAIL, NOME, COGNOME, NUMERO, SCADENZA_MESE, SCADENZA_ANNO) VALUES(?,?,?,?,?,?)";
			st1 = conn.prepareStatement(query);

			st1.setString(1, c.getEmail());
			st1.setString(2, carta.getNome());
			st1.setString(3, carta.getCognome());
			st1.setLong(4, carta.getnCartaCredito());
			st1.setInt(5, carta.getMeseScadenza());
			st1.setInt(6, carta.getAnnoScadenza());

			st1.executeUpdate();

		} catch (SQLException e) {
			throw new SQLIntegrityConstraintViolationException();
		} catch (Exception e) {
			esito = false;
		}

		return esito;
	}

	@Override
	public ArrayList<Carta> selectAll() {

		ArrayList<Carta> result = new ArrayList<>();

		Statement st1;
		ResultSet rs1;

		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();

			st1 = conn.createStatement();
			String query = "SELECT NOME, COGNOME, NUMERO, SCADENZA_MESE, SCADENZA_ANNO " + "FROM " + SCHEMA;

			rs1 = st1.executeQuery(query);

			while (rs1.next()) {
				Carta carta = new Carta(rs1.getString(1), rs1.getString(2), rs1.getLong(3), rs1.getInt(4),
						rs1.getInt(5), 0);
				result.add(carta);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public ArrayList<Carta> selectByUtente(Utente c) {
		ArrayList<Carta> result = new ArrayList<>();

		PreparedStatement st1;
		ResultSet rs1;

		try (DBConnection db = new DBConnection(SCHEMA)) {
			Connection conn = db.getConnection();

			String query = "SELECT NOME, COGNOME, NUMERO, SCADENZA_MESE, SCADENZA_ANNO " + "FROM " + SCHEMA
					+ " WHERE EMAIL LIKE ?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, c.getEmail());
			rs1 = st1.executeQuery();

			while (rs1.next()) {
				Carta carta = new Carta(rs1.getString(1), rs1.getString(2), Long.parseLong(rs1.getString(3)),
						rs1.getInt(4), rs1.getInt(5), 0);
				result.add(carta);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
