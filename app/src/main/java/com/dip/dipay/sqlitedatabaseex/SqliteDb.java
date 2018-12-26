package com.dip.dipay.sqlitedatabaseex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class SqliteDb extends SQLiteOpenHelper {

    /*Step 3*/

    public static final int database_version=1;
    public static final String database_name="user_data.db";

    public static final String table_name="user";

    public static final String col_name="name";
    public static final String col_ph="phone";
    public static final String col_add="address";
    public static final String col_id="id";

    Context context;

    /*Step 3*/


    public SqliteDb(Context context) {
        super(context, database_name, null, database_version);

        this.context=context;
    } //Constructor matching super class of SqliteDatabase

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+table_name+" ("+col_id+" integer primary key autoincrement, "+
                col_name+" text, "+col_ph+" varchar, "+col_add+" varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table_name);
    }


    public void insert(DataModel dataModel){  /*Insert Data using model class step 4*/

        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(col_name,dataModel.getName());
        contentValues.put(col_ph,dataModel.getPh());
        contentValues.put(col_add,dataModel.getAdd());

        long a =database.insert(table_name,null,contentValues);

        database.close();

        Toast.makeText(context,""+a,Toast.LENGTH_SHORT).show();

    }

    /*Insert Data using model class step 4*/


    /*Fetch Data using model class step 8*/
    public ArrayList<DataModel> getAllUser() {
        ArrayList<DataModel> userList = new ArrayList<DataModel>();

        SQLiteDatabase db = getReadableDatabase();


        String query = "SELECT * FROM " + table_name;
        Cursor cursor = db.rawQuery(query, null);


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataModel model = new DataModel();
                model.setId(cursor.getInt(cursor.getColumnIndex(col_id)));
                model.setName(cursor.getString(cursor.getColumnIndex(col_name)));
                model.setAdd(cursor.getString(cursor.getColumnIndex(col_add)));
                model.setPh(cursor.getString(cursor.getColumnIndex(col_ph)));
                // Adding user record to list
                userList.add(model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /*Fetch Data using model class step 8*/

}
