package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.dao.mysql.StoreItemDAO;
import it.unipv.sfw.model.store.AcquistoStore;

/**
 * Interfaccia DAO per gli acquisti nello store.
 *
 * @author Federico Romano
 * @see StoreItemDAO
 * @see it.unipv.sfw.model.store.Merchandising
 */
public interface IAcquistiStoreDAO {

	/**
	 * @param item     Item acquistato da inserire nel database.
	 * @param email    Email dell'utente che ha effettuato l'acquisto.
	 * @param quantita Numero di item dello stesso tipo acquistati.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertAcquisto(AcquistoStore acquisto);

	/**
	 * @return Un array che contiene tutti gli acquisti registrati nel database.
	 */
	ArrayList<AcquistoStore> selectAllWithPrice();

}