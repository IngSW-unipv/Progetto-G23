package it.unipv.sfw.model.abbonamento;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Classe che rappresenta l'abbonamento acquistabile dal {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Federico Romano
 * @see TipoAbb
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Abbonamento {
	private TipoAbb tipoAbb;
	private Calendar dataInizio;
	private double prezzo;
	
	public Abbonamento(TipoAbb tipo) {
		this.tipoAbb = tipo;
		this.dataInizio = new GregorianCalendar(); 
		this.prezzo = this.getPrezzo();
	}
	
	/**
	 * @return La data di inizio validità dell'abbonamento.
	 */
	public String getDataInizio() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd / MMM / YYYY");
		return formattedDate.format(dataInizio);
	}
	
	/**
	 * @return Il prezzo dell'abbonamento.
	 */
	public double getPrezzo() {   
		switch(this.tipoAbb) {
			case LIV0:
				return 30;
			case LIV1:
				return 500;
			case LIV2:
				return 750;
			case LIV3:
				return 1000;
			default: 
				return 0;
		}
	}
	
	/**
	 * Funzione utilizzata per cambiare il prezzo dell'abbonamento.
	 * @param prezzo
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setPrezzo(double prezzo) {   
		if(prezzo >= 0) {
			this.prezzo = prezzo;
			return true;
		}
		else return false;
	}
	
	/**
	 * @return Il tipo di abbonamento.
	 */
	public TipoAbb getTipoAbb() {
		return tipoAbb;
	}
	
	/**
	 * Funzione utilizzata per cambiare il tipo di abbonamento.
	 * @param tipo Tipo dell'abbonamento.
	 */
	public void setTipoAbb(TipoAbb tipo) {
		tipoAbb = tipo;
	}
	
}
