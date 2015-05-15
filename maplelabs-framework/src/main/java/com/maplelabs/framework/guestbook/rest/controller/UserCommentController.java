package com.maplelabs.framework.guestbook.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maplelabs.framework.guestbook.response.UserComment;
import com.maplelabs.framework.guestbook.rest.processor.UserCommentCreationProcessor;
import com.maplelabs.framework.guestbook.rest.processor.UserCommentDeletionByIdProcessor;
import com.maplelabs.framework.guestbook.rest.processor.UserCommentDeletionByUserIdProcessor;
import com.maplelabs.framework.guestbook.rest.processor.UserCommentFindByIdProcessor;
import com.maplelabs.framework.guestbook.rest.processor.UserCommentFindByUserIdProcessor;
import com.maplelabs.framework.guestbook.rest.processor.UserCommentUpdationProcessor;

@RestController
public class UserCommentController {

	@Autowired
    private UserCommentCreationProcessor userCommentCreationProcessor;
	
	@Autowired
    private UserCommentFindByUserIdProcessor userCommentFindByUserIdProcessor;

	@Autowired
	private UserCommentFindByIdProcessor userCommentFindByIdProcessor;
	
	@Autowired
	private UserCommentDeletionByUserIdProcessor userCommentDeletionByUserIdProcessor;
	
	@Autowired
	private UserCommentDeletionByIdProcessor userCommentDeletionByIdProcessor;
	
	@Autowired
	private UserCommentUpdationProcessor userCommentUpdationProcessor;
	
    @RequestMapping(value = "/User/{userId}/Comment", method = RequestMethod.POST, produces = "application/json")
    public String createComment(@PathVariable int userId, @RequestParam("comment") String comment) {
    	
    	UserComment input = new UserComment();
    	input.setUserId(userId);
    	input.setComment(comment);
    	
    	userCommentCreationProcessor.setModel(input);
    	
    	String response = userCommentCreationProcessor.execute();
    	
        return response;
    }
    
    @RequestMapping(value = "/User/{userId}/Comment", method = RequestMethod.GET, produces = "application/json")
    public String findCommentsByUserId(@PathVariable int userId) {
    	
    	userCommentFindByUserIdProcessor.setUserId(userId);
    	
    	String response = userCommentFindByUserIdProcessor.execute();
         
        return response;
    }
    
    @RequestMapping(value = "/User/{userId}/Comment/{commentId}", method = RequestMethod.GET, produces = "application/json")
    public UserComment findCommentById(@PathVariable int commentId) {
    	
    	userCommentFindByIdProcessor.setId(commentId);
    	
    	UserComment userComment = userCommentFindByIdProcessor.execute();
         
        return userComment;
    }
    
    @RequestMapping(value = "/User/{userId}/Comment", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteCommentsByUser(@PathVariable int userId) {
    	
    	userCommentDeletionByUserIdProcessor.setUserId(userId);
    	
    	String response = userCommentDeletionByUserIdProcessor.execute();
         
        return response;
    }
    
    @RequestMapping(value = "/User/{userId}/Comment/{commentId}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteComment(@PathVariable int commentId) {
    	
    	userCommentDeletionByIdProcessor.setId(commentId);
    	
    	String response = userCommentDeletionByIdProcessor.execute();
         
        return response;
    }
    
    @RequestMapping(value = "/User/{userId}/Comment/{commentId}", method = RequestMethod.POST, produces = "application/json")
    public String updateComment(@PathVariable int userId, @PathVariable int commentId, @RequestParam("comment") String comment) {
    	
    	UserComment input = new UserComment();
    	input.setId(commentId);
    	input.setUserId(userId);
    	input.setComment(comment);

    	userCommentUpdationProcessor.setModel(input);
    	
    	String response = userCommentUpdationProcessor.execute();
         
        return response;
    }

}  
