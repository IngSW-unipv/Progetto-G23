package it.unipv.sfw.model.partita;

import java.util.ArrayList;

public class Anello {

	private int nAnello;
	private ArrayList<Posto> posti;
	private boolean libero;

	public Anello(int nAnello) {
		this.nAnello = nAnello;
		libero = true;
		posti = new ArrayList<Posto>();
	}

	public void setLibero(boolean lib) {
		libero = lib;
	}

	public boolean getLibero() {
		return libero;
	}

	public void generaPosti(int nPosti) {
		for (int i = 0; i < nPosti; i++) {
			Posto p = new Posto(i);
			posti.add(p);
		}
	}

	public void addPosto() {
		posti.add(new Posto(posti.size()));
	}

	public void removePosto() {
		posti.remove(posti.size());
	}

	public void checkLibero() {
		int lib = 0;

		for (int i = 0; i < posti.size(); i++) {
			if (posti.get(i).getLibero() == true)
				lib++;
		}

		if (lib == 0)
			libero = false;
	}

	public int getNAnello() {
		return nAnello;
	}

}
