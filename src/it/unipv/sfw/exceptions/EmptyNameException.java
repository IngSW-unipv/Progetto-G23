package it.unipv.sfw.exceptions;

public class EmptyNameException extends Exception {

	public EmptyNameException() {
		super("Non è stato inserito alcun nome e/o cognome!");
	}
	
}
