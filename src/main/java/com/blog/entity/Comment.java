/**
 * 
 */
package com.blog.entity;

import java.sql.Timestamp;

/**
 * @author Руся
 *
 */
public class Comment extends AbstractEntity<Long> {

	private static final long serialVersionUID = -7196326995733110337L;

	private long idArticle;
	
	private Account account;
	
	private String content;
	
	private Timestamp created;

	/**
	 * 
	 */
	public Comment() {
		super();
	}

	/**
	 * @param idArticle
	 * @param account
	 * @param content
	 * @param created
	 */
	public Comment(long idArticle, Account account, String content, Timestamp created) {
		super();
		this.idArticle = idArticle;
		this.account = account;
		this.content = content;
		this.created = created;
	}

	/**
	 * @return the idArticle
	 */
	public long getIdArticle() {
		return idArticle;
	}

	/**
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
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
	
	
}
