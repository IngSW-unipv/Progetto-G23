package it.unipv.sfw.model.partita;

/**
 * Classe che rappresenta un posto dello {@link Stadio}.
 * @author Lorenzo Reale
 * @see Stadio
 */
public class Posto {

	private int nPosto;
	private boolean libero;

	public Posto(int nPosto) {
		this.nPosto = nPosto;
		libero = true;
	}

	/**
	 * Funzione utilizzata per segnalare che un posto è pieno.
	 * @param  lib False se è pieno, altrimenti true.
	 */
	public void setLibero(boolean lib) {
		libero = lib;
	}

	/**
	 * @return False se il posto è occupato, altrimenti true.
	 */
	public boolean getLibero() {
		return libero;
	}

	/**
	 * @return Il numero del posto.
	 */
	public int getNPosto() {
		return nPosto;
	}
}
