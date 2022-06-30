package com.example.catadoption.ui;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  Collect
 创建者:  1vade
 创建时间:2022/6/22 17:00
 描述:    TODO
*/

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catadoption.R;
import com.example.catadoption.adapter.PictureAdapter;
import com.example.catadoption.data.PictureEntity;
import com.example.catadoption.dialog.CustomDialog;
import com.example.catadoption.util.CatSQLite;
import com.example.catadoption.util.PicassoUtils;
import com.example.catadoption.util.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectActivity extends AppCompatActivity {
    private GridView mGrid;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_collect);
        mGrid = findViewById(R.id.mGrid);
        CatSQLite catSQLite = new CatSQLite(this);

        final Set<String> collectSet = catSQLite.queryCollectUrls(PreferenceUtil.getString(this, "CURRENT_USERNAME"));
        List<PictureEntity> catDataList = new ArrayList<>();
        for (String collect : collectSet) {
            catDataList.add(new PictureEntity(collect));
        }
        PictureAdapter catAdapter = new PictureAdapter(this, catDataList);
        catAdapter.setOnClickImageListener(imgUrl -> {
            CustomDialog customDialog = new CustomDialog(this, R.layout.dialog_picture, R.style.pop_anim_style);
            ImageView imageView = customDialog.findViewById(R.id.image);
            PicassoUtils.loadImageView(imgUrl, imageView);
            imageView.setOnClickListener(v -> {
                customDialog.cancel();
            });
            customDialog.show();
        });
        mGrid.setAdapter(catAdapter);

    }


}