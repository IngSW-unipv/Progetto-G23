package it.unipv.sfw.model.biglietti;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe che rappresenta il biglietto della partita acquistabile dal {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class BigliettoPartita extends Biglietto{

	private Calendar dataDisponibilita;
	private boolean visibilita;
	
	public BigliettoPartita(String email, double prezzo, Calendar data, Time ora, Calendar dataDisponibilita) {
		super(email, null, prezzo, data, ora);
		this.dataDisponibilita = new GregorianCalendar();
		this.dataDisponibilita = dataDisponibilita;
		this.visibilita = false;
	}
	
	/**
	 * Funzione utilizzata per cambiare la data della disponibilità.
	 * @param data
	 */
	public void setData(Calendar data) {
		dataDisponibilita = data;
	}
	
	/**
	 * @return La data da cui è possibile acquistare il biglietto.
	 */
	public Calendar getData() {
		return dataDisponibilita;
	}
	
	/**
	 * Funzione utilizzata per cambiare il giorno della disponibilità.
	 * @param giorno
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setGiorno(int giorno) {
		if(giorno >0 && giorno<32)	dataDisponibilita.set(Calendar.DATE, giorno);
		else return false;
		return true;
	}
	
	/**
	 * Funzione utilizzata per cambiare il mese della disponibilità.
	 * @param mese
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setMese(int mese) {
		if(mese >=0 && mese<12)	dataDisponibilita.set(Calendar.MONTH, mese);
		else return false;
		return true;
	}
	
	/**
	 * Funzione utilizzata per cambiare l'anno della disponibilità.
	 * @param anno
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setAnno(int anno) {
		Calendar calendar = GregorianCalendar.getInstance();
		if (anno >= calendar.get(Calendar.YEAR))	dataDisponibilita.set(Calendar.YEAR, anno);
		else return false;
		return true;
	}
	
	/**
	 * Funzione utilizzata per cambiare la visibilità del biglietto.
	 * @param visibilita True per rendere visibile il biglietto, altrimenti false.
	 */
	public void setVisibilita(boolean visibilita) {
		this.visibilita = visibilita;
	}
	
	/**
	 * @return La visibilità del biglietto.
	 */
	public boolean getVisibilita() {
		return visibilita;
	}

}