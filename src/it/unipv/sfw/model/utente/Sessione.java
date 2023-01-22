package it.unipv.sfw.model.utente;

import it.unipv.sfw.model.partita.Anello;
import it.unipv.sfw.model.partita.Blocco;
import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.partita.Settore;

public class Sessione {
	private static Sessione istance = null;
	private Utente currentUtente;
	private Anello currentAnello;
	private Settore currentSettore;
	private Posto currentPosto;
	private Blocco currentBlocco;

	private Sessione() {
		currentUtente = null;
		currentAnello = null;
		currentSettore = null;
		currentPosto = null;
	}

	public static Sessione getIstance() {
		if (istance == null) {
			istance = new Sessione();
		}
		return istance;
	}

	public void resetAcquistoPartita() {
		this.setCurrentAnello(null);
		this.setCurrentPosto(null);
		this.setCurrentSettore(null);
		this.setCurrentBlocco(null);
	}

	public Utente getCurrentUtente() {
		return currentUtente;
	}

	public Anello getCurrentAnello() {
		return currentAnello;
	}

	public Settore getCurrentSettore() {
		return currentSettore;
	}

	public Posto getCurrentPosto() {
		return currentPosto;
	}

	public Blocco getCurrentBlocco() {
		return currentBlocco;
	}

	public void setCurrentUtente(Utente currentU) {
		currentUtente = currentU;
	}

	public void setCurrentAnello(Anello currentA) {
		currentAnello = currentA;
	}

	public void setCurrentSettore(Settore currentS) {
		currentSettore = currentS;
	}

	public void setCurrentPosto(Posto currentP) {
		currentPosto = currentP;
	}

	public void setCurrentBlocco(Blocco currentB) {
		currentBlocco = currentB;
	}
}
