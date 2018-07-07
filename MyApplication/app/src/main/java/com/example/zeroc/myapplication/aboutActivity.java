package com.example.zeroc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zero.news.ActivityCollector;

public class aboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_about);
    }
    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }

}
