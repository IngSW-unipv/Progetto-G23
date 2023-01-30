package it.unipv.sfw.model.partita;

import java.util.ArrayList;

/**
 * Classe che rappresenta un blocco dello {@link Stadio}.
 * @author Lorenzo Reale
 * @see Stadio
 */
public class Blocco {

	private int nBlocco;
	private ArrayList<Anello> anelli;
	private boolean libero;

	public Blocco(int nBlocco) {
		this.nBlocco = nBlocco;
		libero = true;
		anelli = new ArrayList<Anello>();
	}

	/**
	 * Funzione utilizzata per segnalare che il blocco è pieno.
	 * @param lib False se è pieno, altrimenti true.
	 */
	public void setLibero(boolean lib) {
		libero = lib;
	}

	/**
	 * @return False se il blocco è pieno, altrimenti false.
	 */
	public boolean getLibero() {
		return libero;
	}

	/**
	 * Funzione utilizzata per generare degli anelli.
	 * @param nAnelli numero degli anelli da generare.
	 */
	public void generaAnelli(int nAnelli) {
		for (int i = 0; i < nAnelli; i++) {
			Anello a = new Anello(i);
			anelli.add(a);
		}
	}

	/**
	 * Funzione utilizzata per rimuovere un anello.
	 */
	public void removeAnello() {
		anelli.remove(anelli.size());
	}

	/**
	 * Funzione utilizzata per settare il blocco occupato se non ci sono più anelli liberi.
	 */
	public void checkLibero() {
		int lib = 0;

		for (int i = 0; i < anelli.size(); i++) {
			if (anelli.get(i).getLibero() == true)
				lib++;
		}

		if (lib == 0)
			libero = false;
	}

	/**
	 * @return Il numero del blocco.
	 */
	public int getNBlocco() {
		return nBlocco;
	}

}
