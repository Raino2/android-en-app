package com.example.eva;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eva.util.ToastUtil;

public class CompreActivity extends AppCompatActivity {

    private Button mBtnSubmit;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compre);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //播放提示音效
        mPlayer = MediaPlayer.create(this,R.raw.comprehension);
        mPlayer.start();

        mBtnSubmit = findViewById(R.id.btn_submit);
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先默认其做正确，之后再修改
                ToastUtil.showMsg(CompreActivity.this,"本次得分一百分，你真棒！");
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
