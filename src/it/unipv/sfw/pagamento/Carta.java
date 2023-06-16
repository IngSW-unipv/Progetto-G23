package it.unipv.sfw.pagamento;

public class Carta {

	private String nome, cognome;
	private int CVV, meseScadenza, annoScadenza;
	private long nCartaCredito;

	public Carta(String nome, String cognome, long nCartaCredito, int meseScadenza, int annoScadenza, int CVV) {
		this.cognome = cognome;
		this.CVV = CVV;
		this.nome = nome;
		this.meseScadenza = meseScadenza;
		this.annoScadenza = annoScadenza;
		this.nCartaCredito = nCartaCredito;
	}

	public int getAnnoScadenza() {
		return annoScadenza;
	}

	public String getCognome() {
		return cognome;
	}

	public int getCVV() {
		return CVV;
	}

	public int getMeseScadenza() {
		return meseScadenza;
	}

	public long getnCartaCredito() {
		return nCartaCredito;
	}

	public String getnCartaCreditoStr() {
		return "" + nCartaCredito;
	}

	public String getNome() {
		return nome;
	}

	public void setAnnoScadenza(int annoScadenza) {
		this.annoScadenza = annoScadenza;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	public void setMeseScadenza(int meseScadenza) {
		this.meseScadenza = meseScadenza;
	}

	public void setnCartaCredito(int nCartaCredito) {
		this.nCartaCredito = nCartaCredito;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
