package org.mohammad.ticket.util;

import java.util.ArrayList;
import java.util.List;

import org.mohammad.ticket.model.RegisterModel;
import org.mohammad.ticket.model.UserModel;
import org.mohammad.ticket.orm.Authorities;
import org.mohammad.ticket.orm.Users;

public class UserServiceUtil {
	public static Users toUsers(RegisterModel model){
		Users result =  new Users();
		result.setUsername(model.getUsername());
		result.setUser_password(model.getPassword());
		result.setEmail(model.getEmail());
		result.setEnabled(false);
		result.setUser_status("pending");
		
		return result;
	}
	
	public static List<UserModel> toUserModel(List<Users> users){
		List<UserModel> result =  new ArrayList<>();
		for(Users user: users)
			result.add(toUserModel(user));
		return result;
	}
	
	public static UserModel toUserModel(Users user){
		UserModel result =  new UserModel();
		result.setUsername(user.getUsername());
		result.setEmail(user.getEmail());
		result.setPassword(user.getUser_password());
		result.setEnabled(user.isEnabled());
		result.setUserStatus(user.getUser_status());
		result.setRoles(user.getAuthorities());
		return result;
	}
	
	public static Users toUsers(UserModel userModel){
		Users result =  new Users();
		result.setUsername(userModel.getUsername());
		result.setEmail(userModel.getEmail());
		result.setUser_password(userModel.getPassword());
		result.setEnabled(userModel.isEnabled());
		result.setUserStatus(userModel.getUserStatus());
		result.setAuthorities((List<Authorities>)userModel.getAuthorities());
		return result;
	}
	
	
}
