package it.unipv.sfw.dao;

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

}