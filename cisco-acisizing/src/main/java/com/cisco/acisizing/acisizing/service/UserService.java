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

import com.cisco.acisizing.acisizing.domain.User;


public interface UserService {

	public void createUser(User user) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public void deleteUser(User user) throws Exception;

	public User findUserByName(String username) throws Exception;
	
	public User findUserById(int id) throws Exception;
	
	public void deleteUserById(int id) throws Exception;
	
	public List<User> findAllUsers() throws Exception;
	
}
