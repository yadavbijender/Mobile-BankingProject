package com.example.bijen.banking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bijen on 7/27/2018.
 */

public class Sqlhelper extends SQLiteOpenHelper {
    static final String Database_name = "student.db";
    static final String Table_name = "Login";

    public Sqlhelper(Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + Table_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL_ID TEXT, USER_NAME TEXT, PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(sqLiteDatabase);

    }

    public boolean SaveData(String email, String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();
        contentValue.put("EMAIL_ID", email);
        contentValue.put("USER_NAME", username);
        contentValue.put("PASSWORD", password);
        long res = sqLiteDatabase.insert(Table_name, null, contentValue);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = " SELECT * FROM " + Table_name + " WHERE EMAIL_ID = '" + email + "' ";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor;
    }

    public void updateData(String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PASSWORD", password);
        sqLiteDatabase.update(Table_name, contentValues, " EMAIL_ID = '" + email + "' ", null);
    }
}

