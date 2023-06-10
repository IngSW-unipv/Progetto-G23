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

	@Override
	public Type getType() {
		return Utente.Type.ADMIN;
	}
}
