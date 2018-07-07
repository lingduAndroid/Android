package com.example.zeroc.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zero.news.ActivityCollector;

import static com.example.before.dengluActivity.haoma;

public class huiyuanActivity extends AppCompatActivity  implements  View.OnClickListener{
    private Button kaitong;
    private ImageButton fanhui;
    private View inflate;
    private EditText phone;
    private String  ceshi;
    private Button three;
    private Button liji;
    private Button six;
    private Button twelve;
    private EditText zidingyi;
    private TextView jiage;


    private void show(){

        Dialog dialog = new Dialog(huiyuanActivity.this);

        //填充对话框的布局
        inflate = LayoutInflater.from (huiyuanActivity.this).inflate(R.layout.dialog_vip, null);
        //初始化控件
         phone=(EditText)inflate.findViewById(R.id.phoneid) ;
        twelve = (Button) inflate.findViewById(R.id.twelveid);
        three= (Button)inflate.findViewById(R.id.threeid);
        six= (Button) inflate.findViewById(R.id.sixid);
        jiage=(TextView)inflate.findViewById(R.id.jiageid) ;
        liji= (Button) inflate.findViewById(R.id.lijikaitongid);
        zidingyi=(EditText)inflate.findViewById(R.id.zidingyiid);
       three.setOnClickListener(this);
       liji.setOnClickListener(this);
        six.setOnClickListener(this);
        twelve.setOnClickListener(this);

        zidingyi.addTextChangedListener(editclick);
        phone.setText(haoma);

        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity( Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 5;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }

    private TextWatcher editclick = new TextWatcher() {

        private int month;
        private int money;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }


        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        //一般我们都是在这个里面进行我们文本框的输入的判断，上面两个方法用到的很少
        @Override
        public void afterTextChanged(Editable s) {
            if(zidingyi.length()!=0) {
                month = Integer.parseInt(zidingyi.getText().toString());
            }
            else {
                month=1;
            }
              money = (month * 10);
              jiage.setText(String.valueOf(money));

        }
    };

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.threeid:
                jiage.setText("30");
                break;

            case R.id.sixid:
                jiage.setText("56.9");
                break;

            case R.id.twelveid:
                jiage.setText("100");

                break;
            case R.id.lijikaitongid:
                Toast.makeText(huiyuanActivity.this,"醒醒吧穷逼，你没有钱",Toast.LENGTH_LONG).show();
                 break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huiyuan);
        ActivityCollector.addActivity(this);

        kaitong=(Button)findViewById(R.id.kaitongid);
       fanhui=(ImageButton)findViewById(R.id.fanhuiid);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        kaitong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           show();

            }
        });

    }
    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }

}



