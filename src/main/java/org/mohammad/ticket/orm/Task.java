package org.mohammad.ticket.orm;
import  java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Task {
	
	@Id @GeneratedValue()
	private Long taskId;
	private String taskName;
	private String taskStatus;
	private String description;
	private Date dueDate;
	//TODO map user object  // creator // assignee
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="creator",insertable=true,updatable=true)
	private Users creator;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="assignee",insertable=true,updatable=true)
	private Users assignee;
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
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Users getCreator() {
		return creator;
	}
	public void setCreator(Users creator) {
		this.creator = creator;
	}
	public Users getAssignee() {
		return assignee;
	}
	public void setAssignee(Users assignee) {
		this.assignee = assignee;
	}
}
