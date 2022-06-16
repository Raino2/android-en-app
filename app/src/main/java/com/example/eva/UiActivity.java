package com.example.eva;

import android.app.UiAutomation;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eva.util.ToastUtil;

public class UiActivity extends AppCompatActivity {
    private Button mBtnInformation;
    private Button mBtnWord;
    private Button mBtnRead;
    private Button mBtnListen;
    private Button mBtnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_acticity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mBtnInformation = findViewById(R.id.btn_0);
        mBtnWord = findViewById(R.id.btn_1);
        mBtnRead = findViewById(R.id.btn_2);
        mBtnListen = findViewById(R.id.btn_3);
        mBtnTest = findViewById(R.id.btn_4);

        //设置监听事件
        setListener();
    }

   private void setListener(){
        OnClick onClick = new OnClick();
        mBtnInformation.setOnClickListener(onClick);
        mBtnWord.setOnClickListener(onClick);
        mBtnRead.setOnClickListener(onClick);
        mBtnListen.setOnClickListener(onClick);
        mBtnTest.setOnClickListener(onClick);
   }

   private class OnClick implements View.OnClickListener{

       @Override
       public void onClick(View v) {
           Intent intent = null;
           switch (v.getId()) {
               case R.id.btn_0:
                   intent = new Intent(UiActivity.this,QuestionnaireActivity.class);
                   break;
               case R.id.btn_1:
                   intent = new Intent(UiActivity.this, WordActivity.class);
                   break;
               case R.id.btn_2:
                   intent = new Intent(UiActivity.this, CompreActivity.class);
                   break;
               case R.id.btn_3:
                   intent = new Intent(UiActivity.this, ListenActivity.class);
                   break;
               case R.id.btn_4:
                   intent = new Intent(UiActivity.this, TestActivity.class);
                   break;
           }
           startActivity(intent);
       }
   }

}
