package it.unipv.sfw.model.partita;

import java.util.ArrayList;

/**
 * Classe che rappresenta lo stadio accessibile al {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Stadio {

	private ArrayList<Posto> posti;
	private boolean libero;

	public Stadio() {
		libero = true;
		posti = new ArrayList<Posto>();
	}

	/**
	 * Funzione utilizzata per segnalare che lo stadio è pieno.
	 * @param lib False se è pieno, altrimenti true.
	 */
	public void setLibero(boolean lib) {
		libero = lib;
	}

	/**
	 * @return False se lo stadio è occupato, altrimenti true.
	 */
	public boolean getLibero() {
		return libero;
	}

	/**
	 * Funzione utilizzata per settare lo stadio occupato se non ci sono più settori liberi.
	 */
	public void checkLibero() {
		int lib = 0;

		for (int i = 0; i < posti.size(); i++) {
			if (posti.get(i).getLibero() == true)
				lib++;
		}

		if (lib == 0)
			libero = false;
	}

}
