package org.mohammad.ticket.repository;

import java.util.List;

import org.mohammad.ticket.orm.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.social.connect.UsersConnectionRepository;

public interface UserRepository extends PagingAndSortingRepository<Users, String>{
	public List<Users> findByUserStatus(String status);
}
