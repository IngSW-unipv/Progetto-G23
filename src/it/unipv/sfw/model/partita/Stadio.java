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

	public final int N_SETTORI = 8;
	public final int ANELLI_PER_SETTORE = 3;
	public final int BLOCCHI_PER_ANELLO = 50;
	public final int POSTI_PER_BLOCCO = 50;
	
	private ArrayList<Posto> posti;

	/**
	 * @param dataPartita Data della partita interessata.
	 */
	public Stadio(Calendar dataPartita) {
		posti = DAOFactory.createIPostoDAO().selectByData(dataPartita);
	}
	
	/**
	 * Costruttore utilizzato principalmente per testing.
	 * @param postiOccupatiPartita ArrayList di posti occupati in una determinata partita.
	 */
	public Stadio(ArrayList<Posto> postiOccupatiPartita) {
		posti = postiOccupatiPartita;
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
		for (Posto p : posti) {
			if (p.getNSettore() == settore &&
				p.getNAnello() == anello &&
				p.getNBlocco() == blocco &&
				p.getNPosto() == posto)
				return false;
		}
		return true;
	}
	
	/**
	 * Controlla se un blocco è libero.
	 * @param settore
	 * @param anello
	 * @param blocco
	 * @return true se è libero, falso altrimenti.
	 */
	public boolean isLibero(int settore, int anello, int blocco) {	
		long postiOccInBlocco = posti.stream()
				.filter(p -> {
					return p.getNSettore() == settore &&
							p.getNAnello() == anello &&
							p.getNBlocco() == blocco;
				})
				.count();
		
		return postiOccInBlocco >= POSTI_PER_BLOCCO ? false : true;
	}
	
	/**
	 * Controlla se un anello è libero.
	 * @param settore
	 * @param anello
	 * @return true se è libero, falso altrimenti.
	 */
	public boolean isLibero(int settore, int anello) {	
		long blocchiOccInAnello = posti.stream()
				.filter(p -> {
					return p.getNSettore() == settore &&
							p.getNAnello() == anello;
				})
				.count();
		
		return blocchiOccInAnello >= BLOCCHI_PER_ANELLO ? false : true;
	}
	
	/**
	 * Controlla se un settore è libero.
	 * @param settore
	 * @return true se è libero, falso altrimenti.
	 */
	public boolean isLibero(int settore) {	
		long anelliOccInSettore = posti.stream()
				.filter(p -> p.getNSettore() == settore)
				.count();
		
		return anelliOccInSettore >= ANELLI_PER_SETTORE ? false : true;
	}
}
