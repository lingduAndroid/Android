package com.example.zeroc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.before.MainActivity;
import com.zero.news.ActivityCollector;

public class shezhiActivity extends AppCompatActivity {
    private Button tuichu;
    private ImageButton fanhui;
    private Button zhanghao;
    private Button jiancha;
    private Button tousu;
    private Button guanyu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shezhi);
        ActivityCollector.addActivity(this);

        tuichu=(Button)findViewById(R.id.tuichuid);
        fanhui=(ImageButton)findViewById(R.id.fanhuiid);
        zhanghao=(Button)findViewById(R.id.zhanghaoid);
       jiancha=(Button)findViewById(R.id.jianchaid);
        tousu=(Button)findViewById(R.id.toushuid);
        guanyu=(Button)findViewById(R.id.guanyuid);

        jiancha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(shezhiActivity.this,"当前已是最新版本",Toast.LENGTH_SHORT).show();

            }
        });
        guanyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(shezhiActivity.this,aboutActivity.class);
                startActivity(intent);
            }
        });

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(shezhiActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(shezhiActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }

}
