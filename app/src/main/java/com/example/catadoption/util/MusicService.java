package com.example.catadoption.util;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.util
 文件名:  MusicService
 创建者:  1vade
 创建时间:2022/6/28 15:46
 描述:    TODO
*/

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    public class MyBinder extends Binder {
        public void callplay(String path) {
            play(path);
        }

        public void callPause() {
            pause();
        }
    }
    public void play(String path) {
        try {
            if (mediaPlayer==null) {
                mediaPlayer=new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_SYSTEM);
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
                mediaPlayer.setOnPreparedListener(MediaPlayer::start);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        if (mediaPlayer!=null&&mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        else if (mediaPlayer!=null&&(!mediaPlayer.isPlaying())) {
            mediaPlayer.start();
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
}
