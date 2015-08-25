/**
 * 
 */
package com.idlookid.staticdata;

/**
 * @author quocanh
 *
 */
public enum ErrorMessage {
	ERROR ("error: "),
	LOGIN_ERROR ("Login/email or password can not be found"),
	LOGIN_ERROR_EMAIL ("Email can not be found"),
	LOGIN_ERROR_LOGIN ("Login can not be found"),
	LOGIN_ERROR_PASSWORD ("Password is not correct");

	private final String label;
	
	private ErrorMessage(String label) {
		this.label = label;
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
}
