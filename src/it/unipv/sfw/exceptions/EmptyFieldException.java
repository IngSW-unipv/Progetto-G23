package it.unipv.sfw.exceptions;


/**
 * Eccezione utilizzata quando non tutti i campi sono stati riempiti.
 * 
 * @author Gabriele Invernizzi
 *
 */
public class EmptyFieldException extends Exception {
	
	public EmptyFieldException() {
		super("Alcuni campi sono vuoti.");
	}
}
