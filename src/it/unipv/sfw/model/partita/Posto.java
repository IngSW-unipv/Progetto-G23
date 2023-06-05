package it.unipv.sfw.model.partita;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe che rappresenta un posto dello {@link Stadio}.
 * @author Lorenzo Reale
 * @see Stadio
 */
public class Posto {

	private int nSettore, nBlocco, nAnello, nPosto;
	private Calendar data;
	private boolean libero;

	public Posto(int nSettore, int nBlocco, int nAnello, int nPosto, Calendar data) {
		this.nPosto = nPosto;
		data = new GregorianCalendar();
		this.data = data;
		this.nBlocco = nBlocco;
		this.nAnello = nAnello;
		this.nSettore = nSettore;
		libero = true;
	}

	/**
	 * Funzione utilizzata per segnalare che un posto è pieno.
	 * @param  lib False se è pieno, altrimenti true.
	 */
	public void setLibero(boolean lib) {
		libero = lib;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public Calendar getData() {
		return data;
	}

	/**
	 * @return False se il posto è occupato, altrimenti true.
	 */
	public boolean getLibero() {
		return libero;
	}

	/**
	 * @return Il numero del posto.
	 */
	public int getNPosto() {
		return nPosto;
	}
	
	/**
	 * @return Il numero del blocco.
	 */
	public int getNBlocco() {
		return nBlocco;
	}
	
	/**
	 * @return Il numero dell'anello.
	 */
	public int getNAnello() {
		return nAnello;
	}
	
	/**
	 * @return Il numero del settore.
	 */
	public int getNSettore() {
		return nSettore;
	}
}
