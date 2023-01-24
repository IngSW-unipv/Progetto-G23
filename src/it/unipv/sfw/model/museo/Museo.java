package it.unipv.sfw.model.museo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Museo {
	
	private String storiaSquadra;
	private boolean aperto;
	private Calendar orarioChiusura, orarioApertura;
	private ArrayList <Cimelio> cimeli;
	private ArrayList <Riconoscimento> riconoscimenti;
	
	public Museo(String storiaSquadra, int oraApertura, int minutoApertura, int oraChiusura, int minutoChiusura) {
		this.storiaSquadra = storiaSquadra;
		
		orarioApertura = new GregorianCalendar();
		orarioApertura.set(Calendar.HOUR, oraApertura);
		orarioApertura.set(Calendar.MINUTE, minutoApertura);
		
		orarioChiusura = new GregorianCalendar();
		orarioChiusura.set(Calendar.HOUR, oraChiusura);
		orarioChiusura.set(Calendar.MINUTE, minutoChiusura);
		
		aperto = false;
		
		cimeli = new ArrayList<Cimelio>();
		riconoscimenti = new ArrayList<Riconoscimento>();
	}
	
	public void addCimelio(String descrizione, Cimelio.TipoCimelio tipo) {
		cimeli.add(new Cimelio(descrizione, tipo));
	}
	
	public void addRiconoscimento(int anno, String descrizione, Riconoscimento.TipoRiconoscimento tipo) {
		riconoscimenti.add(new Riconoscimento(anno, descrizione, tipo));
	}

	public void setStoria(String storia) {
		storiaSquadra = storia;
	}
	
	public String getStoria() {
		return storiaSquadra;
	}
	
	public void setAperto(boolean aperto) {
		this.aperto = aperto;
	}
	
	public boolean getAperto() {
		return aperto;
	}
	
	public boolean setOrarioApertura(int ora, int minuto) {
		if(ora < 24 && ora >= 0 && minuto >= 0 && minuto < 60) {
			orarioApertura.set(Calendar.HOUR, ora);
			orarioApertura.set(Calendar.MINUTE, minuto);
			return true;
		}else return false;
	}
	
	public boolean setOraApertura(int ora) {
		if(ora >= 0 && ora < 24) orarioApertura.set(Calendar.HOUR, ora);
		else return false;
		return true;
	}
	
	public boolean setMinutoApertura(int minuto) {
		if(minuto >= 0 && minuto < 60) orarioApertura.set(Calendar.MINUTE, minuto);
		else return false;
		return true;
	}
	
	public boolean setOrarioChiusura(int ora, int minuto) {
		if(ora < 24 && ora >= 0 && minuto >= 0 && minuto < 60) {
			orarioChiusura.set(Calendar.HOUR, ora);
			orarioChiusura.set(Calendar.MINUTE, minuto);
			return true;
		}else return false;
	}
	
	public boolean setOraChiusura(int ora) {
		if(ora >= 0 && ora < 24) orarioChiusura.set(Calendar.HOUR, ora);
		else return false;
		return true;
	}
	
	public boolean setMinutoChiusura(int minuto) {
		if(minuto >= 0 && minuto < 60) orarioChiusura.set(Calendar.MINUTE, minuto);
		else return false;
		return true;
	}
	
}
