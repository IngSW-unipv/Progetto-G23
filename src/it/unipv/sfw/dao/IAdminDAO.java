package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.model.utente.Admin;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.utente.Admin}.
 * @author Federico Romano
 * @see AdminDAO
 * @see it.unipv.sfw.model.utente.Admin
 */
public interface IAdminDAO {
	
	/**
	 * @return Un array che contiene tutti gli admin registrati nel database.
	 * @see it.unipv.sfw.model.utente.Admin
	 */
	ArrayList<Admin> selectAll();
	
	/**
	 * @param email Email identificativa dell'admin.
	 * @return L'admin che è registrato nel database con la mail passata come parametro.
	 */
	Admin selectByEmail(String email);
	
	/**
	 * @param adminInput Admin da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False. 
	 */
	boolean insertAdmin(Admin adminInput);

	/**
	 * @param newPassword Nuova password per l'utente.
	 * @param account Admin di cui cambiare la passord.
	 * @return True se il cambiamento è avvenuto con successo, altrimenti False.
	 */
	boolean updatePassword(String newPassword, Admin account);

}