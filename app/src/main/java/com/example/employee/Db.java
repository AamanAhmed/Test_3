package com.example.employee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class Db extends SQLiteOpenHelper {
    String Databasename = "emp.db";
    public Db(@Nullable Context context) {super(context, "emp.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table empinfo(Id integer primary key autoincrement,Employee_Name text,Employee_Dept text,Employee_Salary Integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists empinfo");

    }
    public boolean insertrecord(String name,String dept,Integer salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datainserted = new ContentValues();
        datainserted.put("Employee_Name", name);
        datainserted.put("Employee_Dept", dept);
        datainserted.put("Employee_Salary", salary);
        long success = db.insert("empinfo", null, datainserted);
        if (success > 0) {
            return true;
        } else {
            return false;
        }

    }


    public ArrayList<HashMap<String,String>> fetchdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor find = db.rawQuery("select Employee_Name,Employee_Dept,Employee_Salary from empinfo",null);
        // Table
        ArrayList<HashMap<String,String>> records = new ArrayList<>();
        while (find.moveToNext()){
            // Column
            HashMap<String,String> column = new HashMap<>();
            column.put("Name",find.getString(0));
            column.put("Dept",find.getString(1));
            column.put("Salary",find.getString(2));
            records.add(column);
        }
        return records;

    }
}
