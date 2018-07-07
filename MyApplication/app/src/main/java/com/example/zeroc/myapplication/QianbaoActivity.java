package com.example.zeroc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zero.news.ActivityCollector;

public class QianbaoActivity extends AppCompatActivity {
    private ImageButton fanhui;
    private TextView title;
    private Button tixian;
    private TextView yue;
    public static double  balance=1.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qianbao);
        ActivityCollector.addActivity(this);

        fanhui=(ImageButton)findViewById(R.id.fanhuiid);
        title=(TextView)findViewById(R.id.titleid);
        tixian=(Button)findViewById(R.id.tixianid);
        yue=(TextView)findViewById(R.id.yueid);
        title.setText("钱包");
        yue.setText(balance+"Y币");

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });

        tixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QianbaoActivity.this,"没钱噢",Toast.LENGTH_SHORT).show();
            }

        });
    }
    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }

}
