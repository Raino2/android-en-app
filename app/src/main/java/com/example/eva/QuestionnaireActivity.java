package com.example.eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.eva.util.ToastUtil;

public class QuestionnaireActivity extends AppCompatActivity {
    private Button mBtnQuesSubmit;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //播放提示音效
        mPlayer = MediaPlayer.create(this,R.raw.question);
        mPlayer.start();

        mBtnQuesSubmit = findViewById(R.id.btn_questionnaire_submit);
        //记录信息后还是返回跳转前界面开始学习
        mBtnQuesSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(QuestionnaireActivity.this,"填写成功，开始你的学习之旅吧！");
                finish();
            }
        });
    }

    //退出界面之后就停止指导语音
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
