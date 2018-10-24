package com.example.bijen.banking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bijen on 7/29/2018.
 */

public class Database extends SQLiteOpenHelper {

    static final String Database_name = "student.db";
    static final String Table_name = "Account";

    public Database(Context context) {
        super(context, Table_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + Table_name + "(U_ID TEXT, USER_NAME TEXT, FATHER_NAME TEXT, DATE_OF_BIRTH TEXT, GENDER TEXT, PHONE_NO TEXT, EMAIL_ID TEXT, AADAR_CARD_NO TEXT, ADDRESS TEXT, STATE TEXT, COUNTRY TEXT, ACCOUNT_NO TEXT, UFSC_CODE TEXT, BRANCH_NAME TEXT, AMOUNT INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(sqLiteDatabase);

    }

    public boolean saveData(String uid, String name, String fname, String dob, String gender, String phone, String email, String aadar, String address, String state, String country, String account, String ufsc, String branch, int amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("U_ID", uid);
        contentValues.put("USER_NAME", name);
        contentValues.put("FATHER_NAME", fname);
        contentValues.put("DATE_OF_BIRTH", dob);
        contentValues.put("GENDER", gender);
        contentValues.put("PHONE_NO", phone);
        contentValues.put("EMAIL_ID", email);
        contentValues.put("AADAR_CARD_NO", aadar);
        contentValues.put("ADDRESS", address);
        contentValues.put("STATE", state);
        contentValues.put("COUNTRY", country);
        contentValues.put("ACCOUNT_NO", account);
        contentValues.put("UFSC_CODE", ufsc);
        contentValues.put("BRANCH_NAME", branch);
        contentValues.put("AMOUNT", amount);
        long res = sqLiteDatabase.insert(Table_name, null, contentValues);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteData(String uid) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(Table_name, " U_ID = '" + uid + "' ", null);
    }

    public Cursor getData(String uid) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String string = "SELECT * FROM " + Table_name + " WHERE U_ID = '" + uid + "' ";
        Cursor cursor = sqLiteDatabase.rawQuery(string, null);
        return cursor;
    }

    public void updateData(String uid, String name, String fname, String phone, String email, String address, String state) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USER_NAME", name);
        contentValues.put("FATHER_NAME", fname);
        contentValues.put("PHONE_NO", phone);
        contentValues.put("EMAIL_ID", email);
        contentValues.put("ADDRESS", address);
        contentValues.put("STATE", state);
        sqLiteDatabase.update(Table_name, contentValues, " U_ID = '" + uid + "' ", null);
    }

    public void update1(String uid, int amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("AMOUNT", amount);
        sqLiteDatabase.update(Table_name, contentValues, " U_ID = '" + uid + "' ", null);
    }

    public void update2(String account, int amount) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("AMOUNT", amount);
        sqLiteDatabase.update(Table_name, contentValues, " ACCOUNT_NO = '" + account + "' ", null);
    }

    public void update3(String account, String uid) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("U_ID", uid);
        sqLiteDatabase.update(Table_name, contentValues, " ACCOUNT_NO = '" + account + "' ", null);
    }

    public Cursor getData1(String account) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String string = "SELECT * FROM " + Table_name + " WHERE ACCOUNT_NO = '" + account + "' ";
        Cursor cursor = sqLiteDatabase.rawQuery(string, null);
        return cursor;
    }

}
