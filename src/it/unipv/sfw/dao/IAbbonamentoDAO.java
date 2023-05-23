package it.unipv.sfw.dao;

import it.unipv.sfw.dao.mysql.AbbonamentoDAO;
import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Cliente;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.abbonamento.Abbonamento}.
 * @author Federico Romano
 * @see AbbonamentoDAO
 * @see it.unipv.sfw.model.abbonamento.Abbonamento
 */
public interface IAbbonamentoDAO {
	
	/**
	 * Funzione che permette l'inserimento nel database di un nuovo abbonato.
	 * @param nuovoAbbonato Cliente che diventa abbonato. 
	 * @return True se l'inserimento è avvenuto con successo, altrimenti ritorna False.
	 */
	boolean insertAbbonamento(Cliente nuovoAbbonato);
	
	/**
     * Funzione che permette di cambiare il valore del campo 'livello' associato all'abbonato nel database.
     * @param nuovoAbbonato Cliente che effettua l'upgrade del suo abbonamento.
     * @param livello Livello dell'abbonamento a cui l'abbonato effettua l'upgrade.
     * @return True se l'aggiornamento è avvenuto con successo, altrimenti ritorna False.
     */
	boolean updateAbbonamento(Cliente nuovoAbbonato, TipoAbb livello);

}