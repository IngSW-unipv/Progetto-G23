package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.model.utente.Admin;
import it.unipv.sfw.model.utente.Cliente;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Federico Romano
 * @see ClienteDAO
 * @see it.unipv.sfw.model.utente.Cliente
 */
public interface IClienteDAO {

	/**
	 * @return Un array che contiene tutti i clienti registrati nel databse.
	 */
	ArrayList<Cliente> selectAll();

	/**
	 * @param email Email a cui è associato il cliente che sto cercando.
	 * @return Il cliente che si è registrato con la mail passata come parametro.
	 */
	Cliente selectByEmail(String email);

	/**
	 * @param clienteInput Cliente da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertCliente(Cliente clienteInput);

	/**
	 * @param newPassword Nuova password per l'utente.
	 * @param account Cliente di cui cambiare la passord.
	 * @return True se il cambiamento è avvenuto con successo, altrimenti False.
	 */
	boolean updatePassword(String newPassword, Cliente account);

}