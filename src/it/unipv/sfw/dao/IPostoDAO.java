package it.unipv.sfw.dao;

import java.util.ArrayList;
import java.util.Calendar;

import it.unipv.sfw.model.partita.Posto;

/**
 * Interfaccia DAO per {@link it.unipv.sfw.model.partita.Posto}.
 * @author Federico Romano
 * @see PostoDAO
 * @see it.unipv.sfw.model.partita.Posto
 */
public interface IPostoDAO {

	/**
	 * @param dataPartita Data identificativa di una partita di cui si vuole conoscere i posti occupati.
	 * @return Il numero di posti occupati.
	 */
	int selectCount(Calendar dataPartita);

	/**
	 * @return Un array che contiene tutti i posti occupati per ciascuna partita.
	 */
	ArrayList<Posto> selectAllOrderBydata();

}