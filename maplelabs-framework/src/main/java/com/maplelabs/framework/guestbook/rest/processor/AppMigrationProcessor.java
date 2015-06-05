package com.maplelabs.framework.guestbook.rest.processor;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.domain.User;
import com.maplelabs.framework.guestbook.service.UserService;

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
