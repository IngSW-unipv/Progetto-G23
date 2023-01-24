package it.unipv.sfw.model.museo;

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
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setTipo(TipoRiconoscimento tipo) {
		this.tipo = "" + tipo;
	}
	
	public String getTipo() {
		return "" + tipo;
	}
	
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	public int getAnno() {
		return anno;
	}
	
}
