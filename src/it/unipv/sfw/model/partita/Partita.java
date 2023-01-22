package it.unipv.sfw.model.partita;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Partita {

	private final String casa = "Inter";

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

	public String getCasa() {
		return casa;
	}

	public String getOspiti() {
		return ospiti;
	}

	public void setOspiti(Squadre ospiti) {
		this.ospiti = "" + ospiti;
	}

	public String getData() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd / MMM / YYYY - hh:mm");
		return formattedDate.format(dataPartita.getTime());
	}

	public boolean setOrario(int ora, int minuto) {
		if (ora < 24 && ora >= 0 && minuto >= 0 && minuto < 60) {
			dataPartita.set(Calendar.HOUR, ora);
			dataPartita.set(Calendar.MINUTE, minuto);
			return true;
		} else
			return false;
	}

	public boolean setOra(int ora) {
		if (ora >= 0 && ora < 24)
			dataPartita.set(Calendar.HOUR, ora);
		else
			return false;
		return true;
	}

	public boolean setMinuto(int minuto) {
		if (minuto >= 0 && minuto < 60)
			dataPartita.set(Calendar.MINUTE, minuto);
		else
			return false;
		return true;
	}

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

	public boolean setGiorno(int giorno) {
		if (giorno > 0 && giorno < 32)
			dataPartita.set(Calendar.DATE, giorno);
		else
			return false;
		return true;
	}

	public boolean setMese(int mese) {
		if (mese >= 0 && mese < 12)
			dataPartita.set(Calendar.MONTH, mese);
		else
			return false;
		return true;
	}

	public boolean setAnno(int anno) {
		Calendar calendar = GregorianCalendar.getInstance();
		if (anno >= calendar.get(Calendar.YEAR))
			dataPartita.set(Calendar.YEAR, anno);
		else
			return false;
		return true;
	}
}