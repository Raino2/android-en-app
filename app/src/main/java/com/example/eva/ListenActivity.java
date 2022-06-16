package com.example.eva;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eva.util.ToastUtil;

import java.util.HashMap;

public class ListenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnPlay;
    private Button mBtnPause;
    private Button mBtnStop;
    private Button mBtnListenSubmit;
    private MediaPlayer mPlayer = null;
    private MediaPlayer mPlayer1 = null;
    private boolean isRelease = true;   //判断是否MediaPlayer是否释放的标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //播放提示音效
        mPlayer1 = MediaPlayer.create(this,R.raw.listentest);
        mPlayer1.start();

        mBtnListenSubmit = findViewById(R.id.btn_listen_submit);
        mBtnListenSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(ListenActivity.this,"提交成功");
                finish();
            }
        });
        bindViews();
    }

    private void bindViews() {
        mBtnPlay = findViewById(R.id.btn_play);
        mBtnPause = findViewById(R.id.btn_pause);
        mBtnStop = findViewById(R.id.btn_stop);

        //这里的监听事件用了评论的一个办法，如果我没理解错的话，就是这个亚子去写
        mBtnPlay.setOnClickListener(this);
        mBtnPause.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_play:
                if(isRelease){
                    mPlayer = MediaPlayer.create(this,R.raw.listen);
                    isRelease = false;
                }
                mPlayer.start();//开始播放
                mBtnPlay.setEnabled(false);
                mBtnPause.setEnabled(true);
                mBtnStop.setEnabled(true);
                break;
            case R.id.btn_pause:
                mPlayer.pause();//暂停播放
                mBtnPlay.setEnabled(true);
                mBtnPause.setEnabled(false);
                mBtnStop.setEnabled(false);
                break;
            case R.id.btn_stop:
                //mPlayer.pause();
                mPlayer.reset();     //重置MediaPlayer
                mPlayer.release();   //释放MediaPlayer
                isRelease = true;
                mBtnPlay.setEnabled(true);
                mBtnPause.setEnabled(false);
                mBtnStop.setEnabled(false);

        }
    }

    //退出界面之后就停止指导语音
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer1.stop();
    }


}
