package org.mohammad.ticket.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.mohammad.ticket.model.RegisterModel;
import org.mohammad.ticket.model.UserModel;
import org.mohammad.ticket.orm.Authorities;
import org.mohammad.ticket.orm.Users;
import org.mohammad.ticket.repository.AuthoritiesRepository;
import org.mohammad.ticket.repository.UserRepository;
import org.mohammad.ticket.util.UserServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthoritiesRepository AuthorityRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void registerUser(RegisterModel model) {	
		logger.info("in registerUser");
		
		Users newUser = UserServiceUtil.toUsers(model);
		List<Authorities> authorities = new ArrayList<>();
		Authorities userAuthority = new Authorities("ROLE_USER", newUser.getUsername());
		authorities.add(userAuthority);
		
		
		//newUser.setAuthorities(authorities);
		newUser.setUser_password(passwordEncoder.encode(newUser.getUser_password()));
		logger.info("in saving new user");
		
		userRepo.save(newUser);
		logger.info("in set  new user Authorities");
		AuthorityRepo.save(userAuthority);
		
	}

	@Override
	public boolean isUsernameExists(String username) {
		// TODO Auto-generated method stub
		return userRepo.exists(username);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findOne(username);
		user.getAuthorities();
		logger.info("in loaduserrname, is user null? {}", (user == null));
		if(user == null)
			throw new UsernameNotFoundException("username:"+username+ ",not found");
		UserModel userModel = UserServiceUtil.toUserModel(user);
		return userModel;
	}

	@Override
	public List<UserModel> getPendingUsers() {
		List<Users> pendingUsers = userRepo.findByUserStatus("pending");
		return UserServiceUtil.toUserModel(pendingUsers);
	}

	@Override
	public void approvePendingUsers(List<String> usernames) {
		List<Users> users = (List<Users>) userRepo.findAll(usernames);
		for(Users user : users){
			user.setUser_status("activated");
		}
		userRepo.save(users);
	}
}