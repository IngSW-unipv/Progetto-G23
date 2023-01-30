package it.unipv.sfw.model.partita;

import java.util.ArrayList;

/**
 * Classe che rappresenta un anello dello {@link Stadio}.
 * @author Lorenzo Reale
 * @see Stadio
 */
public class Anello {

	private int nAnello;
	private ArrayList<Posto> posti;
	private boolean libero;

	public Anello(int nAnello) {
		this.nAnello = nAnello;
		libero = true;
		posti = new ArrayList<Posto>();
	}

	/**
	 * Funzione utilizzata per segnalare che l'anello è pieno.
	 * @param False se è pieno, altrimenti true.
	 */
	public void setLibero(boolean lib) {
		libero = lib;
	}

	/**
	 * @return False se l'anello è occupato, altrimenti true.
	 */
	public boolean getLibero() {
		return libero;
	}

	/**
	 * Funzione utilizzata per aggiungere posti all'anello.
	 * @param numero di posti da aggiungere
	 */
	public void generaPosti(int nPosti) {
		for (int i = 0; i < nPosti; i++) {
			Posto p = new Posto(i);
			posti.add(p);
		}
	}

	/**
	 * Funzione utilizzata per rimuovere un posto.
	 */
	public void removePosto() {
		posti.remove(posti.size());
	}

	/**
	 * Funzione utilizzata per settare l'anello occupato se non ci sono più posti liberi.
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

	/**
	 * @return Il numero dell'anello.
	 */
	public int getNAnello() {
		return nAnello;
	}

}
