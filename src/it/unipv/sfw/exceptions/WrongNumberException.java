package it.unipv.sfw.exceptions;

public class WrongNumberException extends Exception {

	public WrongNumberException() {
		super("Il numero della carta inserito non è valido!");
	}
	
}
