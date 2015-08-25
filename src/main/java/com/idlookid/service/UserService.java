package com.idlookid.service;

import java.util.List;
import java.util.Map;

import com.idlookid.domain.DisplayCriterion;
import com.idlookid.domain.User;

/**
 * @author quocanh
 *
 */

public interface UserService {

    User save(User user);

    User getUserByEmail(String email);
    
    User getUserByLogin(String login);
    
    List<User> getList();
    
    Map<Long, User> getListOnlineUsers(DisplayCriterion criterion);

}
