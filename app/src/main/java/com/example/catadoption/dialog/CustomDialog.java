package com.example.catadoption.dialog;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  CustomDialog
 创建者:  1vade
 创建时间:2022/6/16 15:54
 描述:    TODO
*/

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.catadoption.R;

public class CustomDialog extends Dialog {

    //定义模板
    public CustomDialog(Context context,int layout,int style){
        this(context, WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,layout,style, Gravity.CENTER);
    }
    //定义属性
    private CustomDialog(Context context, int width, int height,
                        int layout, int style, int gravity,int anim) {
        super(context,style);
        //设置属性
        setContentView(layout);
        Window window=getWindow();
        WindowManager.LayoutParams layoutParams=window.getAttributes();
        layoutParams.width=width;
        layoutParams.height=height;
        window.setAttributes(layoutParams);
        window.setWindowAnimations(anim);
    }
    private CustomDialog(Context context, int width, int height,
                        int layout, int style,int gravity){
        this(context,width,height,layout,style,gravity, R.style.pop_anim_style);

    }
}
