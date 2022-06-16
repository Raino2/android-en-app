package com.example.eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.eva.util.ToastUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import android_serialport_api.SerialPort;

public class MaintenActivity extends AppCompatActivity {
    private Button mBtnUser;
    private Button mBtnMainten;
    private Button mBtnLearn;
    private Button mBtnListen;
    private Button mBtnBack;
    private SerialPort mSerialPort;
    OutputStream mOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainten);

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


        //串口通信
        try {
            mSerialPort = new SerialPort(new File("/dev/ttyS1"),9600,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mOut = mSerialPort.getOutputStream();


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
        mBtnUser.setOnClickListener(onClick);
        mBtnMainten.setOnClickListener(onClick);
        mBtnListen.setOnClickListener(onClick);
        mBtnLearn.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_user:
                    //用户检测界面
                    try{
                        String send = "user";
                        byte[] context = send.getBytes();
                        mOut.write(context);
                        mOut.flush();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btn_mainten:
                    //颜色识别模式
                    try{
                        String send = "color";
                        byte[] context = send.getBytes();
                        mOut.write(context);
                        mOut.flush();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btn_listen:
                    //距离识别模式
                    try{
                        String send = "do";
                        byte[] context = send.getBytes();
                        mOut.write(context);
                        mOut.flush();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btn_learn:
                    //机械运动模式
                    try{
                        String send = "juli";
                        byte[] context = send.getBytes();
                        mOut.write(context);
                        mOut.flush();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
