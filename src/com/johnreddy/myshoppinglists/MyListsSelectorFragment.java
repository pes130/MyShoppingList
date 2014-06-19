package com.johnreddy.myshoppinglists;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.johnreddy.myshoppinglists.adapters.MyListsAdapter;

public class MyListsSelectorFragment extends Fragment implements
		OnItemClickListener, OnItemLongClickListener {
	private BaseAdapter adaptador;

	@Override
	public View onCreateView(LayoutInflater inflador, ViewGroup contenedor,
			Bundle savedInstanceState) {
		View vista = inflador.inflate(R.layout.my_lists_fragment_selector,
				contenedor, false);
		return vista;
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		adaptador = new MyListsAdapter(getActivity());
		ListView listView = (ListView) getView().findViewById(R.id.myListsListView);
		listView.setAdapter(adaptador);
		listView.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		

	}
	
	public void refreshList(){
		adaptador.notifyDataSetChanged();
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
