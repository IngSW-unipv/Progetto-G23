package it.unipv.sfw.model.store;

import java.util.ArrayList;
import java.util.HashMap;

import it.unipv.sfw.dao.StoreItemDAO;


/**
 * Classe che rappresenta lo Store del sito per l'acquisto del {@link Merchandising}.
 * @author Federico Romano
 * @see Merchandising
 */
public class StoreOnline {
	private ArrayList<Merchandising> archivioMerch;
	private HashMap<Merchandising, Integer> carrello;

	public StoreOnline(HashMap<Merchandising, Integer> carrello) {
		archivioMerch = new StoreItemDAO().selectStillInStock();
		archivioMerch.sort(null);
		this.carrello = carrello;
	}
	
	/**
	 * Funzione che permette di aggiungere un merch passandolo come parametro.
	 * @param merchItem Item da aggiungere allo store.
	 */
	public void addMerch(Merchandising merchItem) {
		archivioMerch.add(merchItem);
		archivioMerch.sort(null);
	}

	/**
	 * Funzione che permette di rimuovere totalmente dallo store 
	 * il merch passato come parametro
	 * @param merchItem Item da rimuovere dallo store.
	 */
	public void removeMerch(Merchandising merchItem) {
		for (Merchandising merch : archivioMerch) {
			if (merch.compareTo(merchItem) == 0) {
				archivioMerch.remove(merchItem);
			}
		}
	}
	
	/**
	 * Funzione che permette di aggiungere un merch al carrello passandolo come parametro.
	 * @param merchItem Item da aggiungere al carrello.
	 */
	public void addMerchToCart(Merchandising merchItem) {
		if (carrello.containsKey(merchItem)) {
			carrello.put(merchItem, carrello.get(merchItem) + 1);
		} else {
			carrello.put(merchItem, 1);
		}
	}

	/**
	 * @return ArrayList ordinato per id degli items presenti nello store.
	 */
	public ArrayList<Merchandising> getMerch() {
		return archivioMerch;
	}
	
	/**
	 * @return HashMap degli items presenti nel carrello.
	 */
	public HashMap<Merchandising, Integer> getCart() {
		return carrello;
	}
	
}