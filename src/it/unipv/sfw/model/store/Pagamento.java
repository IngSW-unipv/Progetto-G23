package it.unipv.sfw.model.store;

import java.util.ArrayList;
import java.util.HashMap;

public class Pagamento {
	
	private int prezzo;
	private Carta metodoPagamento;
	
	public Pagamento(int prezzo, Carta metodoPagamento) {
		this.prezzo = prezzo;
		this.metodoPagamento = metodoPagamento;
	}
	
	public Carta getMetodoPagamento() {
		return metodoPagamento;
	}
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public void setMetodoPagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

}
