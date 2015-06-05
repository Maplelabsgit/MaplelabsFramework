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

package com.cisco.acisizing.acisizing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.acisizing.acisizing.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.username = ?1 order by u.id DESC)")
	User findUserByName(String username);

	/*@Query("select u, count(uc) cnt "
			+ "from User u inner join UserComment uc on u.id = uc.userId group by u order by cnt DESC")
	List<User> findCommentCounts();*/
}
