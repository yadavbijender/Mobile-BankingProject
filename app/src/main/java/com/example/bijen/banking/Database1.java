package com.example.bijen.banking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bijen on 7/31/2018.
 */

public class Database1 extends SQLiteOpenHelper {

    static final String Database_name = "student.db";
    static final String Table_name = "feedback";

    public Database1(Context context) {
        super(context, Table_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + Table_name + "(COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, FEEDBACK INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(sqLiteDatabase);

    }

    public boolean saveData(String name, float feedback) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("FEEDBACK", feedback);
        long res = sqLiteDatabase.insert(Table_name, null, contentValues);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + Table_name + " WHERE FEEDBACK >= 3";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor;
    }
}
