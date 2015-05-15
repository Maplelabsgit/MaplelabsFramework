package com.maplelabs.framework.guestbook.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maplelabs.framework.guestbook.response.User;
import com.maplelabs.framework.guestbook.rest.processor.UserCreationProcessor;
import com.maplelabs.framework.guestbook.rest.processor.UserLoginProcess;

@RestController
public class UserController {

	@Autowired
    private UserCreationProcessor userCreationProcessor;
	
	@Autowired
	private UserLoginProcess UserLoginProcess;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public User login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

User input = new User();
    	
    	input.setUsername(username);
    	input.setPassword(password);
    	UserLoginProcess.setModel(input);

		// session.setAttribute("user", username);

		return UserLoginProcess.execute();
	}
    
    @RequestMapping(value = "/User", method = RequestMethod.POST, produces = "application/json")
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password,
    						@RequestParam("emailAddress") String emailAddress, @RequestParam("address") String address) {
    	User user = null;
    	User input = new User();
    	
    	input.setUsername(username);
    	input.setPassword(password);
    	input.setEmailAddress(emailAddress);
    	input.setAddress(address);
    	
    	userCreationProcessor.setModel(input);
    	
    	user = userCreationProcessor.execute();
         
        return user;
    }

}  
