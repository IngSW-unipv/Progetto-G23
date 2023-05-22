package it.unipv.sfw.model.utente;

import java.util.HashMap;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import it.unipv.sfw.dao.ClienteDAO;
import it.unipv.sfw.exceptions.AccountAlreadyExistsException;
import it.unipv.sfw.exceptions.AccountNotFoundException;
import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.exceptions.WrongPasswordException;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.store.Merchandising;


/**
 * Classe che rappresenta la sessione corrente.
 * @author Federico Romano, Lorenzo Reale, Gabriele Invernizzi
 * @see Utente
 * @see Anello
 * @see Settore
 * @see Posto
 * @see Blocco
 */
public class Sessione {
	private static Sessione istance = null;
	private HashMap<String, Integer> scelte;
	private HashMap<Merchandising, Integer> carrello;
	private Partita currentPartita;
	private Utente currentUtente;

	private Sessione() {	
		currentUtente = null;
		currentPartita = null;
		carrello = null;
		scelte = new HashMap<>();
	}
	
	
	/**
	 * @return L'istanza corrente di {@link Sessione}, nel caso non esista la crea.
	 */
	public static Sessione getIstance() {
		if (istance == null) {
			istance = new Sessione();
		}
		return istance;
	}
	
	/**
	 * Funzione che verifica nel database se l'utente specificato esiste 
	 * controllandone anche la password.
	 * @param email Email dell'utente di cui si vuole eseguire il login.
	 * @param pass Password dell'utente di cui si vuole eseguire il login.
	 * @throws WrongPasswordExceptio Lanciata nel caso in cui la password sia errata.
	 * @throws AccountNotFoundException Lanciata nel caso in cui l'account non esista. 
	 */
	public void login(String email, char[] pass)
			throws WrongPasswordException, AccountNotFoundException {
		Cliente c = new ClienteDAO().selectByEmail(email);
		
		String strPass = new String(pass);
		
		if (c == null)
			throw new AccountNotFoundException(email);
		if (!c.getPassword().equals(strPass))
			throw new WrongPasswordException(email);
		
		this.setCurrentUtente(c);
	}
	
	/**
	 * Funzione che inserisce un nuovo cliente nel database ed esegue il login.
	 * @param c Cliente da registrare.
	 * @throws AccountAlreadyExistsException.
	 * @throws EmptyFieldException.
	 * @throws WrongEmailFormatException.
	 */
	public void register(Cliente c)
		throws AccountAlreadyExistsException, EmptyFieldException, WrongEmailFormatException {
		// Controlla che il cliente sia valido
		c.checkValidity();
		// Inserisci in db
		if(!(new ClienteDAO().insertCliente(c)))
			throw new AccountAlreadyExistsException(c.getEmail());
		// Login
		this.setCurrentUtente(c);
	}
	
	/**
	 * Funzione utilizzata per registrare la prenotazione di una partita.
	 * Le scelte vengono automaticamente resettate.
	 */
	public void book() {	
		this.resetScelte();
	}

	
	/**
	 * Funzione che resetta i campi sessione riguardanti 
	 * {@link Anello}, {@link Posto}, {@link Settore}, {@link Blocco}, {@link Partita}, {@link Merchandising}
	 * a null.
	 */
	public void resetScelte() {
		scelte.clear();
		carrello = null;
		currentPartita = null;
	}

	/**
	 * @return {@link Utente} della sessione corrente.
	 */
	public Utente getCurrentUtente() {
		return currentUtente;
	}
	
	/**
	 * Funzione che permette di impostare come {@link Utente} corrente 
	 * quello passato come parametro.
	 * @param currentU Utente corrente della sessione.
	 */
	public void setCurrentUtente(Utente currentU) {
		currentUtente = currentU;
	}
	
	/**
	 * Funzione che permette di impostare come {@link Partita} corrente 
	 * quella passato come parametro.
	 * @param currentP Partita corrente della sessione.
	 */
	public void setCurrentPartita(Partita currentP) {
		currentPartita = currentP;
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Blocco}.
	 * @param blocco
	 */
	public void setBlocco(int blocco) {
		scelte.put("Blocco", blocco);
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Anello}.
	 * @param anello
	 */
	public void setAnello(int anello) {
		scelte.put("Anello", anello);
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Settore}.
	 * @param settore
	 */
	public void setSettore(int settore) {
		scelte.put("Settore", settore);
	}
	
	/**
	 * Funzione utilizzata per settare il {@link Posto}.
	 * @param posto
	 */
	public void setPosto(int posto) {
		scelte.put("Posto", posto);
	}
	
	/**
	 * @param carrello HashMap di store items.
	 */
	public void setCarrello(HashMap<Merchandising, Integer> carrello) {
		this.carrello = carrello;
	}
	
	/**
	 * @return {@link Blocco} della sessione corrente.
	 */
	public int getBlocco() {
		return scelte.get("Blocco");
	}
	
	/**
	 * @return {@link Anello} della sessione corrente.
	 */
	public int getAnello() {
		return scelte.get("Anello");
	}
	
	/**
	 * @return {@link Settore} della sessione corrente.
	 */
	public int getSettore() {
		return scelte.get("Settore");
	}
	
	/**
	 * @return {@link Posto} della sessione corrente.
	 */
	public int getPosto() {
		return scelte.get("Posto");
	}
	
	/**
	 * @return {@link Partita} selezionata.
	 */
	public Partita getCurrentPartita() {
		return currentPartita;
	}
	
	/**
	 * @return HashMap di item nel carrello.
	 */
	public HashMap<Merchandising, Integer> getCarrello() {
		return carrello;
	}
}
