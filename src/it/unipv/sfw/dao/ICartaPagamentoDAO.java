package it.unipv.sfw.dao;

import java.util.ArrayList;

import it.unipv.sfw.pagamento.Carta;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.pagamento.Carta}.
 * @author Lorenzo Reale
 * @see CartaPagamentoDAO
 * @see it.unipv.sfw.model.pagamento.Carta
 */
public interface ICartaPagamentoDAO {

	/**
	 * @return Un arrayList che contiene tutte le carte possedute da un certo utente registrate nel database.
	 */
	ArrayList<Carta> selectAll();
	
	/**
	 * @param Carta carta da inserire nel db.
	 * @return True se l'inserimento è avvenuto con successo, altrimenti False.
	 */
	boolean insertCarta(Carta carta);
}