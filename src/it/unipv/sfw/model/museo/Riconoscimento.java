package it.unipv.sfw.model.museo;

import it.unipv.sfw.model.museo.Cimelio.TipoCimelio;

/**
 * Classe che rappresenta il riconoscimento visibile dal {@link it.unipv.sfw.model.utente.Cliente} nel {@link Museo}.
 * @author Lorenzo Reale
 * @see Museo
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Riconoscimento {

	/**
	 * Enumerazione che descrive il tipo del riconoscimento.
	 */
	public enum TipoRiconoscimento{
		SerieA, //19
		Coppa_Italia, //8
		Supercoppa_Italiana, //7
		Champions_League, //3
		Europa_League, //3
		Coppa_Intercontinentale, //2
		Coppa_Del_Mondo_Per_Club //1
	}
	
	private String tipo, descrizione, imgid;
	private int anno, id;
	
	public Riconoscimento(int anno, String descrizione, TipoRiconoscimento tipo, int id, String imgid) {
		this.anno = anno;
		this.id = id;
		this.descrizione = descrizione;
		this.tipo = "" + tipo;
		this.imgid = imgid;
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getImgid() {
		return imgid;
	}

	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	
	public static TipoRiconoscimento[] getTipoCimelio() {
		return Riconoscimento.TipoRiconoscimento.values();
	}
	
}
