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

	public Merchandising getItem() {
		return item;
	}

	public void setItem(Merchandising item) {
		this.item = item;
	}

	public Utente getBuyer() {
		return buyer;
	}

	public void setBuyer(Utente buyer) {
		this.buyer = buyer;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	@Override
	public boolean equals(Object other) {
		return (item.getId() == ((AcquistoStore)other).getItem().getId() && 
				buyer.getEmail().equals(((AcquistoStore)other).getBuyer().getEmail()));
	}
	
}
