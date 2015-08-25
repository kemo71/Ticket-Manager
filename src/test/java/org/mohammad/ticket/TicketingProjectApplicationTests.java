package org.mohammad.ticket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mohammad.ticket.TicketingProjectApplication;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketingProjectApplication.class)
@WebAppConfiguration
public class TicketingProjectApplicationTests {

	@Test
	public void contextLoads() {
		
	}

}
