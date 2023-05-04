package it.unipv.sfw.model.store;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe che rappresenta lo Store del sito per l'acquisto del {@link Merchandising}.
 * @author Federico Romano
 * @see Merchandising
 */
public class StoreOnline {
	private List<Merchandising> archivioMerch;

	public StoreOnline() {
		archivioMerch = new ArrayList<Merchandising>();
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
	
	public List<Merchandising> getMerch() {
		return archivioMerch;
	}
}