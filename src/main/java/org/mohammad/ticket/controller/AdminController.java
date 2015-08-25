package org.mohammad.ticket.controller;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

import org.mohammad.ticket.model.JsonViews;
import org.mohammad.ticket.model.UserModel;
import org.mohammad.ticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/approveUsers")
	public String viewApproveUsers(Model model){
		return "tables";
	}
	
	@RequestMapping("/getPendingUsers")
	@ResponseBody
	@JsonView(JsonViews.SummaryUserModel.class)
	public List<UserModel> getPendingUsers(){
		return userService.getPendingUsers();
	}
	
	@RequestMapping(value="/processUsers", method=RequestMethod.POST)
	@ResponseStatus(OK)
	public void approveUsers(Model model, @RequestParam(value="usernames[]", required=true) List<String> usernames){
		for(String u : usernames)
			System.err.println(u);
		userService.approvePendingUsers(usernames);
	}
	
	
	

}
