/**
 * 
 */
package com.blog.entity;

import java.io.Serializable;
import com.blog.model.AbstractModel;

/**
 * @author Руся
 *
 */
public abstract class AbstractEntity<PK> extends AbstractModel implements Serializable {

	private static final long serialVersionUID = -1396230333144915600L;

	private PK id;

	/**
	 * @return the id
	 */
	public PK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PK id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean eqduals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		AbstractEntity<PK> other = (AbstractEntity<PK>) obj;
		if (this.id == null) {
			if (other.id != null) 
				return false;
		} else if (!this.id.equals(other.id)) 
			return false;
		return true;
	}
	
	
}
