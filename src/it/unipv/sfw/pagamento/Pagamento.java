package it.unipv.sfw.pagamento;

public class Pagamento {
	private Carta metodoPagamento;

	public Pagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	/**
	 * @return La carta usata come metodo di pagamento
	 * */
	public Carta getMetodoPagamento() {
		return metodoPagamento;
	}

	/**
	 * Funzione che cambia il metodo di pagamento.
	 * 
	 * @param metodoPagamento
	 */
	public void setMetodoPagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

}
