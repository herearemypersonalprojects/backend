/**
 * 
 */
package com.idlookid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quocanh
 *
 */
@RestController
public class AppController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String checkStatus() {
        LOGGER.debug("Check status: OK");
        return "OK";
    }
}
