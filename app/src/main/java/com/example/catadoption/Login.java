package com.example.catadoption;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  Login
 创建者:  1vade
 创建时间:2022/6/14 16:44
 描述:    TODO
*/

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.catadoption.util.PersonSQLiteHelper;

public class Login {
    private PersonSQLiteHelper helper;

    public Login(Context context) {
        helper = new PersonSQLiteHelper(context);
    }

    @SuppressLint("Range")
    public boolean login(String username, String password) {
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.query("user", null, "name=?", new String[]{username}, null, null, null, null);

        String dbPassword = null;

        if (cursor.moveToNext()) dbPassword = cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        database.close();
        return password.equals(dbPassword);


    }
}
