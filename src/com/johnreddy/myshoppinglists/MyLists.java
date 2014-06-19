package com.johnreddy.myshoppinglists;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.johnreddy.myshoppinglists.bd.ListDAOBDImpl;
import com.johnreddy.myshoppinglists.dao.ListsDAO;
import com.johnreddy.myshoppinglists.model.ItemList;

public class MyLists extends FragmentActivity {
	private MyListsSelectorFragment fragmentLista;
	private Map<String, ItemList> selectedItems;
	ListsDAO listsDAO;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_lists);
		fragmentLista = (MyListsSelectorFragment) getSupportFragmentManager()
				.findFragmentById(R.id.my_lists_selector_fragment);
		this.setTitle(R.string.my_lists_activity);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		selectedItems = new HashMap<String, ItemList>();
		listsDAO = new ListDAOBDImpl(this);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lists, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	 // Respond to the action bar's Up/Home button
	    	case android.R.id.home:
	    		NavUtils.navigateUpFromSameTask(this);
	    		return true;
	    	case R.id.list_action_delete:
	    		deleteSelectedElements();
	    		return true;
	        
	    }

	   
	    return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Delete selected elements 
	 */
	public void deleteSelectedElements(){
		for(ItemList item:selectedItems.values()){
			listsDAO.deleteList(String.valueOf(item.getId()));
		}
		fragmentLista.refreshList();
	}
	
	public void selectElement(ItemList item){
		Log.i(MyLists.class.toString(), "Has marcado un elemento. Total=" + selectedItems.size());
		this.selectedItems.put(String.valueOf(item.getId()), item);
	}
	
	public void unselectElement(ItemList item){
		Log.i(MyLists.class.toString(), "Has desmarcado un elemento. Total=" + selectedItems.size());
		if(selectedItems.get(String.valueOf(item.getId()))!=null){
			this.selectedItems.remove(String.valueOf(item.getId()));
		}	
	}

}
