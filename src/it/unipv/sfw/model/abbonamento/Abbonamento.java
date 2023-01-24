package it.unipv.sfw.model.abbonamento;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Abbonamento {
	private TipoAbb tipoAbb;
	private Calendar dataInizio;
	private double prezzo;
	
	public Abbonamento(TipoAbb tipo) {
		this.tipoAbb = tipo;
		this.dataInizio = new GregorianCalendar(); 
		this.prezzo = this.getPrezzo();
	}
	
	public String getDataInizio() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd / MMM / YYYY");
		return formattedDate.format(dataInizio);
	}
	
	public double getPrezzo() {   
		switch(this.tipoAbb) {
			case TESSERA:
				return 30;
			case LIV1:
				return 500;
			case LIV2:
				return 750;
			case LIV3:
				return 1000;
			default: 
				return 0;
		}
	}
	
	public boolean setPrezzo(double prezzo) {   
		if(prezzo >= 0) {
			this.prezzo = prezzo;
			return true;
		}
		else return false;
	}
	
	public TipoAbb getTipoAbb() {
		return tipoAbb;
	}
	
	public void setTipoAbb(TipoAbb tipo) {
		tipoAbb = tipo;
	}
	
}
