package it.unipv.sfw.model.store;

import java.util.ArrayList;
import java.util.List;

import it.unipv.sfw.dao.StoreItemDAO;


/**
 * Classe che rappresenta lo Store del sito per l'acquisto del {@link Merchandising}.
 * @author Federico Romano
 * @see Merchandising
 */
public class StoreOnline {
	private ArrayList<Merchandising> archivioMerch;

	public StoreOnline() {
		archivioMerch = new StoreItemDAO().selectStillInStock();
	}
	
	/**
	 * Funzione che permette di aggiungere un merch passandolo come parametro.
	 * @param merchItem Item da aggiungere allo store.
	 */
	public void addMerch(Merchandising merchItem) {
		archivioMerch.add(merchItem);
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
	
	public ArrayList<Merchandising> getMerch() {
		return archivioMerch;
	}
}