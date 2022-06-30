package com.example.catadoption.util;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.util
 文件名:  Preference
 创建者:  1vade
 创建时间:2022/6/13 17:00
 描述:    偏好设置
*/

import android.content.Context;
import android.content.SharedPreferences;

public final class PreferenceUtil {
    private PreferenceUtil() {

    }

    private static final String NAME = "config";

    public static void setBoolean(Context context, String key, Boolean value) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, value).apply();
    }
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,defaultValue);
    }
    public static boolean getBoolean(Context context, String key) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    public static void setLong(Context context, String key, long value) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(key, value).apply();
    }
    public static long getLong(Context context, String key, long defaultValue) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key,defaultValue);
    }
    public static long getLong(Context context, String key) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key,0);
    }
    public static void setString(Context context, String key, String value) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).apply();
    }
    public static String getString(Context context, String key, String defaultValue) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,defaultValue);
    }
    public static String getString(Context context, String key) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,null);
    }



}
