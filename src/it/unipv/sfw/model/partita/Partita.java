package it.unipv.sfw.model.partita;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe che rappresenta la partita visibile dal {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Partita {

	private final String casa = "Inter";

	/**
	 * Enumerazione che descrive le squadre.
	 */
	public enum Squadre {
		Atalanta, Bologna, Cremonese, Empoli, Fiorentina, Inter, Juventus, Lazio, Lecce, Milan, Monza, Napoli, Roma,
		Salernitana, Sampdoria, Sassuolo, Spezia, Torino, Udinese, Verona
	}

	private String ospiti;
	private Calendar dataPartita;

	public Partita(Calendar dataPartita, Squadre ospiti) {
		this.ospiti = "" + ospiti;
		this.dataPartita = new GregorianCalendar();
		this.dataPartita = dataPartita;
	}

	/**
	 * @return La squadra di casa.
	 */
	public String getCasa() {
		return casa;
	}

	/**
	 * @return La squadra ospite.
	 */
	public String getOspiti() {
		return ospiti;
	}

	/**
	 * Funzione utilizzata cambiare la squadra ospite.
	 * @param ospiti nome squadra ospite.
	 */
	public void setOspiti(Squadre ospiti) {
		this.ospiti = "" + ospiti;
	}

	/**
	 * @return La data della partita.
	 */
	public String getData() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd / MMM / YYYY - hh:mm");
		return formattedDate.format(dataPartita.getTime());
	}

	public Calendar getCalendarDate() {
		return dataPartita;
	}
	
	/**
	 * Funzione utilizzata per cambiare l'orario della partita.
	 * @param ora, minuto
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setOrario(int ora, int minuto) {
		if (ora < 24 && ora >= 0 && minuto >= 0 && minuto < 60) {
			dataPartita.set(Calendar.HOUR, ora);
			dataPartita.set(Calendar.MINUTE, minuto);
			return true;
		} else
			return false;
	}

	/**
	 * Funzione utilizzata per cambiare l'ora della partita.
	 * @param ora
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setOra(int ora) {
		if (ora >= 0 && ora < 24)
			dataPartita.set(Calendar.HOUR, ora);
		else
			return false;
		return true;
	}

	/**
	 * Funzione utilizzata per cambiare il minuto della partita.
	 * @param minuto
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setMinuto(int minuto) {
		if (minuto >= 0 && minuto < 60)
			dataPartita.set(Calendar.MINUTE, minuto);
		else
			return false;
		return true;
	}

	/**
	 * Funzione utilizzata per cambiare la data della partita.
	 * @param giorno, mese, anno
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setData(int giorno, int mese, int anno) {
		if (giorno > 0 && giorno < 32) {
			dataPartita.set(Calendar.DATE, giorno);
			if (mese >= 0 && mese < 12) {
				dataPartita.set(Calendar.MONTH, mese);
				Calendar calendar = GregorianCalendar.getInstance();
				if (anno >= calendar.get(Calendar.YEAR))
					dataPartita.set(Calendar.YEAR, anno);
				else
					return false;
			} else
				return false;
		} else
			return false;
		return true;
	}

	/**
	 * Funzione utilizzata per cambiare il giorno della partita.
	 * @param giorno
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setGiorno(int giorno) {
		if (giorno > 0 && giorno < 32)
			dataPartita.set(Calendar.DATE, giorno);
		else
			return false;
		return true;
	}

	/**
	 * Funzione utilizzata per cambiare il mese della partita.
	 * @param mese
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setMese(int mese) {
		if (mese >= 0 && mese < 12)
			dataPartita.set(Calendar.MONTH, mese);
		else
			return false;
		return true;
	}

	/**
	 * Funzione utilizzata per cambiare l'anno della partita.
	 * @param anno
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setAnno(int anno) {
		Calendar calendar = GregorianCalendar.getInstance();
		if (anno >= calendar.get(Calendar.YEAR))
			dataPartita.set(Calendar.YEAR, anno);
		else
			return false;
		return true;
	}
}