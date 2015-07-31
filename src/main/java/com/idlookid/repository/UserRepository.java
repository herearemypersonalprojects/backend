package com.idlookid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idlookid.domain.User;

/**
 * @author quocanh
 *
 */

public interface UserRepository extends JpaRepository<User, String> {
}
