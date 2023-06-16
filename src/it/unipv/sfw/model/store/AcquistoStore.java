package it.unipv.sfw.model.store;

import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente;

/**
 * Classe che rappresenta l'acquisto di un item dello store 
 * online da parte di un Cliente.
 * @author Federico Romano
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class AcquistoStore {
	
	private Merchandising item;
	private Utente buyer;
	private int quantita;
	
	public AcquistoStore(Merchandising item, Utente buyer, int quantita) {
		this.setItem(item);
		this.setBuyer(buyer);
		this.setQuantita(quantita);
	}

	/**
	 * @return L'item acquistato.
	 */
	public Merchandising getItem() {
		return item;
	}

	/**
	 * @param item Item da mettere nell'acquisto.
	 */
	public void setItem(Merchandising item) {
		this.item = item;
	}

	/**
	 * @return L'utente che ha effettuato l'acquisto.
	 */
	public Utente getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer L'utente che effettua l'acquisto.
	 */
	public void setBuyer(Utente buyer) {
		this.buyer = buyer;
	}

	/**
	 * @return La quantità di item acquistata.
	 */
	public int getQuantita() {
		return quantita;
	}

	/**
	 * @param quantita Quantità di item acquistata.
	 */
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	@Override
	public boolean equals(Object other) {
		return (item.getId() == ((AcquistoStore)other).getItem().getId() && 
				buyer.getEmail().equals(((AcquistoStore)other).getBuyer().getEmail()));
	}
	
}
