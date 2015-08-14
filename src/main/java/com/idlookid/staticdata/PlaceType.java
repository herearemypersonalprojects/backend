/**
 * 
 */
package com.idlookid.staticdata;

/**
 * @author quocanh
 *
 */
public enum PlaceType {
	RESTAURANT("Restaurant", "Quán ăn"),
	ADMINISTRATION("Administration", "Cơ quan"),
	COMPANY("Company", "Công ty"),
	ASSOCIATION("Association", "Hiệp hội"),
	HEALTH("Health", "Sức khỏe"),// Pharmacy & Doctor
	MARKET("Market", "Chợ thực phẩm"),
	BEAUTY("Beauty", "Chăm sóc sắc đẹp"),
	TOURISM("Tourism", "Du lịch"),
	HISTORY("History", "Di tích lịch sử"),
	RELIGION("Religion", "Ton giao"),
	EVENT("Event", "Sự kiện"),
	INDIVIDUAL("individual", "Cá nhân"); 
	
	private final String en;
	private final String vn;
	
	private PlaceType(String en, String vn) {
		this.en = en;
		this.vn = vn;
	}

	/**
	 * @return the label
	 */
	public String getEn() {
		return en;
	}
	
	public String getVn() {
		return vn;
	}
}
