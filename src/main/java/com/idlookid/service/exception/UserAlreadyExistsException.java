package com.idlookid.service.exception;

/**
 * @author quocanh
 *
 */

public class UserAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4578998855955470836L;

	public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
