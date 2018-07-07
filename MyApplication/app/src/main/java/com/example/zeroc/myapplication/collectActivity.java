package com.example.zeroc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zero.news.ActivityCollector;

public class collectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ActivityCollector.addActivity(this);

        LinearLayout collectScript=(LinearLayout)findViewById(R.id.collect_script);
        LinearLayout collectPlay=(LinearLayout)findViewById(R.id.collect_play);
        TextView title=(TextView)findViewById(R.id.titleid) ;
        title.setText("收藏");

        collectScript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(collectActivity.this,collectScriptActivity.class);
                startActivity(intent);
            }
        });
        collectPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(collectActivity.this,collectPlayActivity.class);
                startActivity(intent);
            }
        });


    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }
}