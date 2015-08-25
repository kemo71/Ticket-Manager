package org.mohammad.ticket.orm;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TaskComments {
	@Id
	private int commetId;
	private String commentText;
	//TODO // username:change-to-commenter in MySQL // task id 
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="commenter",insertable=false,updatable=false)
	private Users commenter;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="task_id",insertable=false,updatable=false)
	private Task taskId;

	
	public int getCommet_id() {
		return commetId;
	}
	public void setCommet_id(int commet_id) {
		this.commetId = commet_id;
	}
	public String getComment_text() {
		return commentText;
	}
	public void setComment_text(String comment_text) {
		this.commentText = comment_text;
	}
}
