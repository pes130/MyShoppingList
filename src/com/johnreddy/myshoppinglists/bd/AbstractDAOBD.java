package com.johnreddy.myshoppinglists.bd;

import java.text.SimpleDateFormat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Abstract class to implement bd dao.
 * 
 * @author Pablo
 * 
 */
public abstract class AbstractDAOBD {
	/** data base object. */
	private MyListsBD myListsBD;
	private static SimpleDateFormat iso8601Format;
	
	public AbstractDAOBD(Context context){
		myListsBD = new MyListsBD(context);
	}
	
	
	/**
	 * @return the iso8601Format
	 */
	public static SimpleDateFormat getIso8601Format() {
		if(iso8601Format==null){
			iso8601Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return iso8601Format;
	}

	public void inicializaBD(Context contexto) {
		myListsBD = new MyListsBD(contexto);
	}

	/**
	 * @return the myListsBD
	 */
	public MyListsBD getMyListsBD() {
		return myListsBD;
	}
	
	
	
	
}
