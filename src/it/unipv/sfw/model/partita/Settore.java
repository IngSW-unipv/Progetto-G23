package it.unipv.sfw.model.partita;

import java.util.ArrayList;

public class Settore {

	private int nSettore;
	private ArrayList<Blocco> blocchi;
	private boolean libero;

	public Settore(int nSettore) {
		this.nSettore = nSettore;
		libero = true;
		blocchi = new ArrayList<>();
	}

	public void setLibero(boolean lib) {
		libero = lib;
	}

	public boolean getLibero() {
		return libero;
	}

	public void generaBlocchi(int nAnelli) {
		for (int i = 0; i < nAnelli; i++) {
			Blocco a = new Blocco(i);
			blocchi.add(a);
		}
	}

	public void addBlocco() {
		blocchi.add(new Blocco(blocchi.size()));
	}

	public void removeBlocco() {
		blocchi.remove(blocchi.size());
	}

	public void checkLibero() {
		int lib = 0;

		for (int i = 0; i < blocchi.size(); i++) {
			if (blocchi.get(i).getLibero() == true)
				lib++;
		}

		if (lib == 0)
			libero = false;
	}

	public int getNSettore() {
		return nSettore;
	}

}
