package it.unipv.sfw.pagamento;

public class Pagamento {
	private Carta metodoPagamento;

	public Pagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Carta getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

}
