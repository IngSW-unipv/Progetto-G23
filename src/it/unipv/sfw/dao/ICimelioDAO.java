package it.unipv.sfw.dao;

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

}