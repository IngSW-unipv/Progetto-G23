package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.model.utente.Utente.Type;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.utente.Utente}.
 * @author Federico Romano
 * @see UtenteDAO
 * @see it.unipv.sfw.model.utente.Utente
 */
public interface IUtenteDAO {

	/**
	 * @return Un array che contiene tutti gli utenti presenti nel database.
	 */
	ArrayList<Utente> selectAll();

	/**
	 * @param u Utente da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertUtente(Utente u);

	/**
	 * @param email Email dell'utente che voglio selezionare.
	 * @return L'utente che è registrato nel database con l'email passata come parametro.
	 */
	Utente selectByEmail(String email);

	/**
	 * @param email Email dell'utente che voglio selezionare.
	 * @param password Password dell'utente che voglio selezionare.
	 * @return L'utente che è registrato nel database con l'email e la password passate come parametri.
	 */
	Type selectByEmailAndPassword(String email, String password);

	/**
	 * @param newPassword Nuova password per l'utente.
	 * @param account Utente di cui cambiare la passord.
	 * @return True se il cambiamento è avvenuto con successo, altrimenti False.
	 */
	boolean updatePassword(String newPassword, Utente account);

}