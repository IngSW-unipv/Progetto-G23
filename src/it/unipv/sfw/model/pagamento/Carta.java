package it.unipv.sfw.model.pagamento;

/**
 * Classe che rappresenta una carta di pagamento.
 *
 * @author Lorenzo Reale
 */
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

	/**
	 * @return Anno di scadenza della carta.
	 */
	public int getAnnoScadenza() {
		return annoScadenza;
	}

	/**
	 * @return Cognome del proprietario della carta.
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @return Cvv della carta.
	 */
	public int getCVV() {
		return CVV;
	}

	/**
	 * @return Mese di scadenza della carta.
	 */
	public int getMeseScadenza() {
		return meseScadenza;
	}

	/**
	 * @return Numero della carta.
	 */
	public long getnCartaCredito() {
		return nCartaCredito;
	}

	/**
	 * @return Numero della carta come stringa.
	 */
	public String getnCartaCreditoStr() {
		return "" + nCartaCredito;
	}

	/**
	 * @return Nome del proprietario della carta.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Funzione che cambia l'anno di scadenza della carta.
	 * 
	 * @param annoScadenza
	 */
	public void setAnnoScadenza(int annoScadenza) {
		this.annoScadenza = annoScadenza;
	}

	/**
	 * Funzione che cambia il cognome del proprietario della carta.
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Funzione che cambia il cvv della carta.
	 * 
	 * @param cVV
	 */
	public void setCVV(int cVV) {
		CVV = cVV;
	}

	/**
	 * Funzione che cambia il mese di scadenza della carta.
	 * 
	 * @param meseScadenza
	 */
	public void setMeseScadenza(int meseScadenza) {
		this.meseScadenza = meseScadenza;
	}

	/**
	 * Funzione che cambia il numero della carta.
	 * 
	 * @param nCartaCredito
	 */
	public void setnCartaCredito(int nCartaCredito) {
		this.nCartaCredito = nCartaCredito;
	}

	/**
	 * Funzione che cambia il nome del proprietario della carta.
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
