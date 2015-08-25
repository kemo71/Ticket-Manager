package org.mohammad.ticket.util;

import org.mohammad.ticket.model.TaskModel;
import org.mohammad.ticket.orm.Task;
import org.mohammad.ticket.orm.Users;

public class TaskServiceUtil {
	public static Task toTask(TaskModel taskModel)
	{
		Task result = new Task();
		result.setTaskId(taskModel.getTaskId());
		result.setCreator(new Users(taskModel.getCreatorUsername()));
		result.setAssignee(new Users(taskModel.getAssigneeUsername()));
		result.setTaskName(taskModel.getTaskName());
		result.setDueDate(taskModel.getdueDate());
		result.setTaskStatus(taskModel.getTaskStatus());
		result.setDescription(taskModel.getDescription());
		return result;
	}

}
