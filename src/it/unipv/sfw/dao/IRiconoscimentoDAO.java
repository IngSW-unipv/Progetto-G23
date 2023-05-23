package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.dao.mysql.RiconoscimentoDAO;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.museo.Riconoscimento}.
 * @author Federico Romano
 * @see RiconoscimentoDAO
 * @see it.unipv.sfw.model.museo.Riconoscimento
 */
public interface IRiconoscimentoDAO {

	/**
	 * @param riconoscimento Riconoscimento da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo altrimenti False.
	 */
	boolean insertRiconoscimento(Riconoscimento riconoscimento);

	/**
	 * @param riconoscimento Riconoscimento di cui aggiornare il campo 'descrizione' nel databse.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updateDescrizione(Riconoscimento riconoscimento);
	
	/**
	 * @return Un array contenente tutti i riconoscimenti registrati nel database.
	 */
	ArrayList<Riconoscimento> selectAll();
	
	/**
	 * @param item Riconoscimento attraverso il cui id è possibile prelevarlo dal database.
	 * @return Il riconoscimento passato come parametro che è presente nel database.
	 */
	Riconoscimento selectById(Riconoscimento item);
	
	/*
	 * @return Un array che contiene tutti i riconoscimenti presenti nel database, ordinati in base all'anno.
	 */
	ArrayList<Riconoscimento> selectAllOrderByData();

}