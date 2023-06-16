package it.unipv.sfw.dao;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

import it.unipv.sfw.dao.mysql.StoreItemDAO;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.utilities.Pair;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.store.Merchandising}.
 *
 * @author Federico Romano
 * @see StoreItemDAO
 * @see it.unipv.sfw.model.store.Merchandising
 */
public interface IStoreItemDAO {

	/**
	 * @param merch Merch da eliminare.
	 * @return True se l'eliminazione è avvenuta con successo, altrimenti False.
	 */
	boolean deleteItem(Merchandising m);

	/**
	 * @param merch    Merch da inserire nel database.
	 * @param quantita Quantità relativa al Merch da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertStoreItem(Merchandising merch, int quantita);

	/**
	 * @return Tutti gli articoli registrati nel database con le relative quantità.
	 */
	HashMap<Merchandising, Integer> selectAll();

	/**
	 * @param id Id dell'articolo utilizzato come chiave di ricerca.
	 * @return L'articolo registrato nel database con l'id passato come parametro.
	 */
	Merchandising selectById(int id);

	/**
	 * @param merch Articolo il cui id viene utilizzato come chiave di ricerca.
	 * @return L'articolo registrato nel database con la relativa quantità con l'id
	 *         passato come parametro.
	 */
	SimpleEntry<Merchandising, Integer> selectById(Merchandising merch);

	/**
	 * @return Tutti gli articoli ancora in stock registrati nel database con le
	 *         relative quantità.
	 */
	HashMap<Merchandising, Integer> selectStillInStock();

	/**
	 * @param merch Merch da aggiornare.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updateItem(Pair<Merchandising, Integer> merch);

	/**
	 * @param merch     Merch di cui cambiare il campo 'prezzo'.
	 * @param newPrezzo Prezzo nuovo da inserire nel campo relativo.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updatePrezzoItem(Merchandising merch, double newPrezzo);

	/**
	 * @param merch       Merch di cui cambiare il campo 'quantitaRimnanente'.
	 * @param newQuantita Quantità nuova da inserire nel campo relativo.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updateQuantitaItem(Merchandising merch, int newQuantita);

}