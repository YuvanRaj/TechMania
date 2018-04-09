package com.myapp;

import java.io.Serializable;
import java.util.Date;

/**
 * Core Business Object which will explain the Business entity
 * @author Yuvaraj
 *
 */
public class TaskDetail implements Serializable {

	private static final long serialVersionUID = 6126003249836089318L;

	private Integer taskId;
	private String taskDescription;
	private Date taskDate;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

}
