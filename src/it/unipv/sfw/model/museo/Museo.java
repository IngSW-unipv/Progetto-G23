package it.unipv.sfw.model.museo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe che rappresenta il museo visitabile dal {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */
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
	
	/**
	 * Funzione utilizzata per aggiungere un cimelio.
	 * @param descrizione, tipo
	 */
	public void addCimelio(String descrizione, Cimelio.TipoCimelio tipo) {
		cimeli.add(new Cimelio(descrizione, tipo));
	}
	
	/**
	 * Funzione utilizzata per aggiungere un riconoscimento.
	 * @param anno, descrizione, tipo
	 */
	public void addRiconoscimento(int anno, String descrizione, Riconoscimento.TipoRiconoscimento tipo) {
		riconoscimenti.add(new Riconoscimento(anno, descrizione, tipo));
	}

	/**
	 * Funzione utilizzata per cambiare la storia della squadra.
	 * @param storia
	 */
	public void setStoria(String storia) {
		storiaSquadra = storia;
	}
	
	/**
	 * @return La storia della squadra.
	 */
	public String getStoria() {
		return storiaSquadra;
	}
	
	/**
	 * Funzione utilizzata per aprire il museo.
	 * @param aperto True per aprire, false per chiudere.
	 */
	public void setAperto(boolean aperto) {
		this.aperto = aperto;
	}
	
	/**
	 * @return True se il museo ?? aperto, false se ?? chiuso.
	 */
	public boolean getAperto() {
		return aperto;
	}
	
	/**
	 * Funzione utilizzata per cambiare l'orario d'apertura del museo.
	 * @param ora, minuto
	 * @return True se l'operazione ?? andata a buon fine, altrimenti false.
	 */
	public boolean setOrarioApertura(int ora, int minuto) {
		if(ora < 24 && ora >= 0 && minuto >= 0 && minuto < 60) {
			orarioApertura.set(Calendar.HOUR, ora);
			orarioApertura.set(Calendar.MINUTE, minuto);
			return true;
		}else return false;
	}
	
	/**
	 * Funzione utilizzata per cambiare l'ora d'apertura del museo.
	 * @param ora
	 * @return True se l'operazione ?? andata a buon fine, altrimenti false.
	 */
	public boolean setOraApertura(int ora) {
		if(ora >= 0 && ora < 24) orarioApertura.set(Calendar.HOUR, ora);
		else return false;
		return true;
	}
	
	/**
	 * Funzione utilizzata per cambiare il minuto d'apertura del museo.
	 * @param minuto
	 * @return True se l'operazione ?? andata a buon fine, altrimenti false.
	 */
	public boolean setMinutoApertura(int minuto) {
		if(minuto >= 0 && minuto < 60) orarioApertura.set(Calendar.MINUTE, minuto);
		else return false;
		return true;
	}
	
	/**
	 * Funzione utilizzata per cambiare l'orario di chiusura del museo.
	 * @param ora, minuto
	 * @return True se l'operazione ?? andata a buon fine, altrimenti false.
	 */
	public boolean setOrarioChiusura(int ora, int minuto) {
		if(ora < 24 && ora >= 0 && minuto >= 0 && minuto < 60) {
			orarioChiusura.set(Calendar.HOUR, ora);
			orarioChiusura.set(Calendar.MINUTE, minuto);
			return true;
		}else return false;
	}
	
	/**
	 * Funzione utilizzata per cambiare l'ora di chiusura del museo.
	 * @param ora
	 * @return True se l'operazione ?? andata a buon fine, altrimenti false.
	 */
	public boolean setOraChiusura(int ora) {
		if(ora >= 0 && ora < 24) orarioChiusura.set(Calendar.HOUR, ora);
		else return false;
		return true;
	}
	
	/**
	 * Funzione utilizzata per cambiare il minuto di chiusura del museo.
	 * @param minuto
	 * @return True se l'operazione ?? andata a buon fine, altrimenti false.
	 */
	public boolean setMinutoChiusura(int minuto) {
		if(minuto >= 0 && minuto < 60) orarioChiusura.set(Calendar.MINUTE, minuto);
		else return false;
		return true;
	}
	
}
