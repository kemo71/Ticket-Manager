package org.mohammad.ticket.repository;

import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mohammad.ticket.TicketingProjectApplication;
import org.mohammad.ticket.orm.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketingProjectApplication.class)
@WebAppConfiguration
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void testNoResults(){
		List<Users> users = (List<Users>) userRepo.findAll();
		assertThat(users, is(notNullValue()));
		assertThat(users, is(empty()));
	}
	
	@Test
	public void testfindPendingUsers(){
		List<Users> users = userRepo.findByUserStatus("pending");
		assertThat(users, is(notNullValue()));
		assertThat(users, hasSize(2));
	}
	
	@Test
	public void testAddUser()
	{	
		Users newUser=new Users();
		newUser.setUsername("mohammad");
		newUser.setUser_password("123456");
		newUser.setEmail("stc@stc.com.sa");
		newUser.setEnabled(true);
		newUser.setUser_status("activated");
		
		Users createdUser = userRepo.save(newUser);
		assertThat(createdUser, is(notNullValue()));
		assertThat(createdUser.getUsername(), is("mohammad"));
		assertThat(createdUser.getUser_status(), is("activated"));
		//System.err.println("user is equal: " + (newUser.equals(createdUser)));
		
		
				userRepo.delete(newUser);
		//TODO createdUser instead of newUser
			}

}
