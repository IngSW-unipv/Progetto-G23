package it.unipv.sfw.model.museo;

/**
 * Classe che rappresenta il cimelio visibile dal
 * {@link it.unipv.sfw.model.utente.Cliente} nel {@link Museo}.
 *
 * @author Lorenzo Reale
 * @see Museo
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Cimelio {

	/**
	 * Enumerazione che descrive il tipo del cimelio.
	 */
	public enum TipoCimelio {
		Fotografia, Pallone, Scarpe, Maglia
	}

	/**
	 * @return Il tipo di Cimelio.
	 */
	public static TipoCimelio[] getTipoCimelio() {
		return Cimelio.TipoCimelio.values();
	}

	private String tipo, descrizione, imgid;

	private int id, anno;

	public Cimelio(String descrizione, TipoCimelio tipo, int id, int anno, String imgid) {
		this.tipo = "" + tipo;
		this.id = id;
		this.anno = anno;
		this.descrizione = descrizione;
		this.setImgid(imgid);
	}

	// costruttore per admin
	public Cimelio(String descrizione, TipoCimelio tipo, int anno, String imgid) {
		this.tipo = "" + tipo;
		this.descrizione = descrizione;
		this.anno = anno;
		this.setImgid(imgid);
	}

	/**
	 * @return L'anno del cimelio.
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * @return La descrizione del cimelio.
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @return L'id del cimelio.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return Id dell'immagine del cimelio.
	 */
	public String getImgid() {
		return imgid;
	}

	/**
	 * @return Il tipo del cimelio.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Funzione utilizzata per cambiare l'anno del cimelio.
	 *
	 * @param anno
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	/**
	 * Funzione utilizzata per cambiare la descrizione del cimelio.
	 *
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @param id Id del cimelio.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param imgid Id dell'immagine da settare per il cimelio.
	 */
	public void setImgid(String imgid) {
		this.imgid = imgid;
	}

	/**
	 * Funzione utilizzata per cambiare il tipo del cimelio.
	 *
	 * @param tipo
	 */
	public void setTipo(TipoCimelio tipo) {
		this.tipo = "" + tipo;
	}

}
