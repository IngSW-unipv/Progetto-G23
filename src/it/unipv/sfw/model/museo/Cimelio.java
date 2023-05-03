package it.unipv.sfw.model.museo;

/**
 * Classe che rappresenta il cimelio visibile dal {@link it.unipv.sfw.model.utente.Cliente} nel {@link Museo}.
 * @author Lorenzo Reale
 * @see Museo
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Cimelio {

	/**
	 * Enumerazione che descrive il tipo del cimelio.
	 */
	public enum TipoCimelio{
		Fotografia,
		Statua,
		DocumentazioneDiEpisodi,
		Ricordo
	}
	
	private String tipo, descrizione;
	private int id, anno;
	
	public Cimelio(String descrizione, TipoCimelio tipo, int id) {
		this.tipo = "" + tipo;
		this.id = id;
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	/**
	 * @return Il tipo del cimelio.
	 */
	public String getTipo() {
		return "" + tipo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

}
