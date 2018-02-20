package com.myapp;

import java.sql.SQLException;
import java.util.List;

public class MysqlRunner {

	public List<BookingInfo> getBookingList() throws SQLException {
		MysqlConnector mysqlCon = new MysqlConnector();
		mysqlCon.loadPropertyFile();
		return mysqlCon.getList();
	}

}
