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
		this.descrizione = descrizione;
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

	public String getImgid() {
		return imgid;
	}

	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	
	public static TipoCimelio[] getTipoCimelio() {
		return Cimelio.TipoCimelio.values();
	}

}
