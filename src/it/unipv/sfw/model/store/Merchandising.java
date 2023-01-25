package it.unipv.sfw.model.store;

public class Merchandising implements Comparable<Merchandising> {
	public enum Merch {
		MAGLIETTA, CAPPELLO, SCIARPA, TUTA, PANTALONCINI, CALZETTONI, TSHIRT;
	}

	private Merch tipoMerch;
	private double prezzo;

	public Merchandising(Merch tipo, double prezzo) {
		tipoMerch = tipo;
		this.prezzo = prezzo;
	}

	public void setTipoMerch(Merch tipo) {
		tipoMerch = tipo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Merch getTipoMerch() {
		return tipoMerch;
	}

	public double getPrezzo() {
		return prezzo;
	}

	@Override
	public int compareTo(Merchandising o) {
		return ((tipoMerch).compareTo(o.tipoMerch));
	}
}
