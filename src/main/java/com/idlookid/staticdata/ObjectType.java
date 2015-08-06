/**
 * 
 */
package com.idlookid.staticdata;

/**
 * @author quocanh
 *
 */
public enum ObjectType {
	PLACE ("place"),
	COMMENT ("comment"),
	USER ("user");
	
	private final String label;
	
	private ObjectType(String label) {
		this.label = label;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	
}
