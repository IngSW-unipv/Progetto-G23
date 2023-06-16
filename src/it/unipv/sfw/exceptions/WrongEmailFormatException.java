package it.unipv.sfw.exceptions;

/**
 * Eccezione utilizzata nel caso in cui la mail inserita non sia in un formato
 * valido.
 *
 * @author Federico Romano
 *
 */
public class WrongEmailFormatException extends Exception {

	/**
	 * @param input Email inserita il cui formato non è valido.
	 */
	public WrongEmailFormatException(String email) {
		super("Il formato email inserito non è valido");
	}

}
