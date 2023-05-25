package it.unipv.sfw.dao;

import it.unipv.sfw.dao.mysql.AbbonamentoDAO;
import it.unipv.sfw.dao.mysql.AdminDAO;
import it.unipv.sfw.dao.mysql.BigliettoMuseoDAO;
import it.unipv.sfw.dao.mysql.CimelioDAO;
import it.unipv.sfw.dao.mysql.ClienteDAO;
import it.unipv.sfw.dao.mysql.PartitaDAO;
import it.unipv.sfw.dao.mysql.PostoDAO;
import it.unipv.sfw.dao.mysql.RiconoscimentoDAO;
import it.unipv.sfw.dao.mysql.StoreItemDAO;
import it.unipv.sfw.dao.mysql.UtenteDAO;


/**
 * Classe che gestisce i DAO.
 * @author Federico Romano, Gabriele Invernizzi
 * @see it.unipv.sfw.dao.msyql
 */
public class DAOFactory {
	
	/**
	 * Enum che comprende i vari database a cui è possibile collegarsi.
	 */
	public enum DBType {
		MYSQL
	}

	private static DAOFactory instance = null;
	private DBType dbType;
	
	private DAOFactory(DBType dbType) {
		this.dbType = dbType;
	}
	
	/**
	 * Metodo che crea un'istanza della classe DAOFactory se non è già stata creata,
	 * altrimenti lancia una RuntimeException.
	 * @param dbType Parametro che specifica il database a cui collegarsi.
	 */
	public static void createInstance(DBType dbType) {
		if (instance != null)
			throw new RuntimeException("Instanza DAOFactory già creata.");
		instance = new DAOFactory(dbType);
	}
	
	/**
	 * Metodo che crea il DAO realitivo agli abbonamenti.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di AbbonamentoDAO.
	 */
	public static IAbbonamentoDAO createIAbbonamentoDAO() {
		switch (instance.dbType) {
			case MYSQL: return new AbbonamentoDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo agli admin.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di AdminDAO.
	 */
	public static IAdminDAO createIAdminDAO() {
		switch (instance.dbType) {
			case MYSQL: return new AdminDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo ai biglietti del museo.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di BigliettoMuseoDAO.
	 */
	public static IBigliettoMuseoDAO createIBigliettoMuseoDAO() {
		switch (instance.dbType) {
			case MYSQL: return new BigliettoMuseoDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo ai cimeli.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di CimelioDAO.
	 */
	public static ICimelioDAO createICimelioDAO() {
		switch (instance.dbType) {
			case MYSQL: return new CimelioDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo ai clienti.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di ClientiDAO.
	 */
	public static IClienteDAO createIClienteDAO() {
		switch (instance.dbType) {
			case MYSQL: return new ClienteDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo alle partite.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di PartitaDAO.
	 */
	public static IPartitaDAO createIPartitaDAO() {
		switch (instance.dbType) {
			case MYSQL: return new PartitaDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo ai posti.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di PostoDAO.
	 */
	public static IPostoDAO createIPostoDAO() {
		switch (instance.dbType) {
			case MYSQL: return new PostoDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo ai riconoscimenti.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di RiconoscimentoDAO.
	 */
	public static IRiconoscimentoDAO createIRiconoscimentoDAO() {
		switch (instance.dbType) {
			case MYSQL: return new RiconoscimentoDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo agli store items.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di StoreItemDAO.
	 */
	public static IStoreItemDAO createIStoreItemDAO() {
		switch (instance.dbType) {
			case MYSQL: return new StoreItemDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	/**
	 * Metodo che crea il DAO realitivo agli utenti.
	 * @throws Lancia una RuntimeException nel caso in cui l'istanza di DAOFactory non sia stata inizializzata.
	 * @return Un'istanza di UtenteDAO.
	 */
	public static IUtenteDAO createIUtenteDAO() {
		switch (instance.dbType) {
			case MYSQL: return new UtenteDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	
}
