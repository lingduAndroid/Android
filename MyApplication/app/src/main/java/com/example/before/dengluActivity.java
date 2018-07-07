package com.example.before;

/**
 * Created by zero°c on 2018/3/8.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeroc.myapplication.R;
import com.example.zeroc.myapplication.shouyeActivity;
import com.zero.news.ActivityCollector;
import com.zero.SQLite.DBManager;

public class dengluActivity extends AppCompatActivity {
    private Button fanhui;
    private Button queding;
    private EditText count;
    private EditText password;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    private TextView forgetPass;
    public static String haoma;
    private String mima;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);
        ActivityCollector.addActivity(this);

        fanhui=(Button) findViewById(R.id.fanhui);
        queding=(Button) findViewById(R.id.queding);
        count = (EditText) findViewById(R.id.edit_count);
        forgetPass=(TextView)findViewById(R.id.forgetId);
        password = (EditText) findViewById(R.id.edit_password);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass=(CheckBox)findViewById(R.id.remember_pass);
        forgetPass.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        boolean isRemenber=pref.getBoolean("remember_password",false);
        if(isRemenber){
            //将账号和密码都设置到文本中
             haoma=pref.getString("haoma","");
             mima=pref.getString("mima","");
             count.setText(haoma);
             password.setText(mima);
             rememberPass.setChecked(true);
        }
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dengluActivity.this,forgetActivity.class);
                startActivity(intent);
            }
        });

        fanhui.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent=new Intent(dengluActivity.this,MainActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );
        queding.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {

                                           haoma = String.valueOf(count.getText());
                                           mima= String.valueOf(password.getText());


                                           DBManager DBManager =new DBManager(dengluActivity.this);
                                           Boolean zhanghu = DBManager.login(haoma,mima);

                                           if(haoma.equals("")){
                                               Toast.makeText(dengluActivity.this, "请您输入用户名！", Toast.LENGTH_SHORT).show();
                                               return;
                                           }
                                           if(mima.equals("")){
                                               Toast.makeText(dengluActivity.this, "请您输入密码！", Toast.LENGTH_SHORT).show();
                                               return;
                                           }

                                           if(zhanghu==true) {
                                               //账号密码匹配
                                               editor=pref.edit();
                                               if(rememberPass.isChecked()){
                                                   editor.putBoolean("remember_password",true);
                                                   editor.putString("haoma",haoma);
                                                   editor.putString("mima",mima);
                                               }else {
                                                   editor.clear();
                                               }
                                               editor.apply();

                                               Intent intent=new Intent();
                                               intent.setClass(dengluActivity.this, shouyeActivity.class);
                                               startActivity(intent);
                                               Toast.makeText(dengluActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                                           }
                                           else{
                                               Toast.makeText(dengluActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                                           }


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
