package it.unipv.sfw.model.utente;

import it.unipv.sfw.model.partita.Anello;
import it.unipv.sfw.model.partita.Blocco;
import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.partita.Settore;


/**
 * Classe che rappresenta la sessione corrente.
 * @author Federico Romano
 * @see Utente
 * @see Anello
 * @see Settore
 * @see Posto
 * @see Blocco
 */
public class Sessione {
	private static Sessione istance = null;
	private Utente currentUtente;
	private Anello currentAnello;
	private Settore currentSettore;
	private Posto currentPosto;
	private Blocco currentBlocco;

	private Sessione() {
		currentUtente = null;
		currentAnello = null;
		currentSettore = null;
		currentPosto = null;
	}
	
	
	/**
	 * @return L'istanza corrente di {@link Sessione}, nel caso non esista la crea.
	 */
	public static Sessione getIstance() {
		if (istance == null) {
			istance = new Sessione();
		}
		return istance;
	}

	
	/**
	 * Funzione che resetta i campi sessione riguardanti 
	 * {@link Anello}, {@link Posto}, {@link Settore}, {@link Blocco}
	 * a null.
	 */
	public void resetAcquistoPartita() {
		this.setCurrentAnello(null);
		this.setCurrentPosto(null);
		this.setCurrentSettore(null);
		this.setCurrentBlocco(null);
	}

	
	/**
	 * @return {@link Utente} della sessione corrente.
	 */
	public Utente getCurrentUtente() {
		return currentUtente;
	}

	/**
	 * @return {@link Anello} della sessione corrente.
	 */
	public Anello getCurrentAnello() {
		return currentAnello;
	}

	/**
	 * @return {@link Settore} della sessione corrente.
	 */
	public Settore getCurrentSettore() {
		return currentSettore;
	}

	/**
	 * @return {@link Posto} della sessione corrente.
	 */
	public Posto getCurrentPosto() {
		return currentPosto;
	}

	/**
	 * @return {@link Blocco} della sessione corrente.
	 */
	public Blocco getCurrentBlocco() {
		return currentBlocco;
	}

	/**
	 * Funzione che permette di impostare come {@link Utente} corrente 
	 * quello passato come parametro.
	 * @param currentU
	 */
	public void setCurrentUtente(Utente currentU) {
		currentUtente = currentU;
	}

	/**
	 * Funzione che permette di impostare come {@link Anello} corrente
	 * quello passato come parametro.
	 * @param currentA
	 */
	public void setCurrentAnello(Anello currentA) {
		currentAnello = currentA;
	}

	/**
	 * Funzione che permette di impostare come {@link Settore} corrente
	 * quello passato come parametro.
	 * @param currentS
	 */
	public void setCurrentSettore(Settore currentS) {
		currentSettore = currentS;
	}

	/**
	 * Funzione che permette di impostare come {@link Posto} corrente
	 * quello passato come parametro.
	 * @param currentP
	 */
	public void setCurrentPosto(Posto currentP) {
		currentPosto = currentP;
	}

	/**
	 * Funzione che permette di impostare come {@link Blocco} corrente
	 * quello passato come parametro.
	 * @param currentB
	 */
	public void setCurrentBlocco(Blocco currentB) {
		currentBlocco = currentB;
	}
}
