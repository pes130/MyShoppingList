package com.johnreddy.myshoppinglists.adapters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.johnreddy.myshoppinglists.MyLists;
import com.johnreddy.myshoppinglists.R;
import com.johnreddy.myshoppinglists.bd.ListDAOBDImpl;
import com.johnreddy.myshoppinglists.dao.ListsDAO;
import com.johnreddy.myshoppinglists.model.ItemList;

public class MyListsAdapter extends BaseAdapter {
	private LayoutInflater inflador; // Crea Layouts a partir del XML
	private TextView nombre;
	private TextView lastUpdate;
	private ListsDAO listsDAO;
	private List<ItemList> lists;
	private CheckBox cBox;


	public MyListsAdapter(Context context) {
		inflador = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		listsDAO = new ListDAOBDImpl(context);
		lists = listsDAO.getAllLists();
		
		
		
	}

	/*
	 * 
	 */
	@Override
	public int getCount() {
		return this.lists.size();
	}

	/*
	 * 
	 */
	@Override
	public Object getItem(int posicion) {
		return this.lists.get(posicion);
	}

	@Override
	public long getItemId(int posicion) {
		return this.lists.get(posicion).getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View vistaReciclada, ViewGroup padre) {
		ItemList list = lists.get(position);
		if (vistaReciclada == null) {
			vistaReciclada = inflador.inflate(R.layout.list_element_list, null);
		}
		int elements = list.getList() != null ? list.getList().size() : 0;
		nombre = (TextView) vistaReciclada.findViewById(R.id.list_name);
		nombre.setText(list.getName() + " (" + elements + ")");
		lastUpdate = (TextView) vistaReciclada
				.findViewById(R.id.list_lastupdate);
		Calendar lastUpdateDate = Calendar.getInstance();
		lastUpdateDate.setTimeInMillis(list.getLastUpdate().longValue());
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		lastUpdate.setText(format.format(lastUpdateDate.getTime()));
		cBox = (CheckBox) vistaReciclada
				.findViewById(R.id.select_list_checkbox);
		/* This is to recover the position on checkbox onclick*/
		cBox.setTag(Integer.valueOf(position));
		cBox.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Integer pos;			
			    pos = (Integer) v.getTag();
				ItemList element = lists.get(pos);
				if (!cBox.isChecked()) {
					((MyLists) v.getContext()).selectElement(element);
				} else {
					((MyLists) v.getContext()).unselectElement(element);
				}
			}
		});

		return vistaReciclada;
	}
	
	
	
}
