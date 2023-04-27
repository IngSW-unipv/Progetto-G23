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
/*
 * foto 
 * */

	private Merch tipoMerch;
	private double prezzo;
	private int id, quantita;
	private String descrizione;

	public Merchandising(Merch tipo, double prezzo, int id, int quantita, String descrizione) {
		tipoMerch = tipo;
		this.prezzo = prezzo;
		this.id = id;
		this.quantita = quantita;
		this.descrizione = descrizione;
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

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	/**
	 * Funzione che permette ridurre di un unità la quantità del prodotto.
	 */
	public void riduciQuantita() {
		quantita--;
	}
	
	/**
	 * Funzione che permette aumentare di un unità la quantità del prodotto.
	 */
	public void aumentaQuantita() {
		quantita++;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
}
