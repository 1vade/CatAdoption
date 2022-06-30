package com.example.catadoption.util;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.util
 文件名:  MuscicUtil
 创建者:  1vade
 创建时间:2022/6/28 22:16
 描述:    TODO
*/

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MusicUtil {
    public static String parseFile(Context context, String file) {
        AssetManager assets = context.getAssets();
        try {
            InputStream inputStream = assets.open(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            bufferedReader.close();
            inputStream.close();
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
