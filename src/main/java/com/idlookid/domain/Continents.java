/**
 * 
 */
package com.idlookid.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author quocanh
 *
 */
@Entity
@Table(name = "continents")
public class Continents {
	@Id
	@Column(name = "code",unique=true)	
	private String code;
	
	@Column(name = "name")
	private String name;
	
	/** PUBLIC METHODS */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
