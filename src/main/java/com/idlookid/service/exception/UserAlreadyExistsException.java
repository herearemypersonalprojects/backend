package com.idlookid.service.exception;

/**
 * @author quocanh
 *
 */

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
