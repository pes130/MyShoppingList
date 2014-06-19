package com.johnreddy.myshoppinglists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.johnreddy.myshoppinglists.adapters.NavDrawerListAdapter;
import com.johnreddy.myshoppinglists.bd.MyListsBD;
import com.johnreddy.myshoppinglists.model.NavDrawerItem;

/**
 * Main activity for the app.
 * 
 * @author Pablo
 * 
 */
public class MainActivity extends Activity {
	/** sliding menu layout. */
	private DrawerLayout mDrawerLayout;
	/** Menu list. */
	private ListView mDrawerList;
	/** Navigation menu titles. */
	private List<String> navMenuTitles;
	/** List with drawer items. */
	private List<NavDrawerItem> navDrawerItems;
	/** Array of icons. */
	private TypedArray navMenuIcons;
	/**
	 * Adapter for the drawer menu list. It will be used to paint each item of
	 * the lisst
	 */
	private NavDrawerListAdapter adapter;

	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MyListsBD bd = new MyListsBD(this);

		/* load slide menu items */
		navMenuTitles = Arrays.asList(getResources().getStringArray(
				R.array.nav_drawer_items));
		/* nav drawer icons from resources */
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);
		/* layout for activity containing the sliding menu */
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		/* Load menu items */
		navDrawerItems = new ArrayList<NavDrawerItem>();
		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles.get(0), navMenuIcons
				.getResourceId(0, -1)));
		// my lists
		navDrawerItems.add(new NavDrawerItem(navMenuTitles.get(1), navMenuIcons
				.getResourceId(1, -1), true, "3"));
		// recipes
		navDrawerItems.add(new NavDrawerItem(navMenuTitles.get(2), navMenuIcons
				.getResourceId(2, -1)));
		// abput
		navDrawerItems.add(new NavDrawerItem(navMenuTitles.get(3), navMenuIcons
				.getResourceId(3, -1)));
		// exit
		navDrawerItems.add(new NavDrawerItem(navMenuTitles.get(4), navMenuIcons
				.getResourceId(4, -1)));

		/* Recycle the typed array */
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		/* setting the nav drawer list adapter */
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name, // nav drawer open - description for
									// accessibility
				R.string.app_name // nav drawer close - description for
									// accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(R.string.app_name);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(R.string.app_name);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {

		switch (position) {
		// case 0:
		// fragment = new HomeFragment();
		// break;
		case 1:
			Intent intent = new Intent(this, MyLists.class);
			startActivity(intent);
			break;
		// case 2:
		// fragment = new PhotosFragment();
		// break;
		// case 3:
		// fragment = new CommunityFragment();
		// break;
		// case 4:
		// fragment = new PagesFragment();
		// break;
		// case 5:
		// fragment = new WhatsHotFragment();
		// break;
		//
		default:
			break;
		}

	}

	@Override
	public void setTitle(CharSequence title) {
		getActionBar().setTitle(title);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

}
