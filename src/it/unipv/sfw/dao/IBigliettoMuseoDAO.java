package it.unipv.sfw.dao;

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
	 * @param numeroPersone Numero di biglietti acquistati dalla stessa persona.
	 * @param emailConferma Email a cui vengono mandati i biglietti acquistati.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertBigliettiMuseo(Biglietto ticket, int numeroPersone, String emailConferma);

}