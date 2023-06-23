package it.unipv.sfw.exceptions;

/**
 * Eccezione utilizzata quando il cvv è errato.
 *
 * @author Lorenzo Reale
 *
 */
public class WrongCvvException extends Exception {

	public WrongCvvException() {
		super("Il cvv inserito non è valido!");
	}

}
