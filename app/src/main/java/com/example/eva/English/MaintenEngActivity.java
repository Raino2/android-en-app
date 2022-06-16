package com.example.eva.English;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.eva.PersonActivity;
import com.example.eva.R;

public class MaintenEngActivity extends AppCompatActivity {
    private Button mBtnUser;
    private Button mBtnMainten;
    private Button mBtnLearn;
    private Button mBtnListen;
    private Button mBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainten_eng);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mBtnBack = findViewById(R.id.btn_back);
        mBtnLearn =findViewById(R.id.btn_learn);
        mBtnListen = findViewById(R.id.btn_listen);
        mBtnMainten = findViewById(R.id.btn_mainten);
        mBtnUser = findViewById(R.id.btn_user);

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setListener();
    }

    private void setListener(){
        OnClick onClick = new OnClick();
        //mBtnUser.setOnClickListener(onClick);
        mBtnMainten.setOnClickListener(onClick);
        //mBtnListen.setOnClickListener(onClick);
        //mBtnLearn.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_user:
                    //用户检测界面
                    break;
                case R.id.btn_mainten:
                    //监测数据界面
                    intent = new Intent(MaintenEngActivity.this, PersonActivity.class);
                    break;
                case R.id.btn_listen:
                    //听力检测界面
                    break;
                case R.id.btn_learn:
                    //机器人学习界面
                    break;
            }
            startActivity(intent);
        }
    }
}
