package com.example.catadoption.fragment;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.fragment
 文件名:  MusicFragment
 创建者:  1vade
 创建时间:2022/6/29 17:23
 描述:    TODO
*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.catadoption.R;
import com.example.catadoption.adapter.MusicAdapter;
import com.example.catadoption.data.MusicEntity;
import com.example.catadoption.databinding.FragmentMusicBinding;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {
    private FragmentMusicBinding binding = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, null);
        if (binding == null)
            binding = FragmentMusicBinding.bind(view);
        initView();
        return view;
    }

    private void initView() {
        final List<String> musicNames = new ArrayList<>();
        musicNames.add("music/薛之谦 - 演员.mp3");
        musicNames.add("music/薛之谦 - 绅士.mp3");
        musicNames.add("music/Linked Horizon - 紅蓮の弓矢.mp3");
        musicNames.add("music/群星 - 开心往前飞.mp3");
        musicNames.add("music/花澤香菜 - 恋愛サーキュレーション.mp3");
        musicNames.add("music/蔡翊昇 - 月上瓜洲.mp3");
        musicNames.add("music/鬼龍院翔 - LIFE IS SHOW TIME.mp3");
        final List<MusicEntity> musics = new ArrayList<>();
        for (String musicName : musicNames) {
            String[] split = musicName.split(" - ");
            if (split.length >= 2) {
                String singer = split[0];
                String name = split[1].split("\\.")[0];
                musics.add(new MusicEntity(musicName ,name, singer));
            }
        }
        binding.musicListView.setAdapter(new MusicAdapter(getContext(), musics));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
