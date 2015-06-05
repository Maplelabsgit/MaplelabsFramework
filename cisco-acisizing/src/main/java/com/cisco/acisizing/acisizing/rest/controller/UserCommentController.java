package com.cisco.acisizing.acisizing.rest.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.acisizing.acisizing.response.RestRequest;
import com.cisco.acisizing.acisizing.response.UserComment;
import com.cisco.acisizing.acisizing.rest.delegators.RestDelegator;

@RestController
public class UserCommentController {

	@Autowired
	private RestDelegator restDelegator;
	
    @RequestMapping(value = "/User/{userId}/Comment", method = RequestMethod.POST, produces = "application/json")
    public Response createComment(@PathVariable int userId, @RequestParam("comment") String comment) {
    	
    	UserComment input = new UserComment();
    	input.setUserId(userId);
    	input.setComment(comment);
    	
    	restDelegator.setRequest(new RestRequest<UserComment>(input));
    	restDelegator.setServiceType("UserCommentCreation");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }
    
    @RequestMapping(value = "/User/{userId}/Comment", method = RequestMethod.GET, produces = "application/json")
    public Response findCommentsByUserId(@PathVariable int userId) {
    	
    	restDelegator.setRequest(new RestRequest<Integer>(userId));
    	restDelegator.setServiceType("UserCommentFindByUserId");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }
    
    @RequestMapping(value = "/User/{userId}/Comment/{commentId}", method = RequestMethod.GET, produces = "application/json")
    public Response findCommentById(@PathVariable int commentId) {
    	
    	restDelegator.setRequest(new RestRequest<Integer>(commentId));
    	restDelegator.setServiceType("UserCommentFindById");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }
    
    @RequestMapping(value = "/User/{userId}/Comment", method = RequestMethod.DELETE, produces = "application/json")
    public Response deleteCommentsByUser(@PathVariable int userId) {
    	
    	restDelegator.setRequest(new RestRequest<Integer>(userId));
    	restDelegator.setServiceType("UserCommentDeletionByUserId");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }
    
    @RequestMapping(value = "/User/{userId}/Comment/{commentId}", method = RequestMethod.DELETE, produces = "application/json")
    public Response deleteComment(@PathVariable int commentId) {
    	
    	restDelegator.setRequest(new RestRequest<Integer>(commentId));
    	restDelegator.setServiceType("UserCommentDeletionById");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }
    
    @RequestMapping(value = "/User/{userId}/Comment/{commentId}", method = RequestMethod.POST, produces = "application/json")
    public Response updateComment(@PathVariable int userId, @PathVariable int commentId, @RequestParam("comment") String comment) {
    	
    	UserComment input = new UserComment();
    	input.setId(commentId);
    	input.setUserId(userId);
    	input.setComment(comment);

    	restDelegator.setRequest(new RestRequest<UserComment>(input));
    	restDelegator.setServiceType("UserCommentUpdation");
    	
    	try {
			restDelegator.executeService();
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return restDelegator.getResponse();
    }

}  
