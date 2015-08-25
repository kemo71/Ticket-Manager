package org.mohammad.ticket;

import org.mohammad.ticket.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

public class TicketingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketingProjectApplication.class, args);
    }
}
