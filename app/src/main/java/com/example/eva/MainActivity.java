package com.example.eva;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eva.English.EnglishMainActivity;
import com.example.eva.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //给控件声明
    private Button mBtnLogin;
    private Button mBtnRegister;
    private EditText mTUserName;
    private EditText mTPassword;
    private TextView mTvEnglish;
    private TextView mTvMainten;

    private MediaPlayer mPlayer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //找到控件
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_register);
        mTUserName = findViewById(R.id.et_1);
        mTPassword = findViewById(R.id.et_2);
        mTvEnglish = findViewById(R.id.tv_English);
        mTvMainten = findViewById(R.id.tv_maintenance);
        //暂时只对登录设置了情况，采用提前注入信息的形式

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(MainActivity.this,"注册成功！");
            }
        });

        mTvEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =null;
                intent = new Intent(MainActivity.this, EnglishMainActivity.class);
                startActivity(intent);
                mPlayer.stop();

            }
        });

        mTvMainten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(MainActivity.this,MaintenActivity.class);
                startActivity(intent);
                mPlayer.stop();
            }
        });

        mBtnLogin.setOnClickListener(this);

        //找到对应的音频并播放
        mPlayer = MediaPlayer.create(this,R.raw.chineselogin);
        mPlayer.start();
    }

    @Override
    public void onClick(View v) {
        //获取输入的信息
        String username = mTUserName.getText().toString();
        String password = mTPassword.getText().toString();
        String ok = "登陆成功";
        String fail = "密码错误，登陆失败";
        Intent intent = null;

        if(username.equals("zbw")&&password.equals("17219111218")){
            //这个类是自己封装的一个类
            ToastUtil.showMsg(MainActivity.this,ok);
            //下面实现的是登陆界面的跳转
            intent = new Intent(MainActivity.this, SlideActivity.class);
            startActivity(intent);
        }else{
            //登录成功或者失败我们都需要弹出一个信息来告诉用户是成功还是失败
            ToastUtil.showMsg(MainActivity.this,fail);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //退出界面便停止语音
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
