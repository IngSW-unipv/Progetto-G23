package it.unipv.sfw.model.utente;


/**
 * Classe che estende {@link Utente} e rappresenta l'admin. 
 * @author Federico Romano
 * @see Utente
 */
public class Admin extends Utente {

	public Admin(String nome, String cognome, String email, String pass) {
		super(nome, cognome, email, pass);
	}
	
	/**
	 * Funzione che crea un {@link Cliente} di tipo giornalista.
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param pass
	 */
	public void addGiornalista(String nome, String cognome, String email, String pass) {
		Cliente giornalista = new Cliente(nome, cognome, email, pass);
		giornalista.setTypeToGiornalista();
	}

	@Override
	public Type getType() {
		return Utente.Type.ADMIN;
	}
}
