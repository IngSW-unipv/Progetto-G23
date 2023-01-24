package it.unipv.sfw.model.biglietti;

public class Biglietto {

	private double prezzo;
	
	public Biglietto(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public double getPrezzo() {
		return prezzo;
	}
}
