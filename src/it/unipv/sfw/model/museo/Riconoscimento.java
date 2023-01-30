package it.unipv.sfw.model.museo;

/**
 * Classe che rappresenta il riconoscimento visibile dal {@link Cliente} nel {@link Museo}.
 * @author Lorenzo Reale
 * @see Museo
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Riconoscimento {

	public enum TipoRiconoscimento{
		Coppa,
		Trofeo,
		Pallone,
		Scarpe,
		Maglia
	}
	
	private String tipo, descrizione;
	private int anno;
	
	public Riconoscimento(int anno, String descrizione, TipoRiconoscimento tipo) {
		this.anno = anno;
		this.descrizione = descrizione;
		this.tipo = "" + tipo;
	}
	
	/**
	 * Funzione utilizzata per cambiare la descrizione del riconoscimento.
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * @return La descrizione del riconoscimento.
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Funzione utilizzata per cambiare il tipo del riconoscimento.
	 * @param tipo
	 */
	public void setTipo(TipoRiconoscimento tipo) {
		this.tipo = "" + tipo;
	}
	
	/**
	 * @return Il tipo del riconoscimento.
	 */
	public String getTipo() {
		return "" + tipo;
	}
	
	/**
	 * Funzione utilizzata per cambiare l'anno del riconoscimento.
	 * @param anno
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	/**
	 * @return L'anno del riconoscimento.
	 */
	public int getAnno() {
		return anno;
	}
	
}
