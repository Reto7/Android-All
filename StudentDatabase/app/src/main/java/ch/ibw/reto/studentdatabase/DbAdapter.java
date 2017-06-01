package ch.ibw.reto.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by rk on 01.06.17.
 */

public class DbAdapter {

    public static final String PROG = "____DBAdapter";

    private static final String dbName = "studentDB";
    private static final String tblName = "student";

    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private int dbVersion;

    // constructor
    public DbAdapter(Context context) {
        this.context = context;
        dbVersion = 2;  // es reicht dies zu erhoehen, dann wird bereits onUpgrade aufgerufen !!!
        dbHelper = new DBHelper(context,dbName,null,dbVersion);
    }

    public void open(){
        db = dbHelper.getWritableDatabase();
    }


    // TODO hier crud methoden
    public void insertStudent(String studentName) {
        Log.w(PROG, "inserting: " + studentName);
        ContentValues record = new ContentValues();
        record.put("name", studentName);
        db.insert(tblName, null, record);
    }
    public void insertStudent(String studentName, Integer studentStudienrichtungId) {
        Log.w(PROG, "inserting: " + studentName +" mit Studienrichtung " + studentStudienrichtungId);
        ContentValues record = new ContentValues();
        record.put("name", studentName);
        record.put("studienrichtung_id", studentStudienrichtungId);
        db.insert(tblName, null, record);
    }
    //
    public ArrayList<Student> readAllStudents() {
        String[] columns = {"name","studienrichtung,id"};
        String selection = " 1=1 ";
        Cursor resultCursor = db.query(tblName, columns, selection, null, null, null, null);

        ArrayList<Student> returnArrayList = new ArrayList<Student>();
        resultCursor.moveToFirst();
        while (resultCursor.moveToNext()) {
            String studentName =   resultCursor.getString(0);
            //String studienrichtungId = resultCursor.getString(1);
            //Log.w(PROG, "reading: " + studentName +", hat Studienrichtung ID " + studienrichtungId);
            returnArrayList.add(new Student(studentName,Studienrichtung.Applikationsentwicklung));  // TODO
            //returnArrayList.add(c.getString(c.getColumnIndex(dbAdapter.KEY_NAME))); //add the item
        }
        resultCursor.close();
        return returnArrayList;
    }





    /**
     * ----------------------------------------
     * PRIVATE INNER CLASS (STATIC!)
     * ----------------------------------------
     */
    private static class DBHelper extends SQLiteOpenHelper{
        private static final String createQuery ="CREATE TABLE "
                +tblName
                +" ("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"name TEXT"
                +");"
                ;
        private static final String updateQuery ="ALTER TABLE "
                +tblName
                +" add studienrichtung_id INTEGER"
                +";"
                ;

        //constructor
        public DBHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int dbVersion) {
            super(context, dbName, factory,dbVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(PROG, "---on-create---");
            db.execSQL(createQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(PROG, "---on-upgrade---");
            db.execSQL(updateQuery);
        }
    }
}
