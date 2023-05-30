package it.unipv.sfw.pagamento;

public class Carta {
	
	private String nome, cognome, paese, dataScadenza;
	private int nCartaCredito, CVV;
	
	
	
	public Carta(String nome, String cognome, String paese, int nCartaCredito, String dataScadenza, int CVV) {
		this.cognome = cognome;
		this.CVV = CVV;
		this.nome = nome;
		this.dataScadenza = dataScadenza;
		this.nCartaCredito = nCartaCredito;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public int getCVV() {
		return CVV;
	}
	
	public String getDataScadenza() {
		return dataScadenza;
	}
	
	public int getnCartaCredito() {
		return nCartaCredito;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	public void setnCartaCredito(int nCartaCredito) {
		this.nCartaCredito = nCartaCredito;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPaese(String paese) {
		this.paese = paese;
	}
}
