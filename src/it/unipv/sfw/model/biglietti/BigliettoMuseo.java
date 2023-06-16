package it.unipv.sfw.model.biglietti;

import java.sql.Time;
import java.util.Calendar;

/**
 * Classe che rappresenta il biglietto del museo acquistabile dal
 * {@link it.unipv.sfw.model.utente.Cliente}.
 *
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */

public class BigliettoMuseo extends Biglietto {

	public final static double prezzoMuseo = 15;
	private String emailConferma;

	public BigliettoMuseo() {
		super();
	}

	public BigliettoMuseo(String email, String emailC, double prezzo, Calendar data, Time ora) {
		super(email, prezzo, data, ora);
		this.emailConferma = emailC;
	}

	/**
	 * @return L'email di conferma del biglietto.
	 */
	public String getEmailConferma() {
		return emailConferma;
	}

	/**
	 * @return Il prezzo del biglietto.
	 */
	public double getPrezzoBiglietto() {
		return BigliettoMuseo.prezzoMuseo;
	}

	/**
	 * Metodo per cambiare la mail di conferma.
	 *
	 * @param emailConferma
	 */
	public void setEmailConferma(String emailConferma) {
		this.emailConferma = emailConferma;
	}
}
