package it.unipv.sfw.model.utente;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import it.unipv.sfw.model.abbonamento.Abbonamento;
import it.unipv.sfw.model.abbonamento.TipoAbb;


/**
 * Classe che estende {@link Utente} e rappresenta un cliente.
 * @author Federico Romano
 * @see Utente 
 * @see it.unipv.sfw.model.abbonamento.Abbonamento
 * @see it.unipv.sfw.model.abbonamento.TipoAbb
 */
public class Cliente extends Utente {
	private Calendar dataNascita;
	private Abbonamento abb;
	private boolean isGiornalista;

	public Cliente(String nome, String cognome, String email, String pass, Calendar dataNascita) {
		super(nome, cognome, email, pass);
		this.abb = null;
		isGiornalista = false;
		this.dataNascita = dataNascita;
	}
	
	
	/**
	 * @return Il tipo di abbonamento del cliente.
	 */
	public Abbonamento getAbb() {
		return abb;
	}
	
	/**
	 * @return La data di nascita del cliente.
	 */
	public String getDataNascita() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("YYYY-MM-dd");
		return formattedDate.format(dataNascita);
	}

	/**
	 * @param tipo Tipo di abbonamento.
	 * @return Il prezzo del {@link TipoAbb} passato come parametro.
	 */
	public double getPrezzoAbb(TipoAbb tipo) {
		Abbonamento tempAbb = new Abbonamento(tipo);
		double prezzo = tempAbb.getPrezzo();
		tempAbb = null;
		return prezzo;
	}
	
	/**
	 * Funzione che permette al cliente di abbonarsi.
	 * @param tipoAbb Tipo di abbonamento.
	 * @return True se il cliente non ha un abbonamento attivo
	 * oppure False se il cliente ne ha già uno attivo.
	 */
	public boolean abbona(TipoAbb tipoAbb) {
		if (this.abb == null) {
			this.abb = new Abbonamento(tipoAbb);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Funzione che cambia il tipo di utente a giornalista.
	 */
	public void setTypeToGiornalista() {
		isGiornalista = true;
	}

	/** 
	 * @param tipoAbb Tipo di abbonamento.
	 * @return Il prezzo del {@link TipoAbb} passato come parametro.
	 */
	public int getLevel(TipoAbb tipoAbb) {
		switch (tipoAbb) {
		case TESSERA:
			return 0;
		case LIV1:
			return 1;
		case LIV2:
			return 2;
		case LIV3:
			return 3;
		default:
			return -1; //nessun abbonamento
		}
	}

	/**
	 * @return Il livello del {@link TipoAbb} attivo del cliente.
	 */
	public int getLevel() {
		switch (this.abb.getTipoAbb()) {
		case TESSERA:
			return 0;
		case LIV1:
			return 1;
		case LIV2:
			return 2;
		case LIV3:
			return 3;
		default:
			return -1; // nessun abbonamento
		}
	}
	
	/**
	 * Funzione che permette al cliente di aumentare il livello del proprio abbonamento.
	 * @param tipoAbb Tipo di abbonamento.
	 * @return -1 se l'abbonamento passato come parametro è di un livello inferiore
	 * rispetto a quello attuale altrimenti la differenza di prezzo. 
	 */
	public int improveAbb(TipoAbb tipoAbb) {
		int actualLev = getLevel(abb.getTipoAbb());
		int nextLev = getLevel(tipoAbb);
		if (nextLev > actualLev) {
			int diff = nextLev - actualLev;
			abb.setTipoAbb(tipoAbb);
			return diff;
		} else {
			return -1;
		}
	}

	@Override
	public Type getType() {
		return isGiornalista ? Utente.Type.GIORNALISTA : Utente.Type.CLIENTE;
	}
}
