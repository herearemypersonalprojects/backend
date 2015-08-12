/**
 * 
 */
package com.idlookid.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idlookid.domain.Country;
import com.idlookid.service.AppService;

/**
 * @author quocanh
 *
 */
@RestController
public class AppController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
    private final AppService appService;
    
    @Autowired
    public AppController(final AppService appService) {
        this.appService = appService;
    }	
	
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String checkStatus() {
        LOGGER.debug("Check status: OK");
        return "OK";
    }
    
    @RequestMapping(value = "/getListAllCountries", method = RequestMethod.GET)
    public List<Country> getListAllCountries() {
    	return appService.getListALlCountries(); 
    }
}
