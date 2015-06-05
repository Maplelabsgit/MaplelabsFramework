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

package com.maplelabs.framework.guestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.maplelabs.framework.guestbook.domain.UserComment;

public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {
	
	@Query("select uc from UserComment uc where uc.tblUser = (select u from User u where u.username = ?1)")
	List<UserComment> findUserCommentByUserName(String username);
	
	@Query("select uc from UserComment uc where uc.tblUser = (select u from User u where u.id = ?1))")
	List<UserComment> findUserCommentByUserId(int userId);
	
	@Modifying
	@Transactional
	@Query("delete from UserComment uc where uc.tblUser = (select u from User u where u.id = ?1)")
	void deleteUserCommentByUserId(int userId);
	
}
