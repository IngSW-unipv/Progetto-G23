package it.unipv.sfw.model.museo;

/**
 * Classe che rappresenta il riconoscimento visibile dal
 * {@link it.unipv.sfw.model.utente.Cliente} nel {@link Museo}.
 *
 * @author Lorenzo Reale
 * @see Museo
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Riconoscimento {

	/**
	 * Enumerazione che descrive il tipo del riconoscimento.
	 */
	public enum TipoRiconoscimento {
		SerieA, // 19
		Coppa_Italia, // 8
		Supercoppa_Italiana, // 7
		Champions_League, // 3
		Europa_League, // 3
		Coppa_Intercontinentale, // 2
		Coppa_Del_Mondo_Per_Club // 1
	}

	/**
	 * @return Il tipo di Riconoscimento.
	 */
	public static TipoRiconoscimento[] getTipoRiconoscimento() {
		return Riconoscimento.TipoRiconoscimento.values();
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

	// costruttore per admin
	public Riconoscimento(int anno, String descrizione, TipoRiconoscimento tipo, String imgid) {
		this.anno = anno;
		this.descrizione = descrizione;
		this.tipo = "" + tipo;
		this.imgid = imgid;
	}

	/**
	 * @return L'anno del riconoscimento.
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * @return La descrizione del riconoscimento.
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @return L'id del riconoscimento.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return Id dell'immagine del riconoscimento.
	 */
	public String getImgid() {
		return imgid;
	}

	/**
	 * @return Il tipo del riconoscimento.
	 */
	public String getTipo() {
		return "" + tipo;
	}

	/**
	 * Funzione utilizzata per cambiare l'anno del riconoscimento.
	 *
	 * @param anno
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	/**
	 * Funzione utilizzata per cambiare la descrizione del riconoscimento.
	 *
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @param id Id del riconoscimento.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param imgid Id dell'immagine da settare per il riconoscimento.
	 */
	public void setImgid(String imgid) {
		this.imgid = imgid;
	}

	/**
	 * Funzione utilizzata per cambiare il tipo del riconoscimento.
	 *
	 * @param tipo
	 */
	public void setTipo(TipoRiconoscimento tipo) {
		this.tipo = "" + tipo;
	}

}
