package com.idlookid.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.idlookid.domain.DisplayCriterion;
import com.idlookid.domain.Login;
import com.idlookid.domain.User;
import com.idlookid.service.FileService;
import com.idlookid.service.UserService;
import com.idlookid.service.exception.UserAlreadyExistsException;
import com.idlookid.staticdata.ErrorMessage;
import com.idlookid.tools.EmailTools;

/**
 * @author quocanh
 *
 */

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    @Autowired
    public UserController(final UserService userService, final FileService fileService) {
        this.userService = userService;
    }

    /**
     * Add a new user and return information of this user.
     * Client has to save his user information in memory or in cookie
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public User createUser(@ModelAttribute User user, HttpServletRequest request) {
        LOGGER.debug("Received request to create the {}", user);
        user.setCreatedDate(Calendar.getInstance().getTime());
        user.setLastLoginDate(Calendar.getInstance().getTime());
        user.setLastActiveTime(System.currentTimeMillis());
        user.setFirstConnectedIp(request.getRemoteAddr());
        user.setLastConnectedIp(request.getRemoteAddr());
        return createUser(user);
    }
    
    public User createUser(@ModelAttribute User user) {
        return userService.save(user);
    }
    
    /**
     * Request to login.
     * 
     * @param user
     * @return user's id if it exists. Otherwise, an alert (email or login not found or password not correct)
     */
    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public Login signin(@ModelAttribute Login login, HttpServletRequest request) {
    	Login result = new Login();
    	if (StringUtils.isBlank(login.getLogin()) || StringUtils.isBlank(login.getPassword())) {
    		result.setError(ErrorMessage.LOGIN_ERROR_EMPTY);
    		return result;// ErrorMessage.ERROR.getLabel() + ErrorMessage.LOGIN_ERROR.getLabel();
    	}
    	User user = null;
    	if (EmailTools.isValide(login.getLogin())) {
    		 user = userService.getUserByEmail(login.getLogin());
    		if (user == null) {
    			result.setError(ErrorMessage.LOGIN_ERROR_EMAIL); // go to signup form 
    			return result;
    		} else {
    			if (!user.getPassword().equals(login.getPassword())) {
    				result.setError(ErrorMessage.LOGIN_ERROR_PASSWORD);
    				return result;
    			}
    		}
    	} else {
    		user = userService.getUserByLogin(login.getLogin());
    		if (user == null) {
    			result.setError(ErrorMessage.LOGIN_ERROR_LOGIN); // go to signup form 
    			return result;
    		} else {
    			if (!user.getPassword().equals(login.getPassword())) {
    				result.setError(ErrorMessage.LOGIN_ERROR_PASSWORD);
    				return result;
    			}
    		}
    	}
    	result.setId(user.getId());
    	return result;
    }
    
    /**
     * A client send request every 5s to inform that he is alive
     * and get other online users in his view only;
     * 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getListOnlineUsers")
    public Map<Long, User> getListOnlineUsers(@ModelAttribute @Valid final DisplayCriterion criterion) {
    	return userService.getListOnlineUsers(criterion);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listUsers() {
        LOGGER.debug("Received request to list all users");
        return userService.getList();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }

}
