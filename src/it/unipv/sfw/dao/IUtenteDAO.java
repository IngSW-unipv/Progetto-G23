package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.model.utente.Utente.Type;

public interface IUtenteDAO {

	ArrayList<Utente> selectAll();

	boolean insertUtente(Utente u);

	Utente selectByEmail(String email);

	Type selectByEmailAndPassword(String email, String password);

}