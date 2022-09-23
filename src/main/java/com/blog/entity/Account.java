/**
 * 
 */
package com.blog.entity;

import java.sql.Timestamp;

/**
 * @author Руся
 *
 */
public class Account extends AbstractEntity<Long> {

	private static final long serialVersionUID = 5189464797464597877L;

	private String email;
	
	private String name;
	
	private String avatar;
	
	private Timestamp created;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return the created
	 */
	public Timestamp getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	public boolean isAvatarExists() {
		return this.avatar != null;
	}
	
	public String getNoAvatar() {
		return "/static/img/no_avatar.png";
	}
	
}
