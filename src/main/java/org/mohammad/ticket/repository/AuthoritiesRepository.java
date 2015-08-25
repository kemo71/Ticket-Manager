package org.mohammad.ticket.repository;

import org.mohammad.ticket.orm.Authorities;
import org.mohammad.ticket.orm.AuthoritiesUserId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface AuthoritiesRepository extends PagingAndSortingRepository<Authorities, AuthoritiesUserId>{
	

}
