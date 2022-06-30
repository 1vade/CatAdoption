package com.example.catadoption.util;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.util
 文件名:  CatSQLite
 创建者:  1vade
 创建时间:2022/6/23 16:29
 描述:    TODO
*/

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.ArraySet;

import java.util.Set;

public class CatSQLite{
    private final CollectSQLiteHelper helper;

    public CatSQLite(Context context) {
        this.helper=new CollectSQLiteHelper(context);
    }

    @SuppressLint("Range")
    public Set<String> queryCollectUrls(String username) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("collect", new String[]{"url"}, "username=?", new String[]{username}, null, null, null);
        final Set<String> urls = new ArraySet<>();
        while (cursor.moveToNext()) {
            urls.add(cursor.getString(cursor.getColumnIndex("url")));
        }
        cursor.close();
        db.close();
        return urls;
    }

    public boolean insertCollectUrl(String username, String url) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("url", url);
        long code = db.insert("collect", null, values);
        db.close();
        return code != -1;
    }
    public void deleteCollectUrl(String username,String url) {
        SQLiteDatabase db=helper.getWritableDatabase();
        db.delete("collect", "username=? and url=?", new String[]{username, url});
        db.close();
    }
}
