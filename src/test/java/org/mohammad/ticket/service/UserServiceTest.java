/**
 * 
 */
package org.mohammad.ticket.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mohammad.ticket.TicketingProjectApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author kemo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketingProjectApplication.class)
@WebAppConfiguration
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testApproveUsers(){
		List<String> usernames = new ArrayList<>(); 
		usernames.add("aaa");
		userService.approvePendingUsers(usernames);
	}
}
