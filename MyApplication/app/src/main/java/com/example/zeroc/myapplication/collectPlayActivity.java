package com.example.zeroc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zero.news.ActivityCollector;

public class collectPlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_play);
        TextView title=(TextView)findViewById(R.id.titleid) ;
        title.setText("演绎秀");
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }
}
