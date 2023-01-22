package it.unipv.sfw.model.partita;

public class Posto {

	private int nPosto;
	private boolean libero;

	public Posto(int nPosto) {
		this.nPosto = nPosto;
		libero = true;
	}

	public void setLibero(boolean lib) {
		libero = lib;
	}

	public boolean getLibero() {
		return libero;
	}

	public int getNPosto() {
		return nPosto;
	}
}
