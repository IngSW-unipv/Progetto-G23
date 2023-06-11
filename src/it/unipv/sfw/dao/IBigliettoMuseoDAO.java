package it.unipv.sfw.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import it.unipv.sfw.dao.mysql.BigliettoMuseoDAO;
import it.unipv.sfw.model.biglietti.Biglietto;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.biglietti.Biglietto}.
 * @author Federico Romano
 * @see BigliettoMuseoDAO
 * @see it.unipv.sfw.model.biglietti.Biglietto
 */
public interface IBigliettoMuseoDAO {
	
	/**
	 * @param ticket Biglietto da inserire nel databse.
	 * @param emailConferma Email a cui vengono mandati i biglietti acquistati.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	boolean insertBigliettiMuseo(Biglietto ticket, int numeroPersone) throws SQLIntegrityConstraintViolationException;

	/**
	 * @return Un array che contiene tutti i biglietti registrati nel database.
	 */
	ArrayList<Biglietto> selectAll();

}