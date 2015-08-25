/**
 * 
 */
package com.idlookid.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idlookid.domain.Message;

/**
 * @author quocanh
 *
 */
@RestController
public class MessageController {

    /**
     * An user sends a message to other user via their id
     * @param message
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sendMessage")
    public void sendMessage(@ModelAttribute @Valid final Message message) {
    	
    }
}
