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
	 * Funzione che permette di aggiungere un merch di una certa quantità passandoli come parametri.
	 * @param merchItem Item da aggiungere allo store.
	 * @param quantita Numero di quell'item da aggiungere.
	 */
	public void addMerch(Merchandising merchItem, int quantita) {
		int i;
		for (i = 0; i < quantita; i++) {
			archivioMerch.add(merchItem);
		}
	}

	/**
	 * Funzione che permette di rimuovere totalmente dallo store 
	 * il merch passato come parametro
	 * @param merchItem Item da aggiungere allo store.
	 */
	public void removeMerch(Merchandising merchItem) {
		for (Merchandising merch : archivioMerch) {
			if (merch.compareTo(merchItem) == 0) {
				archivioMerch.remove(merchItem);
			}
		}
	}

	/**
	 * @param merchItem Item da aggiungere allo store.
	 * @return Il numero di merch uguali a quello passato
	 * come parametro ancora disponibili.
	 */
	public int getDisponibilita(Merchandising merchItem) {
		int itemCount = 0;
		for (Merchandising merch : archivioMerch) {
			if (merch.compareTo(merchItem) == 0) {
				itemCount++;
			}
		}
		return itemCount;
	}
}
