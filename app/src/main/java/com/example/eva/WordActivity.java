package com.example.eva;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WordActivity extends AppCompatActivity {
    private Button mBtnWordStart;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mBtnWordStart = findViewById(R.id.btn_wordstart);
        mBtnWordStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(WordActivity.this,WordTestActivity.class);
                startActivity(intent);
            }
        });

        //播放提示音效
        mPlayer = MediaPlayer.create(this,R.raw.word);
        mPlayer.start();

    }

    //退出界面之后就停止指导语音
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }

}
