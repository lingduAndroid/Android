package com.example.before;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.zeroc.myapplication.R;
import com.zero.news.ActivityCollector;

public class forgetActivity extends AppCompatActivity {
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ActivityCollector.addActivity(this);

        title = (TextView) findViewById(R.id.titleid);
        title.setText("找回密码");

    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }
}
