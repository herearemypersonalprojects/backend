/**
 * 
 */
package com.idlookid.tools;

import java.util.HashMap;
import java.util.List;

/**
 * @author quocanh
 *
 */
public final class Geography {
	private static HashMap<String, List<String>> cities = null;
	
	public static List<String> getCities(String country) {
		if (cities == null) {
			cities = new HashMap<String, List<String>>();
			
		}
		
		return cities.get(country);
	}
}
