package com.idlookid.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.idlookid.domain.User;
import com.idlookid.service.FileService;
import com.idlookid.service.UserService;
import com.idlookid.service.exception.UserAlreadyExistsException;

/**
 * @author quocanh
 *
 */

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final FileService fileService;

    @Autowired
    public UserController(final UserService userService, final FileService fileService) {
        this.userService = userService;
        this.fileService = fileService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@ModelAttribute @Valid final User user, @RequestParam("file") MultipartFile file) {
        LOGGER.debug("Received request to create the {}", user);
        fileService.saveFile(file);
        return userService.save(user);
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
