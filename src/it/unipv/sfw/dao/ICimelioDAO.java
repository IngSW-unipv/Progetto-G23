package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.dao.mysql.CimelioDAO;
import it.unipv.sfw.model.museo.Cimelio;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.museo.Cimelio}.
 *
 * @author Federico Romano
 * @see CimelioDAO
 * @see it.unipv.sfw.model.museo.Cimelio
 */
public interface ICimelioDAO {

	/**
	 * @param id Id identificativo dell'oggetto da eliminare.
	 * @return True se l'eliminazione è avvenuta con successo, altrimenti False.
	 */
	boolean deleteById(int id);

	/**
	 * @param cim Cimelio da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertCimelio(Cimelio cim);

	/**
	 * @return Un array contenente tutti i cimeli registrati nel database.
	 */
	ArrayList<Cimelio> selectAll();

	/*
	 * @return Un array che contiene tutti i cimeli presenti nel database, ordinati
	 * in base all'anno.
	 */
	ArrayList<Cimelio> selectAllOrderByData();

	/**
	 * @param id Id del Cimelio attraverso cui è possibile prelevarlo dal database.
	 * @return Il cimelio passato come parametro che è presente nel database.
	 */
	Cimelio selectById(int id);

	/**
	 * @param c Cimelio di cui ritornare l'id con cui è salvato nel database.
	 * @return Id del cimelio.
	 */
	int selectId(Cimelio c);

	/**
	 * @param cimelio Cimelio di cui aaggiornare il campo 'descrizione' nel
	 *                database.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updateDescrizione(Cimelio cimelio);

}