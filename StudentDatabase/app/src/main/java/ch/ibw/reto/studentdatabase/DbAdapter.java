package ch.ibw.reto.studentdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rk on 01.06.17.
 */

public class DbAdapter {

    private static final String dbName = "studentDB";
    private static final String tblName = "student";

    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private int dbVersion;

    // constructor
    public DbAdapter(Context context) {
        this.context = context;
        dbVersion = 1;  // in datei !?
        dbHelper = new DBHelper(context,dbName,null,dbVersion);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }

    private class DBHelper extends SQLiteOpenHelper{
        //constructor

        public DBHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int dbVersion) {
            super(context, dbName, factory,dbVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
