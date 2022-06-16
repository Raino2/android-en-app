package com.example.eva.English;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.eva.CompreActivity;
import com.example.eva.ListenActivity;
import com.example.eva.MyCourseActivity;
import com.example.eva.PersonActivity;
import com.example.eva.QuestionnaireActivity;
import com.example.eva.R;
import com.example.eva.SlideActivity;
import com.example.eva.SlideMenu;
import com.example.eva.TestActivity;
import com.example.eva.TextImageView.TextImageView;
import com.example.eva.WordActivity;

public class EnglishSlideActivity extends AppCompatActivity {
    private SlideMenu slideMenu;
    private CardView cv_back;
    private Button mBtnInformation;
    private Button mBtnWord;
    private Button mBtnRead;
    private Button mBtnListen;
    private Button mBtnTest;
    //侧滑界面的跳转
    private TextImageView mTIVPerson;
    private TextImageView mTIVCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_slide);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏

        cv_back = (CardView) findViewById(R.id.cv_user_head_1);
        slideMenu = (SlideMenu)findViewById(R.id.slideMenu);
        //点击返回键打开或关闭Menu
        cv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
            }
        });

        mBtnInformation = findViewById(R.id.btn_0);
        mBtnWord = findViewById(R.id.btn_1);
        mBtnRead = findViewById(R.id.btn_2);
        mBtnListen = findViewById(R.id.btn_3);
        mBtnTest = findViewById(R.id.btn_4);
        mTIVPerson = findViewById(R.id.slide_person);
        mTIVCourses = findViewById(R.id.slide_plan);


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
        mTIVPerson.setOnClickListener(onClick);
        mTIVCourses.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_0:
                    intent = new Intent(EnglishSlideActivity.this, English_QuestionnaireActivity.class);
                    break;
                case R.id.btn_1:
                    intent = new Intent(EnglishSlideActivity.this, WordEnglishActivity.class);
                    break;
                case R.id.btn_2:
                    intent = new Intent(EnglishSlideActivity.this, CompreActivity.class);
                    break;
                case R.id.btn_3:
                    intent = new Intent(EnglishSlideActivity.this, ListenActivity.class);
                    break;
                case R.id.btn_4:
                    intent = new Intent(EnglishSlideActivity.this, TestActivity.class);
                    break;
                case R.id.slide_person:
                    intent = new Intent(EnglishSlideActivity.this, PersonActivity.class);
                    break;
                case R.id.slide_plan:
                    intent = new Intent(EnglishSlideActivity.this, MyCourseActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
