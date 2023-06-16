package it.unipv.sfw.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe che gestisce la connessione con il database.
 *
 * @author Gabriele Invernizzi
 */
public class DBConnection implements AutoCloseable {
	// Constants
	private static final String PROPERTYDBDRIVER = "DBDRIVER";
	private static final String PROPERTYDBURL = "DBURL";
	// Statics
	private static String dbDriver;
	private static String dbURL;
	private static boolean isInit = false;

	/**
	 * Funzione interna che viene chiamata solo la prima volta che viene creata una
	 * class DBConnection.
	 */
	private static void init() {
		Properties p = new Properties(System.getProperties());
		try {
			p.load(DBConnection.class.getClassLoader().getResourceAsStream("properties"));
			dbDriver = p.getProperty(PROPERTYDBDRIVER);
			dbURL = p.getProperty(PROPERTYDBURL);

			isInit = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection conn;

	/**
	 * Crea una nuova connessione al db.
	 *
	 * @param schema Stringa che rappresenta uno schema valido del database.
	 */
	public DBConnection(String schema) {
		if (!isInit)
			init();

		try {
			dbURL = String.format(dbURL, schema);

			// Apertura connessione
			conn = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		if (conn == null)
			return;

		conn.close();
		conn = null;
	}

	/**
	 * @return Connesione aparta al db.
	 */
	public Connection getConnection() {
		return conn;
	}

	/**
	 * @return Stato della connessione.
	 */
	public boolean isOpen() {
		return !(conn == null);
	}
}
