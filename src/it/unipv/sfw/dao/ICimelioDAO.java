package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.model.museo.Cimelio;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.museo.Cimelio}.
 * @author Federico Romano
 * @see CimelioDAO
 * @see it.unipv.sfw.model.museo.Cimelio
 */
public interface ICimelioDAO {

	/**
	 * @param cim Cimelio da inserire nel database.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertCimelio(Cimelio cim);
	
	/**
	 * @param cimelio Cimelio di cui aaggiornare il campo 'descrizione' nel database.
	 * @return True se l'aggiornamento è avvenuto con successo, altrimenti False.
	 */
	boolean updateDescrizione(Cimelio cimelio);
	
	/**
	 * @return Un array contenente tutti i cimeli registrati nel database.
	 */
	ArrayList<Cimelio> selectAll();
	
	/**
	 * @param item Cimelio attraverso il cui id è possibile prelevarlo dal database.
	 * @return Il cimelio passato come parametro che è presente nel database.
	 */
	Cimelio selectById(Cimelio item);

}