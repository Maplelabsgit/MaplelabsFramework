package com.maplelabs.framework.guestbook.rest.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maplelabs.framework.guestbook.response.RestRequest;
import com.maplelabs.framework.guestbook.response.UserComment;
import com.maplelabs.framework.guestbook.rest.delegators.RestDelegator;

@RestController
public class MigrationController {
	
	@Autowired
	private RestDelegator restDelegator;
	
    @RequestMapping(value = "/Migrate/DB", method = RequestMethod.PATCH, produces = "application/json")
    public Response migrateDB() {
    	
    	restDelegator.setServiceType("DBMigration");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }
    
    @RequestMapping(value = "/Migrate/APP", method = RequestMethod.PATCH, produces = "application/json")
    public Response migrateAPP() {
    	
    	restDelegator.setServiceType("APPMigration");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }
}
