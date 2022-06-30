package com.example.catadoption.fragment;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  MeFragemnt
 创建者:  1vade
 创建时间:2022/6/14 17:26
 描述:    TODO
*/

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.catadoption.R;
import com.example.catadoption.ui.CollectActivity;

public class MeFragment extends Fragment {
    private Button btn_collect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);

        btn_collect = view.findViewById(R.id.btn_collect);
        btn_collect.setOnClickListener(v -> {
            if (v.getId() == R.id.btn_collect) {
                startActivity(new Intent(getContext(), CollectActivity.class));
            }
        });

        return view;
    }



}
