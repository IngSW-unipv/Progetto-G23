package it.unipv.sfw.model.utente;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cliente extends Utente {
	private Calendar dataNascita;
	private boolean isGiornalista;

	public Cliente(String nome, String cognome, String email, String pass) {
		super(nome, cognome, email, pass);
		isGiornalista = false;
	}

	public String getDataNascita() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd / MMM / YYYY");
		return formattedDate.format(dataNascita);
	}

	public void setTypeToGiornalista() {
		isGiornalista = true;
	}

	@Override
	public Type getType() {
		return isGiornalista ? Utente.Type.GIORNALISTA : Utente.Type.CLIENTE;
	}

	public void acquistaBiglietto() {
		// integrare
	}
}
