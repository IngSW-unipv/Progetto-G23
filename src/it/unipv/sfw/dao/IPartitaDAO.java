package it.unipv.sfw.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;

import it.unipv.sfw.dao.mysql.PartitaDAO;
import it.unipv.sfw.model.partita.Partita;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.partita.Partita}.
 * @author Federico Romano
 * @see PartitaDAO
 * @see it.unipv.sfw.model.partita.Partita
 */
public interface IPartitaDAO {

	/**
	 * @return Un array che contiene tutte le partite registrate nel database.
	 */
	ArrayList<Partita> selectAllOrdered();

	/**
	 * @param dataPartita Data identificativa di un partita.
	 * @return La partita che possiede nel campo 'data' la data passata come parametro.
	 */
	Partita selectPartitaByData(Calendar dataPartita);

	/**
	 * @param newPartita Partita da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	boolean insertPartita(Partita newPartita) throws SQLIntegrityConstraintViolationException;

	/**
	 * @param newPartita Partita di cui si vuole aggiornare il campo 'bigliettirimanenti'.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updatePartita(Partita newPartita);

}