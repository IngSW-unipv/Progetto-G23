package it.unipv.sfw.model.biglietti;

/**
 * Classe che rappresenta il biglietto acquistabile dal {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */

public class Biglietto {

	private double prezzo;
	
	public Biglietto(double prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * Funzione utilizzata per cambiare il prezzo del biglietto.
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return Il prezzo del biglietto.
	 */
	public double getPrezzo() {
		return prezzo;
	}
}
