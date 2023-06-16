package it.unipv.sfw.exceptions;

/**
 * Eccezione utilizzata quando il campo nome non è stato inserito.
 *
 * @author Gabriele Invernizzi
 *
 */
public class EmptyNameException extends Exception {

	public EmptyNameException() {
		super("Non è stato inserito alcun nome e/o cognome!");
	}

}
