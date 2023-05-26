package it.unipv.sfw.model.store;

import java.util.HashMap;

import it.unipv.sfw.dao.DAOFactory;


/**
 * Classe che rappresenta lo Store del sito per l'acquisto del {@link Merchandising}.
 * @author Federico Romano
 * @see Merchandising
 */
public class StoreOnline {
	private HashMap<Merchandising, Integer> archivioMerch;
	private HashMap<Merchandising, Integer> carrello;

	/**
	 * @param carrello Carrello se ne esiste già uno, se viene passato null ne viene creato uno.
	 */
	public StoreOnline(HashMap<Merchandising, Integer> carrello) {
		archivioMerch = DAOFactory.createIStoreItemDAO().selectStillInStock();
		if (carrello == null)
			this.carrello = new HashMap<>();
		else 
			this.carrello = carrello;
	}
	
	/**
	 * Funzione che permette di aggiungere un merch passandolo come parametro.
	 * @param merchItem Item da aggiungere allo store.
	 */
	public void addMerch(Merchandising merchItem, int quantity) {
		archivioMerch.put(merchItem, quantity);
	}

	/**
	 * Funzione che permette di rimuovere totalmente dallo store 
	 * il merch passato come parametro
	 * @param merchItem Item da rimuovere dallo store.
	 */
	public void removeMerch(Merchandising merchItem) {
		archivioMerch.remove(merchItem);
	}
	
	/**
	 * Funzione che permette di aggiungere un merch al carrello passandolo come parametro.
	 * @param merchItem Item da aggiungere al carrello.
	 */
	public void addMerchToCart(Merchandising merchItem, int quantity) {
		if (carrello.containsKey(merchItem)) {
			carrello.put(merchItem, carrello.get(merchItem) + quantity);
		} else {
			carrello.put(merchItem, quantity);
		}
	}

	/**
	 * @return HashMap degli items presenti nello store.
	 */
	public HashMap<Merchandising, Integer> getMerch() {
		return archivioMerch;
	}
	
	/**
	 * @return HashMap degli items presenti nel carrello.
	 */
	public HashMap<Merchandising, Integer> getCart() {
		return carrello;
	}
	
}