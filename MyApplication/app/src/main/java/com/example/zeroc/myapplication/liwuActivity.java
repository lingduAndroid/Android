package com.example.zeroc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zero.news.ActivityCollector;

public class liwuActivity extends AppCompatActivity {
    private ImageButton fanhui;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liwu);
        ActivityCollector.addActivity(this);

        fanhui=(ImageButton)findViewById(R.id.fanhuiid);
        title=(TextView)findViewById(R.id.titleid);
        title.setText("礼物");

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });



    }
    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }

}
