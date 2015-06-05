package com.cisco.acisizing.acisizing.rest.processor;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisco.acisizing.acisizing.domain.User;
import com.cisco.acisizing.acisizing.service.UserService;

@Component("appMigrationProcessor")
public class AppMigrationProcessor extends RestProcessor<String> {

	@Autowired
	private UserService userService;
	
	@Override
	protected void doProcess() {
		List<User> userList = null;
		try {
			userList = userService.findAllUsers();
			
			result = "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			result = "failure";
		}
		
		for(Iterator<User> it = userList.iterator(); it.hasNext();) {
			User user = it.next();
			
			user.setFirstname(user.getUsername());
			
			try {
				userService.updateUser(user);
				
				result = "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				result = "failure";
				break;
			}
		}
	}

}
