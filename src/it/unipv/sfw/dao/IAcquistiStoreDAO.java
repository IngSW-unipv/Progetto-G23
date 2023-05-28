package it.unipv.sfw.dao;

import java.util.HashMap;

import it.unipv.sfw.dao.mysql.StoreItemDAO;
import it.unipv.sfw.model.store.Merchandising;

/**
 * Interfaccia DAO per gli acquisti nello store.
 * @author Federico Romano
 * @see StoreItemDAO
 * @see it.unipv.sfw.model.store.Merchandising
 */
public interface IAcquistiStoreDAO {

	/**
	 * @return Un array che contiene tutti gli acquisti registrati nel database.
	 */
	HashMap<Merchandising, Integer> selectAllWithPrice();

	/**
	 * @param item Item acquistato da inserire nel database.
	 * @param email Email dell'utente che ha effettuato l'acquisto.
	 * @param quantita Numero di item dello stesso tipo acquistati.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertAcquisto(Merchandising item, String email, int quantita);

}