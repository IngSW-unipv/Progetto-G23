package it.unipv.sfw.exceptions;

/**
 * Eccezione che inteviene nel momento in cui la password inserita dall'utente,
 * relativa al suo account, sia sbagliata.
 *
 * @author Simone Platano
 */
public class WrongPasswordException extends Exception {

	private String accountEmail;

	/**
	 * @param email La email relativa all'account dell'utente che ha inserito la
	 *              password ma è errata.
	 */
	public WrongPasswordException(String email) {
		super("La password relativa all' account " + email + " è sbagliata");
		accountEmail = email;
	}

	/**
	 * @return La email relativa all'account dell'utente che ha inserito la password
	 *         ma è errata.
	 */
	public String getAccountEmail() {
		return accountEmail;
	}
}
