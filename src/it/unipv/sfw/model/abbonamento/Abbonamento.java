package it.unipv.sfw.model.abbonamento;

/**
 * Classe che rappresenta l'abbonamento acquistabile dal
 * {@link it.unipv.sfw.model.utente.Cliente}.
 *
 * @author Federico Romano
 * @see TipoAbb
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Abbonamento {
	private TipoAbb tipoAbb;
	private double prezzo;

	public Abbonamento() {
	}

	public Abbonamento(TipoAbb tipo) {
		this.tipoAbb = tipo;
		this.prezzo = this.getPrezzo();
	}

	/**
	 * @return Il prezzo dell'abbonamento.
	 */
	public double getPrezzo() {
		switch (this.tipoAbb) {
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
	 * @return Fattore di sconto in base al tipo di abbonamento.
	 */
	public double getSconto() {
		switch (this.tipoAbb) {
		case LIV1:
			return 0.75;
		case LIV2:
			return 0.5;
		case LIV3:
			return 0.25;
		default:
			return 1.0;
		}
	}

	/**
	 * @return Il tipo di abbonamento.
	 */
	public TipoAbb getTipoAbb() {
		return tipoAbb;
	}

	/**
	 * Funzione utilizzata per cambiare il prezzo dell'abbonamento.
	 *
	 * @param prezzo
	 * @return True se l'operazione è andata a buon fine, altrimenti false.
	 */
	public boolean setPrezzo(double prezzo) {
		if (prezzo >= 0) {
			this.prezzo = prezzo;
			return true;
		} else
			return false;
	}

	/**
	 * Funzione utilizzata per cambiare il tipo di abbonamento.
	 *
	 * @param tipo Tipo dell'abbonamento.
	 */
	public void setTipoAbb(TipoAbb tipo) {
		tipoAbb = tipo;
	}

}
