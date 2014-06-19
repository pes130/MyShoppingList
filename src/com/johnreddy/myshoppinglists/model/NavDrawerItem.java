package com.johnreddy.myshoppinglists.model;

import java.io.Serializable;

/**
 * Item for the drawer menu
 * 
 * @author Pablo
 * 
 */
public class NavDrawerItem implements Serializable{
	/** Serial version id. */
	private static final long serialVersionUID = 1L;
	/** item title. */
	private String title;
	/** Item icon. */
	private int icon;
	/** Item count. */
	private String count = "0";
	/** visiblity of the counter. */
	private boolean isCounterVisible = false;

	/**
	 * Default constructor.
	 */
	public NavDrawerItem() {
	}

	/**
	 * Cosntructor using fields
	 * 
	 * @param title
	 *            item title
	 * @param icon
	 *            item icon
	 */
	public NavDrawerItem(String title, int icon) {
		this.title = title;
		this.icon = icon;
	}

	/**
	 * Constructor using fields
	 * 
	 * @param title
	 *            item title
	 * @param icon
	 *            item icon
	 * @param isCounterVisible
	 *            if counter is visible
	 * @param count
	 *            counter
	 */
	public NavDrawerItem(String title, int icon, boolean isCounterVisible,
			String count) {
		this.title = title;
		this.icon = icon;
		this.isCounterVisible = isCounterVisible;
		this.count = count;
	}

	/**
	 * Get the title
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Get the icon
	 * 
	 * @return icon ref
	 */
	public int getIcon() {
		return this.icon;
	}

	/**
	 * Get the counter
	 * 
	 * @return counter value
	 */
	public String getCount() {
		return this.count;
	}

	/**
	 * Set a new value for the title
	 * 
	 * @param title
	 *            new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Set a new value for the icon
	 * 
	 * @param icon
	 *            new icon value
	 */
	public void setIcon(int icon) {
		this.icon = icon;
	}

	/**
	 * Set a new value for the counter.
	 * 
	 * @param count
	 *            new value
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * Get the counter visibility
	 * 
	 * @return counter visibility
	 */
	public boolean isCounterVisible() {
		return isCounterVisible;
	}

	/**
	 * Set a new value for the counter visibility.
	 * 
	 * @param isCounterVisible
	 *            new value
	 */
	public void setCounterVisible(boolean isCounterVisible) {
		this.isCounterVisible = isCounterVisible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + icon;
		result = prime * result + (isCounterVisible ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NavDrawerItem other = (NavDrawerItem) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (icon != other.icon)
			return false;
		if (isCounterVisible != other.isCounterVisible)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NavDrawerItem [title=" + title + ", icon=" + icon + ", count="
				+ count + ", isCounterVisible=" + isCounterVisible + "]";
	}
	
	

}
