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
	private String infoScelte;
	private Utente currentUtente;

	private Sessione() {
		
		currentUtente = null;
		infoScelte = "";
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
		this.setinfoScelte(null);
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
	
	public void setinfoScelte(String newInfo) {
		infoScelte = infoScelte + newInfo + "-";
	}
	
	public int getInfo(char info) {
		int code = -1;
		
		for(int i=0; i<infoScelte.length(); i++) {
			if(infoScelte.charAt(i) == info) {
				String code2 = "";
				for(int i2=1; i<infoScelte.length(); i++) {
					if(infoScelte.charAt(i+i2) == '-') break;
					else code2 = code2 + infoScelte.charAt(i+i2);
				}
				code = Integer.parseInt(code2);
			}
		}
		
		return code;
	}
	
}
