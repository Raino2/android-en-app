package com.example.eva;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eva.util.ToastUtil;

public class TestActivity extends AppCompatActivity {

    private Button mBtnTestSubmit;
    private MediaPlayer mPlayer = null;
    private MediaPlayer mediaPlayer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mBtnTestSubmit = findViewById(R.id.btn_test_submit);

        mBtnTestSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(TestActivity.this,"提交成功");
                Intent intent = null;
                intent = new Intent(TestActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

        //播放提示音效
        mPlayer = MediaPlayer.create(this,R.raw.test1);
        mPlayer.start();

    }
    //退出界面之后就停止指导语音
    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
