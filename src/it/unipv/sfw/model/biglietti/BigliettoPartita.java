package it.unipv.sfw.model.biglietti;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BigliettoPartita extends Biglietto{

	private Calendar dataDisponibilita;
	private boolean visibilita;
	
	public BigliettoPartita(double prezzo, Calendar dataDisponibilita) {
		super(prezzo);
		this.dataDisponibilita = new GregorianCalendar();
		this.dataDisponibilita = dataDisponibilita;
		this.visibilita = false;
	}
	
	public void setData(Calendar data) {
		dataDisponibilita = data;
	}
	
	public Calendar getData() {
		return dataDisponibilita;
	}
	
	public boolean setGiorno(int giorno) {
		if(giorno >0 && giorno<32)	dataDisponibilita.set(Calendar.DATE, giorno);
		else return false;
		return true;
	}
	
	public boolean setMese(int mese) {
		if(mese >=0 && mese<12)	dataDisponibilita.set(Calendar.MONTH, mese);
		else return false;
		return true;
	}
	
	public boolean setAnno(int anno) {
		Calendar calendar = GregorianCalendar.getInstance();
		if (anno >= calendar.get(Calendar.YEAR))	dataDisponibilita.set(Calendar.YEAR, anno);
		else return false;
		return true;
	}
	
	public void setVisibilita(boolean visibilita) {
		this.visibilita = visibilita;
	}
	
	public boolean getVisibilita() {
		return visibilita;
	}

}