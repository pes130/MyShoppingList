/**
 * 
 */
package com.johnreddy.myshoppinglists.model;

import java.io.Serializable;

/**
 * @author Pablo
 *
 */
public class CountableItem  extends Item implements Serializable{

	/** Serial version id. */
	private static final long serialVersionUID = 1L;
	/** Quantity */
	private int quantity;
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + quantity;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountableItem other = (CountableItem) obj;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountableItem [quantity=" + quantity + "]";
	}
	
	

}
