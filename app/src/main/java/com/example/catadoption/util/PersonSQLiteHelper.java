package com.example.catadoption.util;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  PersonSQLiteHelper
 创建者:  1vade
 创建时间:2022/6/6 13:35
 描述:    TODO
*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonSQLiteHelper extends SQLiteOpenHelper {
    public PersonSQLiteHelper(Context context) {
        super(context,"user.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id integer primary key autoincrement," +
                "name varchar(20),password varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
