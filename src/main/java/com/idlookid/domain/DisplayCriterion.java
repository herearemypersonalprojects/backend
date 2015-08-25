/**
 * 
 */
package com.idlookid.domain;

/**
 * @author quocanh
 *
 */
public class DisplayCriterion {
	Long currentUser; // user's ID
	String city;
	String type;
	String community;
	Double swLat;
	Double swLng;
	Double neLat;
	Double neLng;
	
	/** PUBLIC METHODS */
	
	/**
	 * @return the currentUser
	 */
	public Long getCurrentUser() {
		return currentUser;
	}
	/**
	 * @param currentUser the currentUser to set
	 */
	public void setCurrentUser(Long currentUser) {
		this.currentUser = currentUser;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public Double getSwLat() {
		return swLat;
	}
	public void setSwLat(Double swLat) {
		this.swLat = swLat;
	}
	public Double getSwLng() {
		return swLng;
	}
	public void setSwLng(Double swLng) {
		this.swLng = swLng;
	}
	public Double getNeLat() {
		return neLat;
	}
	public void setNeLat(Double neLat) {
		this.neLat = neLat;
	}
	public Double getNeLng() {
		return neLng;
	}
	public void setNeLng(Double neLng) {
		this.neLng = neLng;
	}
	
	
}
