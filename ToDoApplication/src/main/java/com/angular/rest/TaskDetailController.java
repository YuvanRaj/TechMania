package com.angular.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.myapp.TaskDetail;
import com.myapp.TaskService;

/**
 * Controller used to retrieve the data from TASK_DETAILS table
 * @author Yuvaraj
 *
 */
@Path("/taskdetail")
public class TaskDetailController {
	private static final Logger logger = Logger.getLogger(TaskDetailController.class);

	
/**
 * Method used to retrieve the task details by status from task_details table
 * @param taskStatus
 * @return
 */
	@Path("getTaskDetailsByStatus/{taskStatus}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskDetail> getTaskDetailsByStatus(@PathParam(value = "taskStatus") String taskStatus) {
		logger.info("Entered in TaskDetailController-> getTaskDetailsByStatus Method");
		try {
			TaskService taskService = new TaskService();
			return taskService.getTaskDetails(taskStatus);
		} catch (Exception e) {
			logger.error("Exception in TaskDetailController-> getTaskDetailsByStatus", e);
		}
		return null;
	}

	/**
	 * Method used to insert the task detail into task_details table
	 * @param taskDetail
	 * @return
	 */
	@Path("addTaskDetail")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addTaskDetail(TaskDetail taskDetail) {
		logger.info("Entered in TaskDetailController-> addTaskDetail Method");
		try {
			TaskService taskService = new TaskService();
			int count = taskService.insertTaskDetail(taskDetail);
			String response = count > 0 ? "SUCCESS" : "FAILURE";
			logger.info("Exit in TaskDetailController-> addTaskDetail Method");
			return response;
		} catch (Exception e) {
			logger.error("Exception in TaskDetailController-> addTaskDetail", e);
		}
		return null;
	}

	/**
	 * Method used to remove the task detail based the selected row ids from UI
	 * @param taskDetailList
	 * @return
	 */
	@Path("removeTaskDetail")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String removeTaskDetail(List<TaskDetail> taskDetailList) {
		logger.info("Entered in TaskDetailController-> removeTaskDetail Method");
		try {
			TaskService taskService = new TaskService();
			int count = taskService.removeTask(taskDetailList);
			String response = count > 0 ? "SUCCESS" : "FAILURE";
			logger.info("Exit in TaskDetailController-> removeTaskDetail Method");
			return response;
		} catch (Exception e) {
			logger.error("Exception in TaskDetailController-> removeTaskDetail", e);
		}
		return null;
	}

}
