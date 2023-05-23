package it.unipv.sfw.dao;

import it.unipv.sfw.dao.mysql.AbbonamentoDAO;
import it.unipv.sfw.dao.mysql.AdminDAO;
import it.unipv.sfw.dao.mysql.BigliettoMuseoDAO;
import it.unipv.sfw.dao.mysql.CimelioDAO;
import it.unipv.sfw.dao.mysql.ClienteDAO;

public class DAOFactory {
	public enum DBType {
		MYSQL
	}

	private static DAOFactory instance = null;
	private DBType dbType;
	
	private DAOFactory(DBType dbType) {
		this.dbType = dbType;
	}
	
	public static void createInstance(DBType dbType) {
		if (instance != null)
			throw new RuntimeException("Instanza DAOFactory già creata.");
		instance = new DAOFactory(dbType);
	}
	
	public static IAbbonamentoDAO createIAbbonamentoDAO() {
		switch (instance.dbType) {
			case MYSQL: return new AbbonamentoDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	public static IAdminDAO createIAdminDAO() {
		switch (instance.dbType) {
			case MYSQL: return new AdminDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	public static IBigliettoMuseoDAO createIBigliettoMuseoDAO() {
		switch (instance.dbType) {
			case MYSQL: return new BigliettoMuseoDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	public static ICimelioDAO createICimelioDAO() {
		switch (instance.dbType) {
			case MYSQL: return new CimelioDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
	
	public static IClienteDAO createIClienteDAO() {
		switch (instance.dbType) {
			case MYSQL: return new ClienteDAO();
		}
		throw new RuntimeException("Instanza DAOFactory non inizializzata.");
	}
}
