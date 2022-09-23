/**
 * 
 */
package com.blog.model;

import java.util.List;

/**
 * @author Руся
 *
 */
public class Items<T> extends AbstractModel {

	private List<T> items;
	
	private int count;

	/**
	 * @return the items
	 */
	public List<T> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<T> items) {
		this.items = items;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
