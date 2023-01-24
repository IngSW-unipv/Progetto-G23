package it.unipv.sfw.model.utente;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import it.unipv.sfw.model.abbonamento.Abbonamento;
import it.unipv.sfw.model.abbonamento.TipoAbb;

public class Cliente extends Utente {
	private Calendar dataNascita;
	private Abbonamento abb;
	private boolean isGiornalista;

	public Cliente(String nome, String cognome, String email, String pass) {
		super(nome, cognome, email, pass);
		this.abb = null;
		isGiornalista = false;
	}

	public String getDataNascita() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd / MMM / YYYY");
		return formattedDate.format(dataNascita);
	}

	public double getPrezzoAbb(TipoAbb tipo) {
		Abbonamento tempAbb = new Abbonamento(tipo);
		double prezzo = tempAbb.getPrezzo();
		tempAbb = null;
		return prezzo;
	}

	public boolean abbona(TipoAbb tipoAbb) {
		if (this.abb == null) {
			this.abb = new Abbonamento(tipoAbb);
			return true;
		} else {
			return false;
		}
	}

	public void setTypeToGiornalista() {
		isGiornalista = true;
	}

	// mi informo su altri possibili abbonamenti
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
			return -1; // nessun abbonamento
		}
	}

	// mio abbonamento attuale
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

	public void acquistaBiglietto() {
		// integrare
	}
}
