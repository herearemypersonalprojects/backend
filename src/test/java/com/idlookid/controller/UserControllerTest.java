package com.idlookid.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.idlookid.controller.UserController;
import com.idlookid.domain.User;
import com.idlookid.service.FileService;
import com.idlookid.service.UserService;
import com.idlookid.util.UserUtil;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * @author quocanh
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock private UserService userService;
    @Mock private FileService fileService;

    private UserController userController;

    @Before
    public void setUp() throws Exception {
        userController = new UserController(userService, fileService);
    }

    @Test
    public void shouldCreateUser() throws Exception {
        final User savedUser = stubServiceToReturnStoredUser();
        final User user = UserUtil.createUser();
        User returnedUser = userController.createUser(user);
        // verify user was passed to UserService
        verify(userService, times(1)).save(user);
        assertEquals("Returned user should come from the service", savedUser, returnedUser);
    }

    private User stubServiceToReturnStoredUser() {
        final User user = UserUtil.createUser();
        when(userService.save(any(User.class))).thenReturn(user);
        return user;
    }


    @Test
    public void shouldListAllUsers() throws Exception {
        stubServiceToReturnExistingUsers(10);
        Collection<User> users = userController.listUsers();
        assertNotNull(users);
        assertEquals(10, users.size());
        // verify user was passed to UserService
        verify(userService, times(1)).getList();
    }

    private void stubServiceToReturnExistingUsers(int howMany) {
        when(userService.getList()).thenReturn(UserUtil.createUserList(howMany));
    }

}

/* 
 <!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"> 
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>      
    </head>
    <body>
        <style>
          .hide { position:absolute; top:-1px; left:-1px; width:1px; height:1px; }
        </style>

        <iframe name="hiddenFrame" class="hide"></iframe>

        <form id="newUserForm" action=" http://localhost:2011/user" method="post" >
            <input type="text" required id="password" name="password" size="30" title="Xin hay nhap ten dia diem">
            <span style="color:red; display:none"></span>
            <input id="submit" type="submit" value="Submit">            
        </form>
        
        <script>
            $('#newUserForm').submit(function(event) {                
                $( "span" ).text( "Not valid!" ).show().fadeOut( 2000 );
                event.preventDefault;
            });
   
        </script>
    </body>
</html>
 */
