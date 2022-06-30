package com.example.catadoption.ui;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  Home
 创建者:  1vade
 创建时间:2022/6/8 15:42
 描述:    TODO
*/

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.catadoption.R;
import com.example.catadoption.fragment.MeFragment;
import com.example.catadoption.fragment.MusicFragment;
import com.example.catadoption.fragment.PictureFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mViewPager = findViewById(R.id.mViewPager);
        mTabLayout = findViewById(R.id.mTabLayout);

        mFragments.add(new PictureFragment());
        mFragments.add(new MusicFragment());
        mFragments.add(new MeFragment());
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("图 片");
        mTabLayout.getTabAt(1).setText("音 乐");
        mTabLayout.getTabAt(2).setText("我 的");

    }
}
