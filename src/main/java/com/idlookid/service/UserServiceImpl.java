package com.idlookid.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.idlookid.domain.DisplayCriterion;
import com.idlookid.domain.User;
import com.idlookid.repository.UserRepository;
import com.idlookid.service.exception.UserAlreadyExistsException;

/**
 * @author quocanh
 *
 */

@Service
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository repository;
    
    public static Map<Long, User> listOnlineUsers = new HashMap<Long, User>();

    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
        
        Timer timer = new Timer();
        timer.schedule(new CheckOnlineUsers(), 0, 5000);
    }

    @Override
    public Map<Long, User> getListOnlineUsers(DisplayCriterion criterion) {
    	// current user is active
    	listOnlineUsers.get(criterion.getCurrentUser()).setLastActiveTime(System.currentTimeMillis());
    	
    	// TODO check condition criterion 
    	return listOnlineUsers;
    }
    
    @Override
    public User getUserByEmail(String email) {
    	List<User> user = repository.findByEmail(email);
    	if (user != null && !user.isEmpty()) {
    		listOnlineUsers.put(user.get(0).getId(), user.get(0));
    		return user.get(0);
    	}
    	return null;
    }
    
    @Override
    public User getUserByLogin(String login) {
    	List<User> user = repository.findByLogin(login);
    	if (user != null) {
    		listOnlineUsers.put(user.get(0).getId(), user.get(0));
    		return user.get(0);
    	}
    	return null; 	
    }
    
    @Override
    @Transactional
    public User save(@NotNull @Valid final User user) {
        LOGGER.debug("Creating {}", user);
        
        List<User> lstUsers = repository.findByEmail(user.getEmail());
        if (lstUsers != null && !lstUsers.isEmpty()) {
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with email=%s", user.getEmail()));
        }
      
        return repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

}
