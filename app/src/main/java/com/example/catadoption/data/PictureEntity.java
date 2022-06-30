package com.example.catadoption.data;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.util
 文件名:  CatURL
 创建者:  1vade
 创建时间:2022/6/16 13:07
 描述:    实体类
*/

public class PictureEntity {
    private final String imgUrl;

    public PictureEntity(String imgUrl){
        this.imgUrl=imgUrl;
    }
    public String getImgUrl() {
        return imgUrl;
    }
}
