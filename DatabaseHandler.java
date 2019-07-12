package edu.csc4360.lta2.proj2test2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test.db";

    //wine description table
    private static final String WINE_TABLE = "wine_table";

    private static final String COL_WINE_ID = "Wine_id";
    private static final String COL_MODEL = "Model";
    private static final String COL_BRAND = "Brand";
    private static final String COL_YEAR = "Year";
    private static final String COL_COST = "Cost";

    //inventory table
    private static final String INVENTORY_TABLE = "inventory_table";

    private static final String COL_INVENTORY = "inventory";

    //sales table
    private static final String SALES_TABLE = "sales_table";

    private static final String COL_INVOICE = "Invoice_Number";
    private static final String COL_QUANTITY = "Quantity";
    private static final String COL_DATE = "Date";


    SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ WINE_TABLE +" ( "+COL_WINE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_MODEL+" TEXT, "+COL_BRAND+" TEXT, "+COL_YEAR+" INTEGER, "+COL_COST+" INTEGER)");
        db.execSQL("CREATE TABLE "+ INVENTORY_TABLE +" ( "+COL_WINE_ID+" INTEGER, "+COL_INVENTORY+" INTEGER)");
        db.execSQL("CREATE TABLE "+ SALES_TABLE +" ( "+COL_INVOICE+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_WINE_ID+" INTEGER, "+COL_QUANTITY+" INTEGER, "+COL_DATE+" DATE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ WINE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ INVENTORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ SALES_TABLE);
        onCreate(db);
    }
}
