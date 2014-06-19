/**
 * 
 */
package com.johnreddy.myshoppinglists.bd;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.johnreddy.myshoppinglists.dao.ListsDAO;
import com.johnreddy.myshoppinglists.model.CountableItem;
import com.johnreddy.myshoppinglists.model.Item;
import com.johnreddy.myshoppinglists.model.ItemList;
import com.johnreddy.myshoppinglists.model.UncountableItem;

/**
 * @author Pablo
 *
 */
public class ListDAOBDImpl extends AbstractDAOBD implements ListsDAO {
	/** Get all query */
	public final static String GET_ALL_QUERY = "SELECT * FROM "+MyListsBD.LISTS_TABLE_NAME;
	
	public final static String GET_LIST_BY_ID_QUERY = "SELECT * FROM "+MyListsBD.LISTS_TABLE_NAME+" WHERE "+MyListsBD.ID_COLUMN+"=";
	
	public final static String DELETE_FROM_LISTS = "DELETE FROM "+MyListsBD.LISTS_TABLE_NAME+ " WHERE "+MyListsBD.ID_COLUMN+"=";
	public ListDAOBDImpl(Context context){
		super(context);
	}
	
	/* (non-Javadoc)
	 * @see com.johnreddy.myshoppinglists.dao.ListsDAO#getAllLists()
	 */
	@Override
	public List<ItemList> getAllLists() {
		SQLiteDatabase bd = getMyListsBD().getReadableDatabase();
		Cursor cursorLists = bd.rawQuery(GET_ALL_QUERY, null);
		List<ItemList> resultList = new ArrayList<ItemList>();
		while (cursorLists.moveToNext()) {		
			ItemList list = fetchListItemFromCursor(cursorLists, bd);
			resultList.add(list);			
		}
		cursorLists.close();
		bd.close();		
		return resultList;
	}

	/* (non-Javadoc)
	 * @see com.johnreddy.myshoppinglists.dao.ListsDAO#getList(java.lang.String)
	 */
	@Override
	public ItemList getList(String idList) {
		ItemList list = null;
		SQLiteDatabase bd = getMyListsBD().getReadableDatabase();
		Cursor cursor = bd.rawQuery(GET_LIST_BY_ID_QUERY+idList, null);
		if (cursor.moveToNext()) {
			list = this.fetchListItemFromCursor(cursor, bd);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.johnreddy.myshoppinglists.dao.ListsDAO#updateList(com.johnreddy.myshoppinglists.model.ItemList)
	 */
	@Override
	public void updateList(ItemList modified) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.johnreddy.myshoppinglists.dao.ListsDAO#deleteList(java.lang.String)
	 */
	@Override
	public void deleteList(String listId) {
		Log.e("-----ANTES> ",""+getAllLists().size());
		SQLiteDatabase bd = getMyListsBD().getReadableDatabase();
		
		
		
		bd.rawQuery(DELETE_FROM_LISTS+"'"+listId+"';", null);
		bd.close();
		Log.e("-----DESPUES> ",""+getAllLists().size());
		Log.e("->", DELETE_FROM_LISTS+"'"+listId+"';");
	}

	/* (non-Javadoc)
	 * @see com.johnreddy.myshoppinglists.dao.ListsDAO#createList(com.johnreddy.myshoppinglists.model.ItemList)
	 */
	@Override
	public void createList(ItemList newList) {
		// TODO Auto-generated method stub

	}
	
	private ItemList fetchListItemFromCursor(Cursor listItemCursor, SQLiteDatabase bd){
		ItemList list = new ItemList();
		list.setId(listItemCursor.getLong(listItemCursor.getColumnIndex(MyListsBD.ID_COLUMN)));
		list.setName(listItemCursor.getString(listItemCursor.getColumnIndex(MyListsBD.LIST_NAME_COLUMN)));
		list.setDescription(listItemCursor.getString(listItemCursor.getColumnIndex(MyListsBD.LIST_DESCRIPTION_COLUMN)));
		list.setCreationDate(listItemCursor.getDouble(listItemCursor.getColumnIndex(MyListsBD.LIST_CREATION_DATE_COLUMN)));
		list.setLastUpdate(listItemCursor.getDouble(listItemCursor.getColumnIndex(MyListsBD.LIST_UPDATED_DATE_COLUMN)));
		
		Cursor cursorItems = bd.rawQuery("SELECT * FROM "+MyListsBD.ITEMS_TABLE_NAME+" WHERE "+MyListsBD.ITEM_LIST_ID_COLUMN+" = "+ list.getId() , null);
		List<Item> items = new ArrayList<Item>();
		while (cursorItems.moveToNext()) {
			Item item = null;
			int countable = cursorItems.getInt(cursorItems.getColumnIndex(MyListsBD.ITEM_COUNTABLE_COLUMN));
			if(countable == 1){
				item = new CountableItem();
				item.setCountable(true);
				int quantity = cursorItems.getInt(cursorItems.getColumnIndex(MyListsBD.ITEM_QUANTITY_COLUMN));
				((CountableItem)item).setQuantity(quantity);
			}else {
				item = new UncountableItem();
				item.setCountable(false);
				String quantity = cursorItems.getString(cursorItems.getColumnIndex(MyListsBD.ITEM_QUANTITY_COLUMN));
				((UncountableItem)item).setQuantity(quantity);
			}
			item.setName(cursorItems.getString(cursorItems.getColumnIndex(MyListsBD.ITEM_NAME_COLUMN)));
			item.setDescription(cursorItems.getString(cursorItems.getColumnIndex(MyListsBD.ITEM_DESCRIPTION_COLUMN)));
			item.setId(cursorItems.getInt(cursorItems.getColumnIndex(MyListsBD.ID_COLUMN)));
			item.setCreationDate(cursorItems.getDouble(cursorItems.getColumnIndex(MyListsBD.ITEM_CREATION_DATE_COLUMN)));
			item.setLastUpdate(cursorItems.getDouble(cursorItems.getColumnIndex(MyListsBD.ITEM_UPDATED_DATE_COLUMN)));
			items.add(item);
		}
		list.setList(items);
		cursorItems.close();
		return list;
		
	}

}
