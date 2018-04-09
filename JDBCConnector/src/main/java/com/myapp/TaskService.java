package com.myapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class which will interact with DataBased and will get the value
 * @author Yuvaraj
 *
 */
public class TaskService {

	/**
	 * Method will retrieve the list of task details from task_details table
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<TaskDetail> getTaskDetails(String status) throws Exception {
		Connection con = null;
		try {
			con = MysqlConnector.makeConnection();
			Statement stmt = con.createStatement();
			List<TaskDetail> taskDetailList = new ArrayList<TaskDetail>();
			TaskDetail taskDetail = null;
			ResultSet rs = stmt.executeQuery("select * from TASK_DETAILS Where TASK_STATUS = '" + status + "'");
			while (rs.next()) {
				taskDetail = new TaskDetail();
				taskDetail.setTaskId(rs.getInt("TASK_ID"));
				taskDetail.setTaskDescription(rs.getString("TASK_DESC"));
				taskDetail.setTaskDate(rs.getDate("TASK_DATE"));
				taskDetailList.add(taskDetail);
			}

			return taskDetailList;

		} catch (SQLException ex) {
			throw new Exception("SQL Exception while executing getTaskDetails");
		} finally {
			if (con != null) {
				MysqlConnector.closeConnection(con);
			}
		}
	}

	/**
	 * Method will remove the task detail from task_details table
	 * @param taskDetailList
	 * @return
	 * @throws Exception
	 */
	public static int removeTask(List<TaskDetail> taskDetailList) throws Exception {
		if (taskDetailList == null || taskDetailList.isEmpty()) {
			return 0;
		}
		Connection con = null;
		try {
			con = MysqlConnector.makeConnection();
			Statement stmt = con.createStatement();

			String updateQuery = getUpdateQuery(taskDetailList);
			int count = stmt.executeUpdate(updateQuery);
			return count;

		} catch (SQLException ex) {
			throw new Exception("SQL Exception while executing getTaskDetails");
		} finally {
			if (con != null) {
				MysqlConnector.closeConnection(con);
			}
		}

	}

	/**
	 * Method will insert the task detail into task_details table
	 * @param taskDetail
	 * @return
	 * @throws Exception
	 */
	public static int insertTaskDetail(TaskDetail taskDetail) throws Exception {
		if (taskDetail == null) {
			return 0;
		}
		Connection con = null;
		try {
			con = MysqlConnector.makeConnection();
			Statement stmt = con.createStatement();

			String insertQuery = getInsertQuery(taskDetail);
			int count = stmt.executeUpdate(insertQuery);
			return count;

		} catch (SQLException ex) {
			throw new Exception("SQL Exception while executing getTaskDetails");
		} finally {
			if (con != null) {
				MysqlConnector.closeConnection(con);
			}
		}

	}

	/**
	 * Method will prepare insertQuery
	 * @param taskDetail
	 * @return
	 */
	private static String getInsertQuery(TaskDetail taskDetail) {
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO TASK_DETAILS VALUES (");
		builder.append("null");
		builder.append(",");
		builder.append("'" + taskDetail.getTaskDescription() + "'");
		builder.append(",");
		builder.append("now()");
		builder.append(",");
		builder.append("'PENDING')");
		return builder.toString();
	}

	/**
	 * Method will prepare update query
	 * @param taskDetailList
	 * @return
	 */
	private static String getUpdateQuery(List<TaskDetail> taskDetailList) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE TASK_DETAILS SET TASK_STATUS ='COMPLETED' WHERE TASK_ID IN (");
		for (int i = 0; i < taskDetailList.size(); i++) {
			builder.append(taskDetailList.get(i).getTaskId());
			if (i < taskDetailList.size() - 1) {
				builder.append(",");
			}
		}
		builder.append(")");
		return builder.toString();
	}

}
