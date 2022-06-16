package com.example.eva.English;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.eva.MaintenActivity;
import com.example.eva.R;
import com.example.eva.UiActivity;
import com.example.eva.util.ToastUtil;

public class EnglishMainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnLogin;
    private Button mBtnRegister;
    private EditText mTUserName;
    private EditText mTPassword;
    private Button mBtnMainten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_main);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_register);
        mTUserName = findViewById(R.id.et_1);
        mTPassword = findViewById(R.id.et_2);
        mBtnMainten = findViewById(R.id.btn_weixiu);

        mBtnMainten.setOnClickListener(this);

        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //获取输入的信息
        String username = mTUserName.getText().toString();
        String password = mTPassword.getText().toString();
        String ok = "Success";
        String fail = "Failed,please try again!";
        Intent intent = null;

        if(username.equals("lyh")&&password.equals("123456")){
            //这个类是自己封装的一个类
            ToastUtil.showMsg(EnglishMainActivity.this,ok);
            //下面实现的是登陆界面的跳转
            intent = new Intent(EnglishMainActivity.this, EnglishSlideActivity.class);
            startActivity(intent);
        }else{
            //登录成功或者失败我们都需要弹出一个信息来告诉用户是成功还是失败
            ToastUtil.showMsg(EnglishMainActivity.this,fail);
        }

        switch (v.getId()){
            case R.id.btn_weixiu:
                intent = new Intent(EnglishMainActivity.this, MaintenEngActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
