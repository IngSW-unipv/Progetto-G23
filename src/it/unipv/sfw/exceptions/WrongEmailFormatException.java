package it.unipv.sfw.exceptions;

public class WrongEmailFormatException extends Exception {
	
	public WrongEmailFormatException(String email) {
		super("Il formato email inserito non è valido");
	}
	
}
