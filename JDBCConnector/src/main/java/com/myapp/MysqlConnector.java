package com.myapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.myapp.BookingInfo;

public class MysqlConnector {

	private Connection connection;
	private static Properties prop;
	private static final String DATABASE = "database";
	private static final String DB_USERNAME = "dbuser";
	private static final String DB_PASSWORD = "dbpassword";
	private static final String CLASS_NAME = "classname";
	private ResultSet rs = null;

	public static void loadPropertyFile() {
		prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("D:\\workspace\\JDBCConnector\\src\\main\\resources\\dbconfig.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void makeConnection() {
		String dataBase = prop.getProperty(DATABASE);
		String dbUserName = prop.getProperty(DB_USERNAME);
		String dbPassword = prop.getProperty(DB_PASSWORD);
		String className = prop.getProperty(CLASS_NAME);

		try {
			Class.forName(className);
			connection = DriverManager.getConnection(dataBase, dbUserName, dbPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List  getList() throws SQLException {
		makeConnection();
		Statement stmt = connection.createStatement();
		List<BookingInfo> bookingInfoList = new ArrayList<BookingInfo>();
		BookingInfo bookingInfo = null;
		ResultSet rs = stmt.executeQuery("select * from BOOKING");
		while (rs.next()) {
			bookingInfo = new BookingInfo();
			bookingInfo.setBookingId(rs.getInt(1));
			bookingInfo.setOrigin(rs.getString(2));
			bookingInfo.setDestination(rs.getString(3));
			bookingInfo.setArrivalDate(rs.getDate(4));
			bookingInfoList.add(bookingInfo);
		}
		closeConnection();
		return bookingInfoList;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
