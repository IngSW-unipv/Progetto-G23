package it.unipv.sfw.model.store;

/**
 * Classe che rappresenta il prodotto acquistabile dallo {@link StoreOnline}.
 * @author Federico Romano
 * @see StoreOnline
 */
public class Merchandising implements Comparable<Merchandising> {

	private String nome;
	private double prezzo;
	private int id;
	private String descrizione;

	public Merchandising(String nome, double prezzo, int id, String descrizione) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.id = id;
		this.descrizione = descrizione;
	}

	/**
	 * Funzione che permette di cambiare il nome del merch a quello passato come parametro.
	 * @param nome Nome del Merch.
	 */
	public void setNomeMerch(String nome) {
		this.nome = nome;
	}

	/**
	 * Funzione che permette di cambiare il prezzo del merch a quello passato come parametro.
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * @return Il nome del merch.
	 */
	public String getTipoMerch() {
		return nome;
	}

	/**
	 * @return Il prezzo del merch.
	 */
	public double getPrezzo() {
		return prezzo;
	}
	
	/**
	 * @return Il nome dell'item.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return L'id dell'item.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Metodo che cambia la descrizione dell'item.
	 * @param descrizione Descrizione da associare all'item.
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * @return La descrizione dell'item.
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public int compareTo(Merchandising o) {
		return id - o.id;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.id == ((Merchandising)other).getId();
	}
}
