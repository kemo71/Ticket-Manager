package org.mohammad.ticket.service;

import org.mohammad.ticket.model.RegisterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.google.common.base.Strings;


@Component
public class RegistrationValidator implements  Validator{
	private static final Logger logger = LoggerFactory.getLogger(RegistrationValidator.class);
	
	@Autowired
	private Validator validator;
	
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		logger.info("supports, isAssignable: {}", arg0.isAssignableFrom(RegisterModel.class));
		return arg0.isAssignableFrom(RegisterModel.class);
		
	}

	@Override
	public void validate(Object obj, Errors errors) {
		logger.info("validate");
		// TODO Auto-generated method stub
		//validator.validate(obj, errors);
		RegisterModel model = (RegisterModel) obj;
		validatePassword(model, errors);
		validateUsername(model, errors);
	}
	
	private void validatePassword(RegisterModel model, Errors errors){
		if(model != null 
				&& !Strings.isNullOrEmpty(model.getPassword())
				&& !Strings.isNullOrEmpty(model.getPasswordConformation())){
			
			if(!model.getPassword().equals(model.getPasswordConformation()))
				errors.rejectValue("password", "RegistrationValidator.password.notMatched");
			
			
		}
	}
	
	private void validateUsername(RegisterModel model, Errors errors){
		if(userService.isUsernameExists(model.getUsername()))
			errors.rejectValue("username", "RegistrationValidator.username.exists");
	}

}
