/**
 * 
 */
package com.blog.entity;

/**
 * @author Руся
 *
 */
public class Category extends AbstractEntity<Integer> {

	private static final long serialVersionUID = 223485118681156773L;

	private String name;
	 
	private String url;
	 
	private int articles;

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
	 * @return the articles
	 */
	public int getArticles() {
		return articles;
	}

	/**
	 * @param articles the articles to set
	 */
	public void setArticles(int articles) {
		this.articles = articles;
	}
	
}
