package com.angular.rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.angular.cfc.UserInformation;
import com.myapp.MysqlRunner;

@Path("/BaseRequest")
public class FirstBaseService {

	@Path("getName")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getUserName() {
		try {
			UserInformation userInfoObject = null;
			List userInformationList = new ArrayList(10);
			MysqlRunner mysql = new MysqlRunner();
			return mysql.getBookingList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
