package it.unipv.sfw.model.biglietti;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe che rappresenta il biglietto acquistabile dal {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */

public class Biglietto {

	private String email;
	private double prezzo;
	private Calendar data;
	private Time ora;
	
	public Biglietto(String email, double prezzo, Calendar data, Time ora) {
		this.email = email;
		this.prezzo = prezzo;
		this.data = new GregorianCalendar();
		this.data = data;
		this.ora = ora;
	}
	
	/**
	 * Funzione utilizzata per cambiare il prezzo del biglietto.
	 * @param prezzo
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return Il prezzo del biglietto.
	 */
	public double getPrezzo() {
		return prezzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Time getOra() {
		return ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
	}
}
