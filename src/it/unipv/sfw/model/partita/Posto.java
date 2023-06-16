package it.unipv.sfw.model.partita;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe che rappresenta un posto dello {@link Stadio}.
 *
 * @author Lorenzo Reale, Gabriele Invernizzi
 * @see Stadio
 */
public class Posto {

	private int nSettore, nBlocco, nAnello, nPosto;
	private Calendar data;

	public Posto(int nSettore, int nAnello, int nBlocco, int nPosto, Calendar data) {
		this.nPosto = nPosto;
		this.data = data;
		this.nBlocco = nBlocco;
		this.nAnello = nAnello;
		this.nSettore = nSettore;
	}

	/**
	 * @return La data della partita che è associata al posto.
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @return La data in formato "yyyy-MM-dd HH:mm:ss".
	 */
	public String getDataPerDB() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formattedDate.format(data.getTime());
	}

	/**
	 * @return Il numero dell'anello.
	 */
	public int getNAnello() {
		return nAnello;
	}

	/**
	 * @return Il numero del blocco.
	 */
	public int getNBlocco() {
		return nBlocco;
	}

	/**
	 * @return Il numero del posto.
	 */
	public int getNPosto() {
		return nPosto;
	}

	/**
	 * @return Il numero del settore.
	 */
	public int getNSettore() {
		return nSettore;
	}

	/**
	 * @param data
	 */
	public void setData(Calendar data) {
		this.data = data;
	}
}
