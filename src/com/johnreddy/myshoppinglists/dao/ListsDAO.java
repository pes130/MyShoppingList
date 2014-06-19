package com.johnreddy.myshoppinglists.dao;

import java.util.List;

import com.johnreddy.myshoppinglists.model.ItemList;

/**
 * @author Pablo
 * 
 */
public interface ListsDAO {
	/**
	 * Retrieve all the lists
	 * 
	 * @return all the lists
	 */
	List<ItemList> getAllLists();

	/**
	 * Get a list by id.
	 * 
	 * @param idList
	 *            id of the list to retrieve.
	 * @return requested list
	 */
	ItemList getList(String idList);

	/**
	 * Update a list
	 * 
	 * @param modified
	 *            modified list
	 */
	void updateList(ItemList modified);

	/**
	 * delete a list
	 * 
	 * @param listId
	 *            id of the list
	 */
	void deleteList(String listId);

	/**
	 * create a new list
	 * 
	 * @param newList
	 *            list to create.
	 */
	void createList(ItemList newList);
}
