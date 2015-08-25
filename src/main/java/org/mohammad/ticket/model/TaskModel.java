package org.mohammad.ticket.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TaskModel {
	
	
	private Long taskId;
	@NotEmpty
	private String taskName;
	private UserModel creator;
	private UserModel assignee;
	@NotEmpty
	private String creatorUsername;//in case we want to create a task
	@NotEmpty
	private String assigneeUsername;//in case we want to create a task
	private String description;
	@NotNull
	private Date dueDate;
	private String taskStatus;
	
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public UserModel getCreator() {
		return creator;
	}
	public void setCreator(UserModel creator) {
		this.creator = creator;
	}
	public UserModel getAssignee() {
		return assignee;
	}
	public void setAssignee(UserModel assignee) {
		this.assignee = assignee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getdueDate() {
		return dueDate;
	}
	public void setdueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getCreatorUsername() {
		return creatorUsername;
	}
	public void setCreatorUsername(String creatorUsername) {
		this.creatorUsername = creatorUsername;
	}
	public String getAssigneeUsername() {
		return assigneeUsername;
	}
	public void setAssigneeUsername(String assigneeUsername) {
		this.assigneeUsername = assigneeUsername;
	}
	
	
}
