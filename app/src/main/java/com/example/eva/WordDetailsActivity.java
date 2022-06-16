package com.example.eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WordDetailsActivity extends AppCompatActivity {
    private ImageView mIvPlay;
    private TextView mTVFinish;
    private Button mBtnGoing;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_details);

        mIvPlay = findViewById(R.id.word_play_1);
        mBtnGoing = findViewById(R.id.btn_going);
        mTVFinish = findViewById(R.id.tv_understand);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        //找到音频
        mPlayer = MediaPlayer.create(this,R.raw.technology1);
        mIvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.start();
            }
        });

        mBtnGoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTVFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(WordDetailsActivity.this,SlideActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
    }
