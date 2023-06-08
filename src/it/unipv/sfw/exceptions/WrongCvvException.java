package it.unipv.sfw.exceptions;

public class WrongCvvException extends Exception {

	public WrongCvvException() {
		super("Il cvv inserito non è valido!");
	}
	
}
