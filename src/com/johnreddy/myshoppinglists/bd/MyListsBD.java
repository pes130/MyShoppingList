package com.johnreddy.myshoppinglists.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class to mass bd load operations
 * 
 * @author Pablo
 * 
 */
public class MyListsBD extends SQLiteOpenHelper {
	public static String ID_COLUMN = "_id";

	public static String ITEMS_TABLE_NAME = "items";

	public static String LISTS_TABLE_NAME = "lists";

	public static String RECIPES_TABLE_NAME = "recipes";

	public static String RECIPE_STEPS_TABLE_NAME = "recipe_steps";

	public static String RECIPE_INGREDIENTS_TABLE_NAME = "recipe_ingredients";

	public static String LIST_NAME_COLUMN = "name";

	public static String LIST_DESCRIPTION_COLUMN = "description";

	public static String LIST_CREATION_DATE_COLUMN = "creation_date";

	public static String LIST_UPDATED_DATE_COLUMN = "update_date";

	/* ITEMS TABLE */

	public static String ITEM_NAME_COLUMN = "name";

	public static String ITEM_DESCRIPTION_COLUMN = "description";

	public static String ITEM_LIST_ID_COLUMN = "list_id";

	public static String ITEM_QUANTITY_COUNTABLE_COLUMN = "units";

	public static String ITEM_QUANTITY_UNCOUNTABLE_COLUMN = "quantity";

	public static String ITEM_CREATION_DATE_COLUMN = "creation_date";

	public static String ITEM_UPDATED_DATE_COLUMN = "update_date";

	public static String ITEM_COUNTABLE_COLUMN = "countable";

	public static String ITEM_QUANTITY_COLUMN = "quantity";

	/* STEPS TABLE */
	public static String STEP_RECIPE_ID = "recipe_id";

	public static String STEP_RECIPE_DESCRIPTION = "description";

	/* RECIPES TABLE */
	public static String RECIPE_NAME_COLUMN = "name";

	public static String RECIPE_DESCRIPTION_COLUMN = "description";

	public static String RECIPE_CREATOR_COLUMN = "creator";

	public static String RECIPE_CREATION_DATE_COLUMN = "creation_date";

	public static String RECIPE_UPDATED_DATE_COLUMN = "update_date";

	public static String RECIPE_LANGUAGE_COLUMN = "language";

	public static String RECIPE_INGREDIENTS_RECIPE_ID_COLUMNS = "recipe_id";

	public static String RECIPE_INGREDIENTS_LIST_ID_COLUMNS = "list_id";

	public final static String CREATE_LISTS_TABLE_SENTENCE = "CREATE TABLE "
			+ LISTS_TABLE_NAME + " (" + ID_COLUMN
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + LIST_NAME_COLUMN
			+ " TEXT, " + LIST_DESCRIPTION_COLUMN + " TEXT, "
			+ LIST_CREATION_DATE_COLUMN + " REAL,  " + LIST_UPDATED_DATE_COLUMN
			+ " REAL)";

	public final static String CREATE_ITEMS_TABLE_SENTENCE = "CREATE TABLE "
			+ ITEMS_TABLE_NAME + " (" + ID_COLUMN
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM_LIST_ID_COLUMN
			+ " INTEGER, " + ITEM_NAME_COLUMN + " TEXT, "
			+ ITEM_DESCRIPTION_COLUMN + " TEXT, " + ITEM_COUNTABLE_COLUMN
			+ " INTEGER, " + ITEM_QUANTITY_COLUMN + " STRING,  "
			+ ITEM_CREATION_DATE_COLUMN + " REAL,  " + ITEM_UPDATED_DATE_COLUMN
			+ " REAL, FOREIGN KEY (" + ITEM_LIST_ID_COLUMN + ") REFERENCES "
			+ LISTS_TABLE_NAME + " (" + ID_COLUMN + "));";

	public final static String CREATE_RECIPES_TABLE_SENTENCE = "CREATE TABLE "
			+ RECIPES_TABLE_NAME + " (" + ID_COLUMN
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + RECIPE_NAME_COLUMN
			+ " TEXT, " + RECIPE_DESCRIPTION_COLUMN + " TEXT, "
			+ RECIPE_CREATOR_COLUMN + " TEXT, " + RECIPE_LANGUAGE_COLUMN
			+ " TEXT, " + ITEM_COUNTABLE_COLUMN + " INTEGER, "
			+ RECIPE_CREATION_DATE_COLUMN + " REAL,  "
			+ RECIPE_UPDATED_DATE_COLUMN + " REAL)";

	public final static String CREATE_RECIPE_STEPS_TABLE_SENTENCE = "CREATE TABLE "
			+ RECIPE_STEPS_TABLE_NAME
			+ " ("
			+ ID_COLUMN
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ STEP_RECIPE_ID
			+ " INTEGER, "
			+ STEP_RECIPE_DESCRIPTION
			+ " TEXT, "
			+ " FOREIGN KEY ("
			+ STEP_RECIPE_ID
			+ ") REFERENCES "
			+ RECIPES_TABLE_NAME + " (" + ID_COLUMN + "))";

	public final static String CREATE_RECIPE_INGREDIENTS_TABLE_SENTENCE = "CREATE TABLE "
			+ RECIPE_INGREDIENTS_TABLE_NAME
			+ " ("
			+ RECIPE_INGREDIENTS_RECIPE_ID_COLUMNS
			+ " INTEGER, "
			+ RECIPE_INGREDIENTS_LIST_ID_COLUMNS
			+ " INTEGER, "
			+ " FOREIGN KEY ("
			+ RECIPE_INGREDIENTS_RECIPE_ID_COLUMNS
			+ ") REFERENCES "
			+ RECIPES_TABLE_NAME
			+ " ("
			+ ID_COLUMN
			+ ")"
			+ ", FOREIGN KEY ("
			+ RECIPE_INGREDIENTS_LIST_ID_COLUMNS
			+ ") REFERENCES " + LISTS_TABLE_NAME + " (" + ID_COLUMN + "))";

	/**
	 * Constructor.
	 * 
	 * @param context
	 */
	public MyListsBD(Context context) {
		super(context, "MyShoppingListDB", null, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite
	 * .SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL(CREATE_LISTS_TABLE_SENTENCE);

		bd.execSQL(CREATE_ITEMS_TABLE_SENTENCE);

		bd.execSQL(CREATE_RECIPES_TABLE_SENTENCE);

		bd.execSQL(CREATE_RECIPE_STEPS_TABLE_SENTENCE);

		bd.execSQL(CREATE_RECIPE_INGREDIENTS_TABLE_SENTENCE);

		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 1', 'Lista de prueba', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 2', 'Lista de prueba 2', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 3', 'Lista de prueba 3', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 4', 'Lista de prueba 4', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 5', 'Lista de prueba 5', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 6', 'Lista de prueba 6', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 7', 'Lista de prueba 7', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 8', 'Lista de prueba 8', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 9', 'Lista de prueba 9', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 10', 'Lista de prueba 10', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 11', 'Lista de prueba 11', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 12', 'Lista de prueba 12', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		
		bd.execSQL("INSERT INTO lists VALUES (null, 'lista 13', 'Lista de prueba 13', "
				+ System.currentTimeMillis()
				+ ", "
				+ System.currentTimeMillis() + ");");
		
		bd.execSQL("INSERT INTO items VALUES (null, 1, 'Cerveza', 'La cala', 1 , '120', "+System.currentTimeMillis()+", "+System.currentTimeMillis()+");");
		bd.execSQL("INSERT INTO items VALUES (null, 1, 'Sardinas', '', 0 , '1 Kg', "+System.currentTimeMillis()+", "+System.currentTimeMillis()+");");
		bd.execSQL("INSERT INTO items VALUES (null, 1, 'Colacao', 'Mercadona', 1 , '1', "+System.currentTimeMillis()+", "+System.currentTimeMillis()+");");
		
//		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite
	 * .SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}

	public void loadDummieData() {
		SQLiteDatabase bd = this.getWritableDatabase();
		bd.execSQL("INSERT INTO items VALUES (null, 1, 'Cerveza', 'La cala', 1 , '120', "+System.currentTimeMillis()+", "+System.currentTimeMillis()+");");
		bd.execSQL("INSERT INTO items VALUES (null, 1, 'Sardinas', '', 0 , '1 Kg', "+System.currentTimeMillis()+", "+System.currentTimeMillis()+");");
		bd.execSQL("INSERT INTO items VALUES (null, 1, 'Colacao', 'Mercadona', 1 , '1', "+System.currentTimeMillis()+", "+System.currentTimeMillis()+");");
		bd.close();
	}

}
