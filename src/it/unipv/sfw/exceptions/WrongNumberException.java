package it.unipv.sfw.exceptions;

/**
 * Eccezione utilizzata quando il numero di carta è errato.
 *
 * @author Lorenzo Reale
 *
 */
public class WrongNumberException extends Exception {

	public WrongNumberException() {
		super("Il numero della carta inserito non è valido!");
	}

}
