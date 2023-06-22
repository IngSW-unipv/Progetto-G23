package it.unipv.sfw.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import it.unipv.sfw.dao.mysql.CartaPagamentoDAO;
import it.unipv.sfw.model.pagamento.Carta;
import it.unipv.sfw.model.utente.Utente;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.pagamento.Carta}.
 *
 * @author Lorenzo Reale
 * @see CartaPagamentoDAO
 * @see it.unipv.sfw.model.pagamento.Carta
 */
public interface ICartaPagamentoDAO {

	/**
	 * @param Carta carta da inserire nel db.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertCarta(Carta carta, Utente c) throws SQLIntegrityConstraintViolationException;

	/**
	 * @return Un arrayList che contiene tutte le carte registrate nel database.
	 */
	ArrayList<Carta> selectAll();

	/**
	 * @return Un arrayList che contiene tutte le carte possedute da un certo utente
	 *         registrate nel database.
	 */
	ArrayList<Carta> selectByUtente(Utente c);
}
