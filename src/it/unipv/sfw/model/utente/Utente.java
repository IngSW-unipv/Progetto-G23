package it.unipv.sfw.model.utente;

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

	public abstract Type getType();

	public void changePassword(String pass) {
		this.password = pass;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

}
