package it.unipv.sfw.model.museo;

import java.util.ArrayList;

import it.unipv.sfw.model.museo.Cimelio.TipoCimelio;

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
		Pallone,
		Scarpe,
		Maglia
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
	
	//costruttore per admin
	public Cimelio(String descrizione, TipoCimelio tipo, int anno, String imgid) {
		this.tipo = "" + tipo;
		this.descrizione = descrizione;
		this.anno = anno;
		this.setImgid(imgid);
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
	 * @param id Id del cimelio.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return L'id del cimelio.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return Il tipo del cimelio.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return L'anno del cimelio.
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * Funzione utilizzata per cambiare l'anno del cimelio.
	 * @param anno
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	/**
	 * @return Id dell'immagine del cimelio.
	 */
	public String getImgid() {
		return imgid;
	}

	/**
	 * @param imgid Id dell'immagine da settare per il cimelio.
	 */
	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	
	/**
	 * @return Il tipo di Cimelio.
	 */
	public static TipoCimelio[] getTipoCimelio() {
		return Cimelio.TipoCimelio.values();
	}

}
