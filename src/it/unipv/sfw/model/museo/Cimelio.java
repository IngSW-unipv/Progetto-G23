package it.unipv.sfw.model.museo;

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
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setTipo(TipoCimelio tipo) {
		this.tipo = "" + tipo;
	}
	
	public String getTipo() {
		return "" + tipo;
	}

}
