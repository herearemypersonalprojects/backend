package com.idlookid.service;

import java.util.List;

import com.idlookid.domain.User;

/**
 * @author quocanh
 *
 */

public interface UserService {

    User save(User user);

    List<User> getList();

}
