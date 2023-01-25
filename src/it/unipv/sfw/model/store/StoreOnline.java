package it.unipv.sfw.model.store;

import java.util.ArrayList;
import java.util.List;

public class StoreOnline {
	private List<Merchandising> archivioMerch;

	public StoreOnline() {
		archivioMerch = new ArrayList<Merchandising>();
	}

	public void addMerch(Merchandising merchItem, int quantita) {
		int i;
		for (i = 0; i < quantita; i++) {
			archivioMerch.add(merchItem);
		}
	}

	public void removeMerch(Merchandising merchItem) {
		for (Merchandising merch : archivioMerch) {
			if (merch.compareTo(merchItem) == 0) {
				archivioMerch.remove(merchItem);
			}
		}
	}

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
