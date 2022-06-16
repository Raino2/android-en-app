package com.example.eva;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.example.eva.util.ToastUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordTestActivity extends Activity {

    private GridView mGv;
    private ImageView mIVPlay;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_test);

        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mPlayer = MediaPlayer.create(this,R.raw.technology1);

        //播放单词
        mIVPlay =findViewById(R.id.word_play);
        mIVPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.start();
            }
        });


        mGv = findViewById(R.id.gv);
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //去判断他点击的是不是正确的图片，这里是举例，直接给定的结果
                Intent intent = null;

                if(position == 1){
                    ToastUtil.showMsg(WordTestActivity.this,"恭喜你，选择正确");
                    //如果选择正确将跳转到单词详细界面
                    intent = new Intent(WordTestActivity.this,WordDetailsActivity.class);
                }else{
                    ToastUtil.showMsg(WordTestActivity.this,"选择错误，请仔细一点哦");
                }

                startActivity(intent);
            }
        });

        int[] imageAry = new int[]{
                R.drawable.plane,R.drawable.technology,R.drawable.cat,R.drawable.battle
        };

        List list = new ArrayList();

        for (int i = 0;i<imageAry.length;i++){
            Map map = new HashMap();
            map.put("image",imageAry[i]);
            list.add(map);
        }
        //实例化SimpleAdapter适配器的对象
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.layout_grid_item,
                new String[]{"image"},new int[]{R.id.iv_grid});
        //获得GridView组件
        GridView gridView = (GridView) findViewById(R.id.gv);
        //向GridView中添加内容
        gridView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
