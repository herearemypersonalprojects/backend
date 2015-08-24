package com.idlookid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.idlookid.domain.User;

/**
 * @author quocanh
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByEmail(@Param("email") String email);	
	List<User> findByLogin(@Param("login") String login);
}
