package org.mohammad.ticket.service;

import org.mohammad.ticket.controller.TaskController;
import org.mohammad.ticket.model.TaskModel;
import org.mohammad.ticket.orm.Task;
import org.mohammad.ticket.repository.TaskRepository;
import org.mohammad.ticket.util.TaskServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{
	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public void sumbitTask(TaskModel taskModel,String creator){
		taskModel.setCreatorUsername(creator);
		taskModel.setTaskStatus("assigned");
		Task newTask = TaskServiceUtil.toTask(taskModel);
		logger.info("newTask, name: {}, assignee: {}", newTask.getTaskName(), newTask.getAssignee().getUsername());
		taskRepo.save(newTask);
	}
}
