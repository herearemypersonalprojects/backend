/**
 * 
 */
package com.idlookid.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;

/**
 * @author quocanh
 *
 */
public class EmailTools {
	private final static String PATTERN_EMAIL_VALIDE = "[\\w-\\.\\+]+@[\\w-\\.]+\\.[a-zA-Z]+";
	private final static Pattern PATTERN_DOMAINE = Pattern.compile("^.+@([\\w-\\.]+\\.[a-zA-Z]+)$");
	private final static Pattern PATTERN_USER = Pattern.compile("^([\\w-\\.\\+]+)@.+$");

	private EmailTools(){}
	
	/**
	 * Check email validation
	 *
	 * @param email
	 * @return
	 */
	public static boolean isValide(String email){
		if (StringUtils.isBlank(email)) {
			return false;
		}
		if (!email.matches(PATTERN_EMAIL_VALIDE)) {
			return false;
		}
		try {
			new InternetAddress(email, true);
		} catch (AddressException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Retourne le domaine de l'email
	 *
	 * @param email
	 * @return
	 */
	public static String extractDomain(String email) {
		if (isValide(email) == false) {
			return null;
		}
		Matcher matcher = PATTERN_DOMAINE.matcher(email);
		if (matcher.find() == false) {
			return null;
		}
		return matcher.group(1).toLowerCase();
	}

	/**
	 * Retourne l'utilisateur de l'email
	 *
	 * @param email
	 * @return
	 */
	public static String extractUser(String email) {
		if (isValide(email) == false) {
			return null;
		}
		Matcher matcher = PATTERN_USER.matcher(email);
		if (matcher.find() == false) {
			return null;
		}
		return matcher.group(1);
	}	
}
