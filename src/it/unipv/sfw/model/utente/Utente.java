package it.unipv.sfw.model.utente;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;

/**
 * Classe astratta che rappresenta un generico
 * usufruitore del programma Stadium System,
 * viene estesa da {@link Cliente} e da {@link Admin}.
 * @author Federico Romano
 * @see Cliente
 * @see Admin
 */
public abstract class Utente {
	public enum Type {
		GIORNALISTA, ADMIN, CLIENTE
	}

	protected String nome;
	protected String cognome;
	protected String email;
	protected String password;

	public Utente(String nome, String cognome, String email, String pass) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = pass;
	}
	
	/**
	 * @return Il tipo di utente (giornalista, admin o cliente).
	 */
	public abstract Type getType();
	
	/**
	 * Funzione che cambia la password.
	 * @param pass Password nuova dell'utente.
	 */
	public void changePassword(String pass) {
		this.password = pass;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Funzione che cambia la mail.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Funzione che cambia il nome.
	 * @param nome Nome nuovo dell'utente.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Funzione che cambia il cognome.
	 * @param cognome Cognome nuovo del'utente.
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * @return L'email del cliente.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @return Il nome del cliente.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return il cognome del cliente.
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Controlla che il cliente sia valido, altrimenti lancia un'eccezione.
	 * @throws WrongEmailFormatException
	 * @throws EmptyFieldException
	 */
	public void checkValidity() throws WrongEmailFormatException, EmptyFieldException {
		final Predicate<String> isBlack = s -> s.chars().allMatch(c -> Character.isWhitespace(c));
	
		// Controlla che non vi siano campi vuoti
		if (isBlack.test(nome) || isBlack.test(cognome) || isBlack.test(password))
			throw new EmptyFieldException();
		// Controlla formato email
		checkEmail(email);
	}
	
	
	/**
	 * Controlla che l'email passata sia valida.
	 * @param email
	 * @throws WrongEmailFormatException
	 */
	public static void checkEmail(String email) throws WrongEmailFormatException {
		final Predicate<String> isEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", Pattern.CASE_INSENSITIVE)
					.asPredicate();
		
		if(!isEmail.test(email)) {
			throw new WrongEmailFormatException(email);
		}
	}

}
