package it.unipv.sfw.model.utente;

import java.util.Calendar;

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
	 * @param nome Nome del giornalista.
	 * @param cognome Cognome del gionalista.
	 * @param email Email del giornalista.
	 * @param pass Password del giornalista.
	 */
	public void addGiornalista(String nome, String cognome, String email, String pass, Calendar nascita) {
		Cliente giornalista = new Cliente(nome, cognome, email, pass, nascita);
		giornalista.setTypeToGiornalista();
	}

	@Override
	public Type getType() {
		return Utente.Type.ADMIN;
	}
}
