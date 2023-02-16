package it.unipv.sfw.model.utente;


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

}
