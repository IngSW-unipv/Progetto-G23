package it.unipv.sfw.model.utente;

import java.util.HashMap;

import it.unipv.sfw.model.partita.Posto;


/**
 * Classe che rappresenta la sessione corrente.
 * @author Federico Romano, Lorenzo Reale
 * @see Utente
 * @see Anello
 * @see Settore
 * @see Posto
 * @see Blocco
 */
public class Sessione {
	private static Sessione istance = null;
	private HashMap<String, Integer> scelte;
	private Utente currentUtente;

	private Sessione() {
		
		currentUtente = null;
		scelte = new HashMap<String, Integer>();
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
	public void resetScelte() {
		scelte.clear();
	}

	/**
	 * @return {@link Utente} della sessione corrente.
	 */
	public Utente getCurrentUtente() {
		return currentUtente;
	}
	
	/**
	 * Funzione che permette di impostare come {@link Utente} corrente 
	 * quello passato come parametro.
	 * @param currentU Utente corrente della sessione.
	 */
	public void setCurrentUtente(Utente currentU) {
		currentUtente = currentU;
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Blocco}.
	 * @param blocco
	 */
	public void setBlocco(int blocco) {
		scelte.put("Blocco", blocco);
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Anello}.
	 * @param anello
	 */
	public void setAnello(int anello) {
		scelte.put("Anello", anello);
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Settore}.
	 * @param settore
	 */
	public void setSettore(int settore) {
		scelte.put("Settore", settore);
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Posto}.
	 * @param posto
	 */
	public void setPosto(int posto) {
		scelte.put("Posto", posto);
	}
	
	/**
	 * @return {@link Blocco} della sessione corrente.
	 */
	public int getBlocco() {
		return scelte.get("Blocco");
	}
	
	/**
	 * @return {@link Anello} della sessione corrente.
	 */
	public int getAnello() {
		return scelte.get("Anello");
	}
	
	/**
	 * @return {@link Settore} della sessione corrente.
	 */
	public int getSettore() {
		return scelte.get("Settore");
	}
	
	/**
	 * @return {@link Posto} della sessione corrente.
	 */
	public int getPosto() {
		return scelte.get("Posto");
	}
	
}
