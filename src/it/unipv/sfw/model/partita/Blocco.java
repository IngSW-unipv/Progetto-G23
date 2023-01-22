package it.unipv.sfw.model.partita;

import java.util.ArrayList;

public class Blocco {

	private int nBlocco;
	private ArrayList<Anello> anelli;
	private boolean libero;

	public Blocco(int nBlocco) {
		this.nBlocco = nBlocco;
		libero = true;
		anelli = new ArrayList<Anello>();
	}

	public void setLibero(boolean lib) {
		libero = lib;
	}

	public boolean getLibero() {
		return libero;
	}

	public void generaAnelli(int nAnelli) {
		for (int i = 0; i < nAnelli; i++) {
			Anello a = new Anello(i);
			anelli.add(a);
		}
	}

	public void addAnello() {
		anelli.add(new Anello(anelli.size()));
	}

	public void removeAnello() {
		anelli.remove(anelli.size());
	}

	public void checkLibero() {
		int lib = 0;

		for (int i = 0; i < anelli.size(); i++) {
			if (anelli.get(i).getLibero() == true)
				lib++;
		}

		if (lib == 0)
			libero = false;
	}

	public int getNBlocco() {
		return nBlocco;
	}

}
