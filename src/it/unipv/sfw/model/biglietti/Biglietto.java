package it.unipv.sfw.model.biglietti;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Classe che rappresenta il biglietto acquistabile dal {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */
public abstract class Biglietto {

	protected String email;
	protected double prezzo;
	protected Calendar data;
	protected Time ora;
	
	public Biglietto(String email, double prezzo, Calendar data, Time ora) {
		this.email = email;
		this.prezzo = prezzo;
		this.data = new GregorianCalendar();
		this.data = data;
		this.ora = ora;
	}
	
	public Biglietto() {}
	
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

	/**
	 * @return La mail associata al biglietto.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Funzione utilizzata per cambiare la mail del biglietto.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return La data del biglietto.
	 */
	public Calendar getData() {
		return data;
	}
	
	/**
	 * @return La data del biglietto.
	 */
	public Date getDataSQL() {
		Date date = data.getTime();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = format1.format(date); 
		Date inActiveDate = null;
		try {
		    inActiveDate = (Date) format1.parse(date1);
		} catch (ParseException e1) {
		    e1.printStackTrace();
		}
		return inActiveDate;
	}

	/**
	 * Funzione utilizzata per cambiare la data del biglietto.
	 * @param prezzo
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * @return L'ora del biglietto.
	 */
	public Time getOra() {
		return ora;
	}

	/**
	 * Funzione utilizzata per cambiare l'ora del biglietto.
	 * @param prezzo
	 */
	public void setOra(Time ora) {
		this.ora = ora;
	}
	
}
