package it.unipv.sfw.model.partita;

import java.util.ArrayList;

/**
 * Classe che rappresenta un settore dello {@link Stadio}.
 * @author Lorenzo Reale
 * @see Stadio
 */
public class Settore {

	private int nSettore;
	private ArrayList<Blocco> blocchi;
	private boolean libero;

	public Settore(int nSettore) {
		this.nSettore = nSettore;
		libero = true;
		blocchi = new ArrayList<>();
	}

	/**
	 * Funzione utilizzata per segnalare che il settore è pieno.
	 * @param lib False se è pieno, altrimenti true.
	 */
	public void setLibero(boolean lib) {
		libero = lib;
	}

	/**
	 * @return False se il settore è occupato, altrimenti true.
	 */
	public boolean getLibero() {
		return libero;
	}

	/**
	 * Funzione utilizzata per aggiungere blocchi allo stadio.
	 * @param nAnelli Numero di blocchi da generare.
	 */
	public void generaBlocchi(int nAnelli) {
		for (int i = 0; i < nAnelli; i++) {
			Blocco a = new Blocco(i);
			blocchi.add(a);
		}
	}

	/**
	 * Funzione utilizzata per rimuovere un blocco.
	 */
	public void removeBlocco() {
		blocchi.remove(blocchi.size());
	}

	/**
	 * Funzione utilizzata per settare il settore occupato se non ci sono più blocchi liberi.
	 */
	public void checkLibero() {
		int lib = 0;

		for (int i = 0; i < blocchi.size(); i++) {
			if (blocchi.get(i).getLibero() == true)
				lib++;
		}

		if (lib == 0)
			libero = false;
	}

	/**
	 * @return Il numero del settore.
	 */
	public int getNSettore() {
		return nSettore;
	}

}
