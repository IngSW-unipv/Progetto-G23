package it.unipv.sfw.model.partita;

import java.util.ArrayList;

public class Stadio {

	private ArrayList<Settore> settori;
	private boolean libero;

	public Stadio() {
		libero = true;
		settori = new ArrayList<Settore>();
	}

	public void setLibero(boolean lib) {
		libero = lib;
	}

	public boolean getLibero() {
		return libero;
	}

	public void generaSettori(int nSettori) {
		for (int i = 0; i < nSettori; i++) {
			Settore s = new Settore(i);
			settori.add(s);
		}
	}

	public void addSettore() {
		settori.add(new Settore(settori.size()));
	}

	public void removeSettore() {
		settori.remove(settori.size());
	}

	public void checkLibero() {
		int lib = 0;

		for (int i = 0; i < settori.size(); i++) {
			if (settori.get(i).getLibero() == true)
				lib++;
		}

		if (lib == 0)
			libero = false;
	}

}
