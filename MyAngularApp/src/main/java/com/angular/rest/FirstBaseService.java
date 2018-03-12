package com.angular.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.angular.cfc.UserInformation;
import com.myapp.MysqlRunner;

@Path("/BaseRequest")
public class FirstBaseService {
	final static Logger logger = Logger.getLogger(FirstBaseService.class);
	@Path("getName")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getUserName() {
		logger.info("Entered in FirstBaseService getUserName Method");
		try {
			UserInformation userInfoObject = null;
			List userInformationList = new ArrayList(10);
			MysqlRunner mysql = new MysqlRunner();
			logger.info("Exit in FirstBaseService getUserName Method");
			return mysql.getBookingList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
