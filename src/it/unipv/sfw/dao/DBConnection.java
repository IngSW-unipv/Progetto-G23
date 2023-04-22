package it.unipv.sfw.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
	
	private static final String PROPERTYDBDRIVER = "DBDRIVER";
	private static final String PROPERTYDBURL = "DBURL";
	private static String dbDriver;
	private static String dbURL;
	private static DBConnection conn;
	private static boolean isInit = false;
	
	private static void init() {
		Properties p = new Properties(System.getProperties());
		try {
			p.load(new FileInputStream("properties/properties"));
			dbDriver =p.getProperty(PROPERTYDBDRIVER);
			dbURL =p.getProperty(PROPERTYDBURL);
			
			isInit = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Connection startConnection(Connection conn, String schema)
	{
		if (!isInit)
			init();
		
		System.out.println(dbURL);
		
		if (isOpen(conn))
			closeConnection(conn);
		try {
			dbURL=String.format(dbURL,schema); 
			System.out.println(dbURL);
			Class.forName(dbDriver);
			
			conn = DriverManager.getConnection(dbURL); //, username, password);// Apertura connessione
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static boolean isOpen(Connection conn) {
		return !(conn == null);
	}

	public static Connection closeConnection(Connection conn)
	{
		if (!isOpen(conn)) {
			return null;
		}
		
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}

