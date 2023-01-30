package it.unipv.sfw.model.museo;

/**
 * Classe che rappresenta il cimelio visibile dal {@link Cliente} nel {@link Museo}.
 * @author Lorenzo Reale
 * @see Museo
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Cimelio {

	public enum TipoCimelio{
		Fotografia,
		Statua,
		DocumentazioneDiEpisodi,
		Ricordo
	}
	
	private String tipo, descrizione;
	
	public Cimelio(String descrizione, TipoCimelio tipo) {
		this.tipo = "" + tipo;
		this.descrizione = descrizione;
	}
	
	/**
	 * Funzione utilizzata per cambiare la descrizione del cimelio.
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * @return La descrizione del cimelio.
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Funzione utilizzata per cambiare il tipo del cimelio.
	 * @param tipo
	 */
	public void setTipo(TipoCimelio tipo) {
		this.tipo = "" + tipo;
	}
	
	/**
	 * @return Il tipo del cimelio.
	 */
	public String getTipo() {
		return "" + tipo;
	}

}
