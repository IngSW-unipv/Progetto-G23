package it.unipv.sfw.model.store;


/**
 * Classe che rappresenta il prodotto acquistabile dallo {@link StoreOnline}.
 * @author Federico Romano
 * @see StoreOnline
 */
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

	/**
	 * Funzione che permette di cambiare il tipo del merch a quello passato come parametro.
	 * @param tipo Tipo del Merch.
	 */
	public void setTipoMerch(Merch tipo) {
		tipoMerch = tipo;
	}

	/**
	 * Funzione che permette di cambiare il prezzo del merch a quello passato come parametro.
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * @return Il tipo del merch.
	 */
	public Merch getTipoMerch() {
		return tipoMerch;
	}

	/**
	 * @return Il prezzo del merch.
	 */
	public double getPrezzo() {
		return prezzo;
	}

	@Override
	public int compareTo(Merchandising o) {
		return ((tipoMerch).compareTo(o.tipoMerch));
	}
}
