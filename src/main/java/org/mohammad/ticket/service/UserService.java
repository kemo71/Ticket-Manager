package org.mohammad.ticket.service;

import java.util.List;
import org.mohammad.ticket.model.RegisterModel;
import org.mohammad.ticket.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
	
	public boolean isUsernameExists(String username);
	public void registerUser(RegisterModel model);
	public List<UserModel> getPendingUsers();
	public void approvePendingUsers(List<String> usernames);
}
