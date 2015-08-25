/**
 * 
 */
package com.idlookid.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author quocanh
 *
 */
@Entity
@Table(name = "message")
public class Message {
	@Id
	@Column(name = "id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "from") // user's id
	private Long from;
	
	@Column(name = "to") // user's id
	private Long to;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "created_date")
	private Date createdDate;

	/** PUBLIC METHODS */
	
	/**
	 * @return the from
	 */
	public Long getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Long from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Long getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Long to) {
		this.to = to;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	

	
}
