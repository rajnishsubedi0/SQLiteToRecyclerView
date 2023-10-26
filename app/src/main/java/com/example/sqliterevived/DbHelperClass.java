package com.example.sqliterevived;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelperClass extends SQLiteOpenHelper {
    private static final String TABLE_NAME="myTable";
    private static final String ID="id";
    private static final String NAME="myName";
    private static final String ADDRESS="myAddress";



    public DbHelperClass(Context context) {
        super(context, "jptname", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String myString="CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +NAME+" TEXT,"
                +ADDRESS+" TEXT)";
        sqLiteDatabase.execSQL(myString);

    }
    public void addData(String name, String address){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(ADDRESS,address);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public ArrayList<DataHolder> getDataFromDb(){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        ArrayList<DataHolder> cursorModerArrayLisst=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                cursorModerArrayLisst.add(new DataHolder(cursor.getString(1),
                                                        cursor.getString(2)
                ));

            }
            while (cursor.moveToNext());
        }

        cursor.close();
        return cursorModerArrayLisst;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
