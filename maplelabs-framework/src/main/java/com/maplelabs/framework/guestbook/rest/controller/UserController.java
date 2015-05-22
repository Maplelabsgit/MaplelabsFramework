package com.maplelabs.framework.guestbook.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maplelabs.framework.guestbook.response.RestRequest;
import com.maplelabs.framework.guestbook.response.User;
import com.maplelabs.framework.guestbook.rest.delegators.RestDelegator;

@RestController
public class UserController {

	@Autowired
	private RestDelegator restDelegator;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		List<String> input = new ArrayList<String>();
		input.add(username);
		input.add(password);
		input.add("DB");

		restDelegator.setRequest(new RestRequest<List<String>>(input));
		restDelegator.setServiceType("UserLogin");
		try {
			restDelegator.executeService();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restDelegator.getResponse();
	}

	@RequestMapping(value = "/User", method = RequestMethod.POST, produces = "application/json")
	public Response createUser(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("emailAddress") String emailAddress,
			@RequestParam("address") String address) {
		User user = null;
		User input = new User();

		input.setUsername(username);
		input.setPassword(password);
		input.setEmailAddress(emailAddress);
		input.setAddress(address);

		restDelegator.setRequest(new RestRequest<User>(input));
		restDelegator.setServiceType("UserCreation");
		try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restDelegator.getResponse();
	}

}
