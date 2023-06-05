package it.unipv.sfw.model.partita;

import java.util.ArrayList;
import java.util.Calendar;

import it.unipv.sfw.dao.DAOFactory;

/**
 * Classe che rappresenta lo stadio accessibile al {@link it.unipv.sfw.model.utente.Cliente}.
 * @author Lorenzo Reale, Gabriele Invernizzi
 * @see it.unipv.sfw.model.utente.Cliente
 */
public class Stadio {

	private ArrayList<Posto> posti;

	public Stadio(Calendar dataPartita) {
		posti = DAOFactory.createIPostoDAO().selectByData(dataPartita);
	}


	/**
	 * Controlla se un posto è libero.
	 * @param settore
	 * @param anello
	 * @param blocco
	 * @param posto
	 * @return true se è libero, falso altrimenti.
	 */
	public boolean isLibero(int settore, int anello, int blocco, int posto) {	
		return !posti.stream()
			.filter(p -> {
				return p.getNSettore() == settore &&
						p.getNAnello() == anello &&
						p.getNBlocco() == blocco &&
						p.getNPosto() == posto;
			})
			.findAny()
			.isPresent();
	}

}
