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

package com.cisco.acisizing.acisizing.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.acisizing.acisizing.domain.User;
import com.cisco.acisizing.acisizing.repository.UserRepository;
import com.cisco.acisizing.acisizing.service.UserService;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void createUser(User user) throws Exception {
		User u = userRepository.save(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) throws Exception {
		userRepository.delete(user);
	}

	@Override
	public User findUserByName(String username) throws Exception {
		User user = userRepository.findUserByName(username);
		
		return user;
	}

	@Override
	public User findUserById(int id) throws Exception {

		User user = userRepository.findOne(id);
		
		return user;
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		userRepository.delete(id);
	}

	@Override
	public List<User> findAllUsers() throws Exception {

		List<User> userList = userRepository.findAll();
		
		return userList;
	}
}
