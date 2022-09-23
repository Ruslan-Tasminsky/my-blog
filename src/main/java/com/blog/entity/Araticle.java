/**
 * 
 */
package com.blog.entity;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

/**
 * @author Руся
 *
 */
public class Araticle extends AbstractEntity<Long> {

	private static final long serialVersionUID = -9048488340812728475L;

	private String title;

	private String url;

	private String logo;

	private String description;

	private String content;

	private int idCategort;

	private Timestamp created;

	private long views;

	private int comments;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the idCategort
	 */
	public int getIdCategort() {
		return idCategort;
	}

	/**
	 * @param idCategort the idCategort to set
	 */
	public void setIdCategort(int idCategort) {
		this.idCategort = idCategort;
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

	/**
	 * @return the views
	 */
	public long getViews() {
		return views;
	}

	/**
	 * @param views the views to set
	 */
	public void setViews(long views) {
		this.views = views;
	}

	/**
	 * @return the comments
	 */
	public int getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getArticleLink() {
		return "/article/" + getId() + this.url;
	}

	public String getShortTitle() {
		if (StringUtils.length(this.title) > 20) {
			return this.title.substring(0, 17) + "...";
		} else {
			return this.title;
		}
	}
}
