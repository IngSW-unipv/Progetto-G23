package it.unipv.sfw.exceptions;

/**
 * Eccezione utilizzata nel caso in cui sia richiesto un account inesistente.
 *
 * @author Gabriele Invernizzi
 *
 */
public class AccountNotFoundException extends Exception {

	private String accountEmail;

	/**
	 * @param email Email dell'account richiesto ma inesistente.
	 */
	public AccountNotFoundException(String email) {
		super("L'account " + email + " è inesistente.");
		accountEmail = email;
	}

	/**
	 * @return Email identificativa dell'account richiesto ma inesistente.
	 */
	public String getAccountEmail() {
		return accountEmail;
	}
}
