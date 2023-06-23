package it.unipv.sfw.model.utente;

import java.util.HashMap;
import java.util.Map.Entry;

import it.unipv.sfw.controller.CarrelloController;
import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.exceptions.AccountAlreadyExistsException;
import it.unipv.sfw.exceptions.AccountNotFoundException;
import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.OldPasswordReusedException;
import it.unipv.sfw.exceptions.PasswordPrecedenteErrataException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.exceptions.WrongPasswordException;
import it.unipv.sfw.model.abbonamento.Abbonamento;
import it.unipv.sfw.model.abbonamento.AbbType;
import it.unipv.sfw.model.biglietto.BigliettoMuseo;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.utilities.Pair;

/**
 * Classe che rappresenta la sessione corrente.
 *
 * @author Federico Romano, Lorenzo Reale, Gabriele Invernizzi
 * @see Utente
 * @see Anello
 * @see Settore
 * @see Posto
 * @see Blocco
 */
public class Sessione {
	private static Sessione istance = null;

	/**
	 * @return L'istanza corrente di {@link Sessione}, nel caso non esista la crea.
	 */
	public static Sessione getIstance() {
		if (istance == null) {
			istance = new Sessione();
		}
		return istance;
	}

	private HashMap<String, Integer> scelte;
	private HashMap<Merchandising, Integer> carrello;
	private Pair<Merchandising, Integer> merchAdmin;
	private Partita currentPartita;
	private Utente currentUtente;
	private HashMap<BigliettoMuseo, Integer> currentBiglietto;
	private int currentPagamento; // 0 - niente, 1 - carrello, 2 - museo, 3 - partita, 4 - abbonamento
	private AbbType abbToUpdate;

	private Sessione() {
		merchAdmin = null;
		currentUtente = null;
		currentPartita = null;
		currentPagamento = 0;
		carrello = null;
		currentBiglietto = null;
		scelte = new HashMap<>();
	}

	/**
	 *
	 * @param password
	 * @return la password commutata in stringa
	 * @throws OldPasswordReusedException
	 * @throws PasswordPrecedenteErrataException
	 */
	public void commutaPassword(Utente u, String vecchiaPassword, String nuovaPAssword)
			throws OldPasswordReusedException, PasswordPrecedenteErrataException {

		if (!(u.getPassword().equals(vecchiaPassword))) {
			throw new PasswordPrecedenteErrataException("Password precedente errata");
		}

		if (vecchiaPassword.equals(nuovaPAssword)) {
			throw new OldPasswordReusedException("La nuova password e quella precedente sono uguali");
		}

		DAOFactory.createIUtenteDAO().updatePassword(nuovaPAssword, u);
		Sessione.getIstance().getCurrentUtente().changePassword(nuovaPAssword);

	}

	/**
	 * @return {@link AbbType} della sessione corrente.
	 */
	public AbbType getAbbToUpdate() {
		return abbToUpdate;
	}
	
	/**
	 * @return prezzo dell'abbonamento da aggiornare.
	 */
	public double getPrezzoAbbToUpdate() {
		Abbonamento a = new Abbonamento(abbToUpdate);
		return a.getPrezzo();
	}

	/**
	 * @return {@link Anello} della sessione corrente.
	 */
	public int getAnello() {
		return scelte.get("Anello");
	}

	/**
	 * @return {@link Blocco} della sessione corrente.
	 */
	public int getBlocco() {
		return scelte.get("Blocco");
	}

	/**
	 * @return HashMap di item nel carrello.
	 */
	public HashMap<Merchandising, Integer> getCarrello() {
		return carrello;
	}

	/**
	 * @return {@link AbbType}.
	 */
	public Abbonamento getCurrentAbb() {
		if (currentUtente.getType() == Utente.Type.CLIENTE)
			return ((Cliente) currentUtente).getAbb();
		else
			return null;
	}

	public BigliettoMuseo getCurrentBiglietto() {
		BigliettoMuseo b = new BigliettoMuseo();

		for (Entry<BigliettoMuseo, Integer> entry : currentBiglietto.entrySet()) {
			b = entry.getKey();
		}

		return b;
	}

	/**
	 * @return {@link Pagamento} della sessione corrente.
	 */
	public int getCurrentPagamento() {
		return currentPagamento;
	}

	/**
	 * @return {@link Partita} selezionata.
	 */
	public Partita getCurrentPartita() {
		return currentPartita;
	}

	/**
	 * @return {@link Utente} della sessione corrente.
	 */
	public Utente getCurrentUtente() {
		return currentUtente;
	}

	/**
	 * @return Un Pair di merchandising e integer, quest'ultimo è la quantità.
	 */
	public Pair<Merchandising, Integer> getMerchAdmin() {
		return merchAdmin;
	}

	public int getNBiglietti() {
		int n = 0;

		for (Entry<BigliettoMuseo, Integer> entry : currentBiglietto.entrySet()) {
			n = entry.getValue();
		}

		return n;
	}

	/**
	 * @return {@link Posto} della sessione corrente.
	 */
	public int getPosto() {
		return scelte.get("Posto");
	}

	/**
	 * @return {@link Settore} della sessione corrente.
	 */
	public int getSettore() {
		return scelte.get("Settore");
	}

	/**
	 * @return {@link AbbType}.
	 */
	public AbbType getTipoAbb() {
		return this.getCurrentAbb().getTipoAbb();
	}

	/**
	 * Funzione che verifica nel database se l'utente specificato esiste
	 * controllandone anche la password.
	 *
	 * @param email Email dell'utente di cui si vuole eseguire il login.
	 * @param pass  Password dell'utente di cui si vuole eseguire il login.
	 * @throws WrongPasswordExceptio    Lanciata nel caso in cui la password sia
	 *                                  errata.
	 * @throws AccountNotFoundException Lanciata nel caso in cui l'account non
	 *                                  esista.
	 */
	public void login(String email, char[] pass) throws WrongPasswordException, AccountNotFoundException {
		Utente c = DAOFactory.createIUtenteDAO().selectByEmail(email);

		String strPass = new String(pass);
		if (c == null)
			throw new AccountNotFoundException(email);
		if (!c.getPassword().equals(strPass))
			throw new WrongPasswordException(email);
		if (c.getType() == Utente.Type.CLIENTE) {
			Cliente cli = (Cliente) c;
			cli.setAbb(DAOFactory.createIAbbonamentoDAO().selectAbbonamentoOfClient(cli));
			this.setCurrentUtente(c);
			this.setCurrentAbb(DAOFactory.createIAbbonamentoDAO().selectAbbonamentoOfUtente(c).getTipoAbb());
		} else {
			this.setCurrentUtente(c);
		}
	}

	/**
	 * Funzione che inserisce un nuovo cliente nel database ed esegue il login.
	 *
	 * @param c Cliente da registrare.
	 * @throws AccountAlreadyExistsException.
	 * @throws EmptyFieldException
	 * @throws WrongEmailFormatException.
	 */
	public void register(Cliente c)
			throws AccountAlreadyExistsException, EmptyFieldException, WrongEmailFormatException {
		// Controlla che il cliente sia valido
		c.checkValidity();
		// Inserisci in db
		if (!(DAOFactory.createIClienteDAO().insertCliente(c)
				&& DAOFactory.createIAbbonamentoDAO().insertAbbonamento(c)))
			throw new AccountAlreadyExistsException(c.getEmail());
		// Login
		this.setCurrentUtente(c);
		this.setCurrentAbb(DAOFactory.createIAbbonamentoDAO().selectAbbonamentoOfUtente(c).getTipoAbb());
	}

	/**
	 * Funzione che resetta il carrello {@link CarrelloController} a null.
	 */
	public void resetCarrello() {
		carrello.clear();
		carrello = null;
	}

	/**
	 * Funzione che resetta i campi sessione riguardanti {@link Anello},
	 * {@link Posto}, {@link Settore}, {@link Blocco}, {@link Partita},
	 * {@link Merchandising} a null.
	 */
	public void resetScelte() {
		scelte.clear();
		carrello = null;
		currentPartita = null;
		currentBiglietto = null;
	}

	/**
	 * Funzione che permette di impostare come {@link AbbType} corrente quello
	 * passato come parametro.
	 *
	 * @param abbToUpdate
	 */
	public void setAbbToUpdate(AbbType abbToUpdate) {
		this.abbToUpdate = abbToUpdate;
	}

	/**
	 * Funzione utilizzata per settare il {@link Anello}.
	 *
	 * @param anello
	 */
	public void setAnello(int anello) {
		scelte.put("Anello", anello);
	}

	/**
	 * Funzione utilizzata per settare il {@link Blocco}.
	 *
	 * @param blocco
	 */
	public void setBlocco(int blocco) {
		scelte.put("Blocco", blocco);
	}

	/**
	 * @param carrello HashMap di store items.
	 */
	public void setCarrello(HashMap<Merchandising, Integer> carrello) {
		this.carrello = carrello;
	}

	/**
	 * Funzione che permette di impostare come {@link AbbType} corrente quello
	 * passato come parametro.
	 *
	 * @param currentAbb Tipo di abbonamento corrente.
	 */
	public void setCurrentAbb(AbbType currentAbb) {
		this.getCurrentAbb().setTipoAbb(currentAbb);
	}

	public void setCurrentBiglietto(HashMap<BigliettoMuseo, Integer> currentBiglietto) {
		this.currentBiglietto = currentBiglietto;
	}

	/**
	 * Funzione che permette di impostare come {@link Pagamento} corrente quello
	 * passato come parametro.
	 *
	 * @param currentPagamento Pagamento corrente della sessione.
	 */
	public void setCurrentPagamento(int currentPagamento) {
		this.currentPagamento = currentPagamento;
	}

	/**
	 * Funzione che permette di impostare come {@link Partita} corrente quella
	 * passato come parametro.
	 *
	 * @param currentP Partita corrente della sessione.
	 */
	public void setCurrentPartita(Partita currentP) {
		currentPartita = currentP;
	}

	/**
	 * Funzione che permette di impostare come {@link Utente} corrente quello
	 * passato come parametro.
	 *
	 * @param currentU Utente corrente della sessione.
	 */
	public void setCurrentUtente(Utente currentU) {
		currentUtente = currentU;
	}

	/**
	 * @param m Un Pair di merchandising e integer, quest'ultimo è la quantità.
	 */
	public void setMerchAdmin(Pair<Merchandising, Integer> m) {
		merchAdmin = m;
	}

	/**
	 * Funzione utilizzata per settare il {@link Posto}.
	 *
	 * @param posto
	 */
	public void setPosto(int posto) {
		scelte.put("Posto", posto);
	}

	/**
	 * Funzione utilizzata per settare il {@link Settore}.
	 *
	 * @param settore
	 */
	public void setSettore(int settore) {
		scelte.put("Settore", settore);
	}
}
