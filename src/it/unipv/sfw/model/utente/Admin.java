package it.unipv.sfw.model.utente;

public class Admin extends Utente {

	public Admin(String nome, String cognome, String email, String pass) {
		super(nome, cognome, email, pass);
	}

	public void addGiornalista(String nome, String cognome, String email, String pass) {
		Cliente giornalista = new Cliente(nome, cognome, email, pass);
		giornalista.setTypeToGiornalista();
	}

	@Override
	public Type getType() {
		return Utente.Type.ADMIN;
	}
}
