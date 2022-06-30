package com.example.catadoption.fragment;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  HomeFragment
 创建者:  1vade
 创建时间:2022/6/14 17:25
 描述:    TODO
*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.catadoption.BuildConfig;
import com.example.catadoption.R;
import com.example.catadoption.adapter.PictureAdapter;
import com.example.catadoption.data.PictureEntity;
import com.example.catadoption.dialog.CustomDialog;
import com.example.catadoption.util.PicassoUtils;

import java.util.ArrayList;
import java.util.List;

public class PictureFragment extends Fragment {
    //列表
    private GridView mGridView;
    //数据
    private final List<PictureEntity> mList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, null);

        findView(view);
        return view;
    }

    private void findView(View view) {

        String domainUrl = BuildConfig.DEBUG ? "http://10.0.2.2:8080/Test2/img/" : "http://192.168.3.32:8080/Test2/img/";
        mGridView = view.findViewById(R.id.mGridView);
//        mList.add(new CatData(domainUrl + "1.jpg"));
//        mList.add(new CatData(domainUrl + "2.jpg"));
//        mList.add(new CatData(domainUrl + "3.jpg"));
//        mList.add(new CatData(domainUrl + "4.jpg"));
//        mList.add(new CatData(domainUrl + "5.jpg"));
//        mList.add(new CatData(domainUrl + "6.jpg"));
//        mList.add(new CatData(domainUrl + "7.jpg"));
//        mList.add(new CatData(domainUrl + "8.jpg"));
//        mList.add(new CatData(domainUrl + "9.jpg"));
//        mList.add(new CatData(domainUrl + "10.jpg"));
//        mList.add(new CatData(domainUrl + "11.jpg"));
//        mList.add(new CatData(domainUrl + "12.jpg"));
//        mList.add(new CatData(domainUrl + "13.jpg"));
//        mList.add(new CatData(domainUrl + "14.jpg"));
//        mList.add(new CatData(domainUrl + "15.jpg"));
//        mList.add(new CatData(domainUrl + "16.jpg"));
//        mList.add(new CatData(domainUrl + "17.jpg"));
//        mList.add(new CatData(domainUrl + "18.jpg"));
//        mList.add(new CatData(domainUrl + "19.jpg"));
//        mList.add(new CatData(domainUrl + "20.jpg"));
        mList.add(new PictureEntity("https://pic4.zhimg.com/v2-3aa820f6c450768c395a2d72b3abda1f_r.jpg"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/0160615c26deffa8012029ac2d20f4.jpg@1280w_1l_2o_100sh.jpg\n"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/01ed5a5aee95efa801206aba623044.jpg@1280w_1l_2o_100sh.jpg"));
        mList.add(new PictureEntity("https://ts1.cn.mm.bing.net/th/id/R-C.59a07023a5e9b543c6589f68c0fb3eb7?rik=NaGBa514BbyZyw&riu=http%3a%2f%2f10331995.s21i.faiusr.com%2f2%2fABUIABACGAAgpfOD-gUo-qjFjAQw0wg4rg8.jpg&ehk=mwGjfvGy7fOqIRdwBRkwOtc%2fC8FoslTUnKliVLASWTo%3d&risl=&pid=ImgRaw&r=0"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/01c0665543065f0000019ae92d2f01.jpg@1280w_1l_2o_100sh.jpg"));
        mList.add(new PictureEntity("https://pic2.zhimg.com/v2-c5136f3935062c02173ff48751ed3936_r.jpg?source=1940ef5c"));
        mList.add(new PictureEntity("https://pic1.zhimg.com/v2-b263d820597306d3505563a5746e0cae_r.jpg?source=1940ef5c"));
        mList.add(new PictureEntity("https://pic4.zhimg.com/v2-d6f19d67162a2dfa39e4581b68c1f131_r.jpg?source=1940ef5c"));
        mList.add(new PictureEntity("https://pic3.zhimg.com/v2-85cda1f63375fc10f53b9167ed77940f_r.jpg?source=1940ef5c"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/019192583ecbdca8012060c800ee4c.jpg@1280w_1l_2o_100sh.jpg"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/01f0865d3900b5a8012187f4b4ed85.jpg@1280w_1l_2o_100sh.jpg"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/0146d25d96bb97a8012060be8b4497.jpg@1280w_1l_2o_100sh.jpg"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/0180645d4e305fa80120695cc6e040.jpg@1280w_1l_2o_100sh.jpg"));
        mList.add(new PictureEntity("https://pic1.zhimg.com/v2-cb0a0c85c04248901cb65a24190c90c5_r.jpg"));
        mList.add(new PictureEntity("https://img.zcool.cn/community/01c5375c122880a8012092528aeeed.jpg@1280w_1l_2o_100sh.jpg"));
        mList.add(new PictureEntity("https://ts1.cn.mm.bing.net/th/id/R-C.5c75f0d6f57f23ed2f2ca0a52ff03c91?rik=xBu5B07oE%2fxIww&riu=http%3a%2f%2fi1.bagong.cn%2f70%2f1c%2f67f9059eb54a7d38882a3be2b94c_640x.jpg&ehk=6AiZvE0aYGSIiBFq0U2IGhzJTAr3PhtCRLvf%2bpX781w%3d&risl=&pid=ImgRaw&r=0"));
        mList.add(new PictureEntity("https://pic1.zhimg.com/50/v2-6364de014296af4f93422d0094467ea0_hd.jpg?source=1940ef5c\n"));
        mList.add(new PictureEntity("https://pic1.zhimg.com/v2-0a820be749c145ebe9e10336c3faca44_r.jpg"));

        PictureAdapter catAdapter = new PictureAdapter(getContext(), mList);
        catAdapter.setOnClickImageListener((imgUrl) -> {
            CustomDialog customDialog = new CustomDialog(getContext(), R.layout.dialog_picture, R.style.pop_anim_style);
            ImageView imageView = customDialog.findViewById(R.id.image);
            PicassoUtils.loadImageView(imgUrl, imageView);
            imageView.setOnClickListener(v -> {
                customDialog.cancel();
            });
            customDialog.show();
        });
        mGridView.setAdapter(catAdapter);
    }
}
