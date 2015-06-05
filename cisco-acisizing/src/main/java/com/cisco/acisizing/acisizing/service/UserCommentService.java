/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cisco.acisizing.acisizing.service;

import java.util.List;

import com.cisco.acisizing.acisizing.domain.UserComment;


public interface UserCommentService {

	public void createUserComment(UserComment userComment) throws Exception;
	
	public void updateUserComment(UserComment userComment) throws Exception;
	
	public void deleteUserComment(UserComment userComment) throws Exception;
	
	public UserComment findUserCommentById(int id) throws Exception;
	
	public List<UserComment> findUserCommentsByUserId(int userId) throws Exception;
	
	public void deleteUserCommentById(int id) throws Exception;
	
	public void deleteUserCommentByUserId(int userId) throws Exception;
	
}
