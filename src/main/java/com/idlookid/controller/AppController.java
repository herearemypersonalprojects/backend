/**
 * 
 */
package com.idlookid.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idlookid.domain.Country;
import com.idlookid.domain.User;
import com.idlookid.service.AppService;
import com.idlookid.service.UserService;
import com.idlookid.staticdata.PlaceType;

/**
 * @author quocanh
 *
 */
@RestController
public class AppController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
    private final AppService appService;
    private final UserService userService;
    
    @Autowired
    public AppController(final AppService appService, final UserService userService) {
        this.appService = appService;
        this.userService = userService;
    }	
	
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String checkStatus() {
        LOGGER.debug("Check status: OK");
        return "OK";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User checkUser(HttpServletRequest request) {
    	return null;//userService.checkUser(request.getRemoteAddr()); TODO
    }
    
    
    @RequestMapping(value = "/getListAllCountries", method = RequestMethod.GET)
    public List<Country> getListAllCountries() {
    	return appService.getListALlCountries(); 
    }
    
    @RequestMapping(value = "/getListAllTypes", method = RequestMethod.GET) 
    public List<PlaceType> getListAllTypes() {
    	return appService.getListALlTypes();
    }
}
