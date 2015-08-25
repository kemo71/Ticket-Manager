package org.mohammad.ticket.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mohammad.ticket.TicketingProjectApplication;
import org.mohammad.ticket.orm.Task;
import org.mohammad.ticket.orm.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketingProjectApplication.class)
@WebAppConfiguration
public class TaskRepositoryTest {

	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private UserRepository userRepo;
	/*org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
	
Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails (`ticket`.`task`, CONSTRAINT `task_ibfk_1` FOREIGN KEY (`creator`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE)
	*/
	private Users newUser;

	@Test
	public void testNoResults(){
		List<Task> tasks = (List<Task>) taskRepo.findAll();
		assertThat(tasks, is(notNullValue()));
		assertThat(tasks, is(empty()));
	}
	
/*	@Test
	public void testAddTask(){
		
		Task newTask=new Task();
		newTask.setTask_id(0L);
		newTask.setTask_name("Ticket Project");
		newTask.setTask_status("done");
		newTask.setDescription("this is a description");
		newTask.setCreator("mohammad");
		newTask.setAssignee("mohammad");
		newTask.setTask_date(new Date());
		Task savedNewTask = taskRepo.save(newTask);
		
		assertThat(savedNewTask , is(notNullValue()));
		assertThat(savedNewTask .getTask_name(), is("Ticket Project"));
		assertThat(savedNewTask .getTask_status(), is("done"));
	}*/
	//expected=DataIntegrityViolationException.class
	@Test()
	public void testAddTaskWithNoUser(){
		System.err.println("testAddTaskWithNoUser");
		Task newTask=new Task();
		
		
		newTask.setCreator(newUser);
		newTask.setAssignee(newUser);
		
		newTask.setTask_id(0L);
		newTask.setTask_name("Ticket Project");
		newTask.setTask_status("done");
		newTask.setDescription("this is a description");
		//newTask.setCreator("mohammad");
		//newTask.setAssignee("mohammad");
		newTask.setTask_date(new Date());
		
		Task savedNewTask = taskRepo.save(newTask);
		
		System.err.println(newUser.getUsername());
		assertThat(newUser.getUsername() , is("mohammad"));
		assertThat(savedNewTask , is(notNullValue()));
		assertThat(savedNewTask .getTask_name(), is("Ticket Project"));
		assertThat(savedNewTask .getTask_status(), is("done"));
	}
	
	@Test()
	public void testAddTaskWhithAutoIdIncreament(){
		System.err.println("testAddTaskWithNoUser");
		Task newTask=new Task();
		
		
		newTask.setCreator(newUser);
		newTask.setAssignee(newUser);
		
		//newTask.setTask_id(0L);
		newTask.setTask_name("Ticket Project");
		newTask.setTask_status("done");
		newTask.setDescription("this is a description");
		//newTask.setCreator("mohammad");
		//newTask.setAssignee("mohammad");
		newTask.setTask_date(new Date());
		
		Task savedNewTask = taskRepo.save(newTask);
		
		System.err.println(newUser.getUsername());
		assertThat(newUser.getUsername() , is("mohammad"));
		assertThat(savedNewTask , is(notNullValue()));
		assertThat(savedNewTask .getTask_name(), is("Ticket Project"));
		assertThat(savedNewTask .getTask_status(), is("done"));
	}
	
	@Before
	public void setUpAddTask()
	{
		System.err.println("setUpAddTask");
		newUser=new Users();
		newUser.setUsername("mohammad");
		newUser.setUser_password("123456");
		newUser.setEmail("stc@stc.com.sa");
		newUser.setEnabled(true);
		newUser.setUser_status("activated");
		userRepo.save(newUser);	
	}
}