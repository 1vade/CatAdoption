package com.example.catadoption.data;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.data
 文件名:  MusicEntity
 创建者:  1vade
 创建时间:2022/6/29 19:02
 描述:    TODO
*/

public class MusicEntity {
    private String name;
    private String singer;
    private  final String filename;

    public MusicEntity(String filename,String name, String singer) {
        this.filename=filename;
        this.name = name;
        this.singer = singer;

    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }
    public String getFilename(){
        return filename;
    }
}
