package com.example.eva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.eva.CourseAdapter.LinearCourseFinishAdapter;
import com.example.eva.CourseAdapter.LinearCourseGoAdapter;

public class MyCourseActivity extends AppCompatActivity {
    private ImageView mIVBack;
    private RecyclerView mRVFinish;
    private RecyclerView mRvGoing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_course);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mRVFinish = findViewById(R.id.rv_course_finish);
        mIVBack = findViewById(R.id.iv_course_back_2);
        mRvGoing = findViewById(R.id.rv_course_going);

        mIVBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRVFinish.setLayoutManager(new LinearLayoutManager(MyCourseActivity.this));
        mRVFinish.setAdapter(new LinearCourseFinishAdapter(MyCourseActivity.this, new LinearCourseFinishAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(MyCourseActivity.this,"click..."+pos, Toast.LENGTH_LONG).show();
            }
        }));

        mRvGoing.setLayoutManager(new LinearLayoutManager(MyCourseActivity.this));
        mRvGoing.setAdapter(new LinearCourseGoAdapter(MyCourseActivity.this, new LinearCourseGoAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(MyCourseActivity.this,"click..."+pos, Toast.LENGTH_LONG).show();
            }
        }));
    }
}
