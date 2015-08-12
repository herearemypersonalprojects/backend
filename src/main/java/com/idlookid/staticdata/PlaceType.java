/**
 * 
 */
package com.idlookid.staticdata;

/**
 * @author quocanh
 *
 */
public enum PlaceType {
	RESTAURANT("Restaurant"),
	ADMINISTRATION("Administration");
	
	private final String label;
	
	private PlaceType(String label) {
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
}
