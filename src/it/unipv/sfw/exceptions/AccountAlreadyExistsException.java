package it.unipv.sfw.exceptions;


/**
 * Eccezione utilizzata quando viene creato un utente ma esiste già.
 * 
 * @author Gabriele Invernizzi
 *
 */
public class AccountAlreadyExistsException extends Exception {
	
	private String accountEmail;

	/**
	 * @param email Email dell'account che esiste già.
	 */
	public AccountAlreadyExistsException(String email) {
		super("Esiste già un account con l'email: " + email + ".");
		accountEmail = email;
	}
	
	/**
	 * @return Email identificativa dell'account che esiste già.
	 */
	public String getAccountEmail() {
		return accountEmail;
	}
}
