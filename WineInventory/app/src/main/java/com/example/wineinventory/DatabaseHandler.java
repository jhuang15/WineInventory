package com.example.wineinventory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    private static final String DATABASE_NAME = "wine.db";

    //wine description table
    private static final String WINE_TABLE = "wine_table";

    private static final String COL_WINE_ID = "Wine_id";
    private static final String COL_NAME = "Name";
    private static final String COL_TYPE = "Type";
    private static final String COL_GRAPE = "Grape";
    private static final String COL_LOCATION = "Location";
    private static final String COL_NUMBER = "number"; //this is QUANTITY
    private static final String COL_PRICE = "Price";

    //inventory table
    private static final String INVENTORY_TABLE = "inventory_table";

    private static final String COL_INVENTORY = "inventory";

    //sales table
    private static final String SALES_TABLE = "sales_table";

    private static final String COL_INVOICE = "Invoice_Number";
    // private static final String COL_QUANTITY = "Quantity";
    private static final String COL_DATE = "Date";

    private static final String TAG = "WineDatabase";

    SQLiteDatabase database;

    @Override
    public void onCreate(SQLiteDatabase db) {

        String myquery = "CREATE TABLE IF NOT EXISTS " + WINE_TABLE + " ( " + COL_WINE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " VARCHAR, " + COL_TYPE + " VARCHAR, " + COL_GRAPE + " VARCHAR, " + COL_LOCATION + " VARCHAR, " + COL_NUMBER + " VARCHAR, " + COL_PRICE + " VARCHAR)";
        db.execSQL(myquery);
        //db.execSQL("CREATE TABLE "+ INVENTORY_TABLE +" ( "+COL_WINE_ID+" INTEGER, "+COL_INVENTORY+" INTEGER)");
        //db.execSQL("CREATE TABLE "+ SALES_TABLE +" ( "+COL_INVOICE+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_WINE_ID+" INTEGER, "+COL_NUMBER+" TEXT, "+COL_DATE+" DATE)");
        Log.d(TAG, "Table created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + WINE_TABLE);
        // db.execSQL("DROP TABLE IF EXISTS "+ INVENTORY_TABLE);
        // db.execSQL("DROP TABLE IF EXISTS "+ SALES_TABLE);
        //onCreate(db);
    }

    public void insertData(String Name, String Type, String Grape, String Location, String number, String Price) {
        database = this.getWritableDatabase();
        long result = -1;

        try {
            Log.d(TAG, "insertData begin");

            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_NAME, Name);
            contentValues.put(COL_TYPE, Type);
            contentValues.put(COL_GRAPE, Grape);
            contentValues.put(COL_LOCATION, Location);
            contentValues.put(COL_NUMBER, number);
            contentValues.put(COL_PRICE, Price);

            result = database.insert(WINE_TABLE, null, contentValues);

            database.close();
        } catch (SQLException e) {
            Log.e(TAG, "insert");
        } finally {
            Log.d(TAG, "insert with ID " + result);
        }

        Log.d(TAG, "insert data successful ");

        //contentValues.put(COL_INVENTORY,inventory);
        //database.insert(INVENTORY_TABLE,null,contentValues);

    }


    public Cursor getAllData() {
        database = getWritableDatabase();
        String query = "SELECT  * FROM " + WINE_TABLE;
        Cursor result = database.rawQuery(query, null);
        return result;
    }

    public Cursor search(String name) {
        database = getWritableDatabase();
        String query = "SELECT  * FROM " + WINE_TABLE + " where " + COL_NAME + " = ? ";
        Cursor result = database.rawQuery(query, new String[]{name});
        return result;
    }


    public void updateData(String wineId, String name, String type, String grape, String location, String number, String price, String inventory) {
        database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_WINE_ID, wineId);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_TYPE, type);
        contentValues.put(COL_GRAPE, grape);
        contentValues.put(COL_LOCATION, location);
        contentValues.put(COL_NUMBER, number);
        contentValues.put(COL_PRICE, price);
        database.update(WINE_TABLE, contentValues, "Wine_id = ?", new String[]{wineId});

        contentValues.put(COL_INVENTORY, inventory);
        database.update(INVENTORY_TABLE, contentValues, "Wine_id = ?", new String[]{wineId});
    }



    public Integer deleteData(String wineId) {
        database = getWritableDatabase();
        return database.delete(WINE_TABLE, "Wine_id = ?", new String[]{wineId});
    }


}
