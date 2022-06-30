package com.example.catadoption.adapter;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.adapter
 文件名:  MusciAdapter
 创建者:  1vade
 创建时间:2022/6/29 18:02
 描述:    TODO
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catadoption.R;
import com.example.catadoption.data.MusicEntity;
import com.example.catadoption.util.CatSQLite;

import java.util.List;
import java.util.Set;

public class MusicAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<MusicEntity> mList;
    private final LayoutInflater inflater;
    private final CatSQLite catSQLite;
    private final boolean[] isCollect;
    private String filename;

    public MusicAdapter(Context context, List<MusicEntity> list) {
        this.mContext = context;
        this.mList = list;
        catSQLite = new CatSQLite(context);
        isCollect = new boolean[mList.size()];
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_music, null);
            viewHolder = new ViewHolder();
            viewHolder.collect = view.findViewById(R.id.iv_collect);
            viewHolder.singer = view.findViewById(R.id.tv_singer);
            viewHolder.name = view.findViewById(R.id.tv_name);
            viewHolder.id = view.findViewById(R.id.tv_id);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String imgUrl = mList.get(position).getFilename();
        final Set<String> collectUrls;
        if (filename != null) {
            collectUrls = catSQLite.queryCollectUrls(filename);
        } else {
            throw new IllegalStateException();
        }

        isCollect[position] = collectUrls.contains(imgUrl);

        viewHolder.id.setText(String.valueOf(position + 1));

        //viewHolder.singer.setText(String.valueOf());


        viewHolder.name.setText(mList.get(position).getName());
        viewHolder.singer.setText(mList.get(position).getSinger());
        return view;
    }

    public static class ViewHolder {
        ImageView collect;
        TextView singer;
        TextView name;
        TextView id;
    }

}
