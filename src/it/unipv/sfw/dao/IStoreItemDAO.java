package it.unipv.sfw.dao;

import java.util.HashMap;

import it.unipv.sfw.model.store.Merchandising;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.store.Merchandising}.
 * @author Federico Romano
 * @see StoreItemDAO
 * @see it.unipv.sfw.model.store.Merchandising
 */
public interface IStoreItemDAO {

	/**
	 * @param merch Merch di cui cambiare il campo 'prezzo'.
	 * @param newPrezzo Prezzo nuovo da inserire nel campo relativo.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updatePrezzoItem(Merchandising merch, double newPrezzo);

	/**
	 * @param merch Merch di cui cambiare il campo 'quantitaRimnanente'.
	 * @param newQuantita Quantità nuova da inserire nel campo relativo.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updateQuantitaItem(Merchandising merch, int newQuantita);

	/**
	 * @param merch Merch da inserire nel database.
	 * @param quantita Quantità relativa al Merch da inserire nel database. 
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertStoreItem(Merchandising merch, int quantita);
	
	/**
	 * @return Tutti gli articoli registrati nel database.
	 */
	HashMap<Merchandising, Integer> selectAll();
	
	/**
	 * @return Tutti gli articoli ancora in stock registrati nel database. 
	 */
	HashMap<Merchandising, Integer> selectStillInStock();
	
	/**
	 * @param merch Articolo il cui id viene utilizzato come chiave di ricerca.
	 * @return L'articolo registrato nel database con l'id passato come parametro.
	 */
	Merchandising selectById(Merchandising merch);

}