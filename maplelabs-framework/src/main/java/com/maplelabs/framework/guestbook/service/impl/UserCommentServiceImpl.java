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

package com.maplelabs.framework.guestbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.maplelabs.framework.guestbook.domain.UserComment;
import com.maplelabs.framework.guestbook.repository.UserCommentRepository;
import com.maplelabs.framework.guestbook.service.UserCommentService;

@Component("userCommentService")
@Transactional
public class UserCommentServiceImpl implements UserCommentService {

	private final UserCommentRepository userCommentRepository;

	@Autowired
	public UserCommentServiceImpl(UserCommentRepository userCommentRepository) {
		this.userCommentRepository = userCommentRepository;
	}

	@Override
	public void createUserComment(UserComment userComment) throws Exception {
		userCommentRepository.save(userComment);
	}

	@Override
	public void updateUserComment(UserComment userComment) throws Exception {
		userCommentRepository.save(userComment);
	}

	@Override
	public void deleteUserComment(UserComment userComment) throws Exception {
		userCommentRepository.delete(userComment);
	}

	@Override
	public UserComment findUserCommentById(int id) throws Exception {
		UserComment userComment = userCommentRepository.findOne(id);
		
		return userComment;
	}

	@Override
	public List<UserComment> findUserCommentsByUserId(int userId)
			throws Exception {

		List<UserComment> userCommentList = userCommentRepository.findUserCommentByUserId(userId);
		
		return userCommentList;
	}

	@Override
	public void deleteUserCommentById(int id) throws Exception {
		userCommentRepository.delete(id);
	}

	@Override
	public void deleteUserCommentByUserId(int userId) throws Exception {
		userCommentRepository.deleteUserCommentByUserId(userId);
	}

}
