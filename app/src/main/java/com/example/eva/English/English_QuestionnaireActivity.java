package com.example.eva.English;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.eva.QuestionnaireActivity;
import com.example.eva.R;
import com.example.eva.SlideActivity;
import com.example.eva.util.ToastUtil;

public class English_QuestionnaireActivity extends AppCompatActivity {
    private Button mBtnQuesSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english__questionnaire);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mBtnQuesSubmit = findViewById(R.id.btn_questionnaire_submit);
        //记录信息后还是返回跳转前界面开始学习
        mBtnQuesSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showMsg(English_QuestionnaireActivity.this,"Fill it out and start your learning journey!");
                Intent intent = null;
                intent = new Intent(English_QuestionnaireActivity.this, SlideActivity.class);
                startActivity(intent);
            }
        });
    }
}
