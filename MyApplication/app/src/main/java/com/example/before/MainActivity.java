package com.example.before;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zeroc.myapplication.R;
import com.zero.news.ActivityCollector;


public class MainActivity extends AppCompatActivity {

        private Button zhuce;
        private Button denglubutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCollector.addActivity(this);

        zhuce = (Button) findViewById(R.id.zhuce);
        denglubutton = (Button) findViewById(R.id.denglubutton);



        zhuce.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {

                                         Intent intent = new Intent();
                                         intent.setClass(MainActivity.this, ZCActivity.class);
                                         MainActivity.this.startActivity(intent);

                                     }
                                 }
        );

        denglubutton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                Intent intent = new Intent();
                                                intent.setClass(MainActivity.this, dengluActivity.class);
                                                MainActivity.this.startActivity(intent);

                                            }
                                        }
        );







    }
        protected void onDestroy() {
            super.onDestroy();
            //删除该活动
            ActivityCollector.removeActivity(this);
        }


    }