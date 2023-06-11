package it.unipv.sfw.dao;

import java.util.ArrayList;
import java.util.Calendar;

import it.unipv.sfw.dao.mysql.PostoDAO;
import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.utente.Utente;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.partita.Posto}.
 * @author Federico Romano
 * @see PostoDAO
 * @see it.unipv.sfw.model.partita.Posto
 */
public interface IPostoDAO {
	
	/**
	 * @param cliente Cliente a cui il posto è assegnato.
	 * @param posto Posto nuovo da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertPosto(Posto posto, Utente utente);
	
	/**
	 * @param dataPartita Data identificativa di una partita di cui si vuole conoscere i posti occupati.
	 * @return Il numero di posti occupati.
	 */
	int selectCount(Calendar dataPartita);

	/**
	 * @return Un array che contiene tutti i posti occupati per ciascuna partita.
	 */
	public ArrayList<Posto> selectAllOrderBydata();
	
	/**
	 * @return Un array che contiene tutti i posti occupati per la partita selezionata.
	 * @param dataPartita
	 */
	public ArrayList<Posto> selectByData(Calendar dataPartita);
	
	/**
	 * @param email Email identificativa del cliente di cui si vuole sapere il numero di biglietti acquistati.
	 * @return Il numero di biglietti acquistati dal cliente identificato dalla mail passata come parametro.
	 */
	int selectCount(String email);

}