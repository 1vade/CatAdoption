package com.example.catadoption.util;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.util
 文件名:  MusicSQLiteHelper
 创建者:  1vade
 创建时间:2022/6/30 17:50
 描述:    TODO
*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MusicSQLiteHelper extends SQLiteOpenHelper {

    public MusicSQLiteHelper(Context context) {
        super(context,"collect.db",null,2 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table collect(id integer primary key autoincrement," +
                "username varchar(20),file varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

