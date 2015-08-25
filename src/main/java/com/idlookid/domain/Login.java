/**
 * 
 */
package com.idlookid.domain;

import java.util.List;

import com.idlookid.tools.EmailTools;

/**
 * @author quocanh
 *
 */
public class Login {
	private String login;
	private String password;
	private String pageRedirect;
	private List<String> params;
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param pageRedirect the pageRedirect to set
	 */
	public void setPageRedirect(String pageRedirect) {
		this.pageRedirect = pageRedirect;
	}

	/**
	 * @return the pageRedirect
	 */
	public String getPageRedirect() {
		return pageRedirect;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(List<String> params) {
		this.params = params;
	}

	/**
	 * @return the params
	 */
	public List<String> getParams() {
		return params;
	}

	/**
	 * Indique si le login est de type email
	 *
	 * @return
	 */
	public boolean isLoginEmail() {
		return EmailTools.isValide(login);
	}
}
