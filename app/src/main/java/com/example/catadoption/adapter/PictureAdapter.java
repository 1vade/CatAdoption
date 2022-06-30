package com.example.catadoption.adapter;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  CatAdapter
 创建者:  1vade
 创建时间:2022/6/16 13:13
 描述:    TODO
*/

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.catadoption.R;
import com.example.catadoption.data.PictureEntity;
import com.example.catadoption.util.CatSQLite;
import com.example.catadoption.util.CollectSQLiteHelper;
import com.example.catadoption.util.PicassoUtils;
import com.example.catadoption.util.PreferenceUtil;

import java.util.List;
import java.util.Set;

public class PictureAdapter extends BaseAdapter {
    public static final String CURRENT_USERNAME = "CURRENT_USERNAME";
    private final Context mContext;
    private final List<PictureEntity> mList;
    private final LayoutInflater inflater;
    private OnClickImageListener mListener = null;
    private final boolean[] isCollect;
    private CollectSQLiteHelper collectSQLHelper;
    private final CatSQLite catSQLite;
    private String username;


    @SuppressLint("Range")
    public PictureAdapter(Context context, List<PictureEntity> lists) {
        this.mContext = context;
        this.mList = lists;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        isCollect = new boolean[mList.size()];
        catSQLite = new CatSQLite(context);
        init();
    }

    private void init() {
        username = PreferenceUtil.getString(mContext, CURRENT_USERNAME);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public PictureEntity getItem(int position) {
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
            view = inflater.inflate(R.layout.item_cat, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.img_cat);
            viewHolder.collect = view.findViewById(R.id.img_star);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String imgUrl = mList.get(position).getImgUrl();
        PicassoUtils.loadRoundImageViewSize(viewHolder.imageView, imgUrl, 160, 160, 6);
        final Set<String> collectUrls;
        if (username != null) {
            collectUrls = catSQLite.queryCollectUrls(username);
        } else {
            throw new IllegalStateException();
        }
        isCollect[position] = collectUrls.contains(imgUrl);

        viewHolder.imageView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onClick(imgUrl);
            }
        });

        viewHolder.collect.setImageResource(isCollect[position] ? android.R.drawable.btn_star_big_on : android.R.drawable.btn_star_big_off);
        viewHolder.collect.setOnClickListener(v -> {
            Log.i("CatAdapter",String.valueOf(position));
            if (isCollect[position]){
                catSQLite.deleteCollectUrl(username,imgUrl);
                isCollect[position]=false;
                viewHolder.collect.setImageResource(android.R.drawable.btn_star_big_off);
            }else{
                boolean code = catSQLite.insertCollectUrl(username, imgUrl);
                if (code){
                    isCollect[position]=true;
                    viewHolder.collect.setImageResource(android.R.drawable.btn_star_big_on);

                }
            }
        });
        return view;
    }

    public static class ViewHolder {
        ImageView imageView;
        ImageView collect;
    }

    public void setOnClickImageListener(OnClickImageListener listener) {
        mListener = listener;
    }


    public interface OnClickImageListener {
        void onClick(String imgUrl);
    }

}
