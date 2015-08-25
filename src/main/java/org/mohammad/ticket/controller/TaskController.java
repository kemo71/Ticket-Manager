/**
 * 
 */
package org.mohammad.ticket.controller;

import java.security.Principal;

import org.mohammad.ticket.model.TaskModel;
import org.mohammad.ticket.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author kemo
 *
 */
@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@RequestMapping("/createTask")
	public String createTaskView(Model model)
	{
		logger.info("in createTaskview ");
		model.addAttribute(new TaskModel());
		return "createTask";
	}	
	
	@RequestMapping(value="/submitNewTask",method=RequestMethod.POST)
	public void submitNewTask(Model model, Principal principal,@ModelAttribute TaskModel taskModel, BindingResult bindingResult)
	{
		//taskService.sumbitTask(taskName, taskAssignee, taskDueDate, taskStatus);
		System.out.println("in submitNewTask");
		logger.info("date is : {}",taskModel.getdueDate());
		taskService.sumbitTask(taskModel, principal.getName());
	}
	
	@RequestMapping("/ViewTasks")
	public String viewTasksView()
	{
		return "viewTasks";
	}
	
	@RequestMapping("/ViewAssignedTasks")
	public String viewAssignedTasksView()
	{
		return "assignedTasks";
	}
	
	@RequestMapping("/ReportPage")
	public String reportPageView()
	{
		return "taskReport";
	}
}
