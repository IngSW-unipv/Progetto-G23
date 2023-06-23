package it.unipv.sfw.model.utente;

import java.util.Calendar;

import it.unipv.sfw.model.abbonamento.Abbonamento;
import it.unipv.sfw.model.abbonamento.AbbType;

/**
 * Classe che estende {@link Utente} e rappresenta un cliente.
 *
 * @author Federico Romano
 * @see Utente
 * @see it.unipv.sfw.model.abbonamento.Abbonamento
 * @see it.unipv.sfw.model.abbonamento.AbbType
 */
public class Cliente extends Utente {
	private Abbonamento abb;

	public Cliente(String nome, String cognome, String email, String pass, Calendar dataNascita) {
		super(nome, cognome, email, pass, dataNascita);
		this.abb = new Abbonamento(AbbType.LIV0);
		this.dataNascita = dataNascita;
	}

	/**
	 * Funzione che permette al cliente di abbonarsi.
	 *
	 * @param tipoAbb Tipo di abbonamento.
	 */
	public void abbona(AbbType tipoAbb) {
		this.abb = new Abbonamento(tipoAbb);
	}

	/**
	 * @return Il tipo di abbonamento del cliente.
	 */
	public Abbonamento getAbb() {
		return abb;
	}

	/**
	 * @return Il livello del {@link AbbType} attivo del cliente.
	 */
	public int getLevel() {
		switch (this.abb.getTipoAbb()) {
		case LIV0:
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
	 * @param tipoAbb Tipo di abbonamento.
	 * @return Il prezzo del {@link AbbType} passato come parametro.
	 */
	public int getLevel(AbbType tipoAbb) {
		switch (tipoAbb) {
		case LIV0:
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
	 * @param tipo Tipo di abbonamento.
	 * @return Il prezzo del {@link AbbType} passato come parametro.
	 */
	public double getPrezzoAbb(AbbType tipo) {
		Abbonamento tempAbb = new Abbonamento(tipo);
		double prezzo = tempAbb.getPrezzo();
		tempAbb = null;
		return prezzo;
	}

	@Override
	public Type getType() {
		return Utente.Type.CLIENTE;
	}

	/**
	 * Funzione che permette al cliente di aumentare il livello del proprio
	 * abbonamento.
	 *
	 * @param tipoAbb Tipo di abbonamento.
	 * @return -1 se l'abbonamento passato come parametro è di un livello inferiore
	 *         rispetto a quello attuale altrimenti la differenza di prezzo.
	 */
	public int improveAbb(AbbType tipoAbb) {
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

	/**
	 * @param abb Abbonamento.
	 */
	public void setAbb(Abbonamento abb) {
		this.abb = abb;
	}
}
