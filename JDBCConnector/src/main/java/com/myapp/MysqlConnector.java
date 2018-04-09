package com.myapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Mysql JDBC connector Interface class. This class will create connection and closeconnection
 * @author Yuvaraj
 *
 */
public class MysqlConnector {

	private static final Logger logger = Logger.getLogger(MysqlConnector.class);
	private static Properties prop;
	private static final String DATABASE = "database";
	private static final String DB_USERNAME = "dbuser";
	private static final String DB_PASSWORD = "dbpassword";
	private static final String CLASS_NAME = "classname";
	private ResultSet rs = null;
	
	/**
	 * Load the DB Configuration property only once
	 */
	static {
		prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("D:\\workspace\\JDBCConnector\\src\\main\\resources\\dbconfig.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException in loading properties",e);
		} catch (IOException e) {
			logger.error("IOException in loading properties",e);
		}	
	}

	/**
	 * Method will create connection as per properties defined
	 * @return
	 */
	public static Connection makeConnection() {
		String dataBase = prop.getProperty(DATABASE);
		String dbUserName = prop.getProperty(DB_USERNAME);
		String dbPassword = prop.getProperty(DB_PASSWORD);
		String className = prop.getProperty(CLASS_NAME);

		try {
			Class.forName(className);
			return DriverManager.getConnection(dataBase, dbUserName, dbPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
/**
 * Method will close connection as per properties defined
 * @param connection
 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
