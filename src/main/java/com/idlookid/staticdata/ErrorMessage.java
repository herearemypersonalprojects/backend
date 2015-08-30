/**
 * 
 */
package com.idlookid.staticdata;

/**
 * @author quocanh
 *
 */
public enum ErrorMessage {
	ERROR ("ERROR", "error: "),
	LOGIN_ERROR_EMPTY ("LOGIN_ERROR_EMPTY", "Login/email or password can not be empty"),
	LOGIN_ERROR_EMAIL ("LOGIN_ERROR_EMAIL", "Email can not be found"),
	LOGIN_ERROR_LOGIN ("LOGIN_ERROR_LOGIN", "Login can not be found"),
	LOGIN_ERROR_PASSWORD ("LOGIN_ERROR_PASSWORD", "Password is not correct");

	private final String code;
	private final String label;
	
	private ErrorMessage(String code, String label) {
		this.code = code;
		this.label = label;
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	public String getCode() {
		return code;
	}
}
