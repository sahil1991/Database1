package com.example.lenovo.database_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lenovo on 15-08-2016.
 */
public class Sqlite1 extends SQLiteOpenHelper {
public static final String Database_name="Products2";
    public static final String Table_name="smartphones2";
    public static final String col_1="ID";
    public static final String col_2="Product_name";


    public Sqlite1(Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ Table_name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Product_name TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Table_name);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String name){
     SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(col_2,name);
       long result=  sqLiteDatabase.insert(Table_name,null,contentvalues);
        if(result==-1)
            return false;
        else
            return true;

    }

}
