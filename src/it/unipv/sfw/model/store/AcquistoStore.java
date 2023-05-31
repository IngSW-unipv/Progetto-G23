package it.unipv.sfw.model.store;

import it.unipv.sfw.model.utente.Cliente;

/**
 * Classe che rappresenta l'acquisto di un item dello store 
 * online da parte di un Cliente.
 * @author Federico Romano
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class AcquistoStore {
	
	private Merchandising item;
	private Cliente buyer;
	private int quantita;
	
	public AcquistoStore(Merchandising item, Cliente buyer, int quantita) {
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

	public Cliente getBuyer() {
		return buyer;
	}

	public void setBuyer(Cliente buyer) {
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
