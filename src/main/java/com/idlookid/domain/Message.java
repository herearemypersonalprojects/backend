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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@Column(name = "from_user") // user's id
	private Long fromUser;
	
	@Column(name = "to_user") // user's id
	private Long toUser;
	
	@Column(name = "content")
	private String content;

	@Column(name = "created_date")
	Date createdDate;
	/** PUBLIC METHODS */
	
	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}
	

	public Long getFromUser() {
		return fromUser;
	}


	public void setFromUser(Long fromUser) {
		this.fromUser = fromUser;
	}


	public Long getToUser() {
		return toUser;
	}


	public void setToUser(Long toUser) {
		this.toUser = toUser;
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
