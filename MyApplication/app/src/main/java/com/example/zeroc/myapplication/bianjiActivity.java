package com.example.zeroc.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zero.news.ActivityCollector;

import java.util.Calendar;

public class bianjiActivity extends AppCompatActivity implements View.OnClickListener  {
    private ImageButton fanhui;
    private TextView baocun;
    private LinearLayout headPortrait;
    private LinearLayout background,sex,city;
    private EditText username;
    private EditText birthday;
    public static String name;
    public static ImageView touxiangimage;
    private View inflate;
    private Button man;
    private Button woman;
    private Button cancel;
    private Dialog dialog;

    public void showSex(){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        inflate = LayoutInflater.from(this).inflate(R.layout.sex_dialog, null);
        man = (Button) inflate.findViewById(R.id.manId);
        woman = (Button) inflate.findViewById(R.id.womanId);
        cancel = (Button) inflate.findViewById(R.id.btn_cancel);
        man.setOnClickListener(this);
        woman.setOnClickListener(this);
        cancel.setOnClickListener(this);

        dialog.setContentView(inflate);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity( Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();//获取对话框当前的参数
        lp.y = 20;
        WindowManager m = getWindowManager();
    Display d = m.getDefaultDisplay(); //获取屏幕宽、高
    lp.height = (int) (d.getHeight() * 0.3); //高度设置为屏幕的0.3
    lp.width = (int) (d.getWidth()*0.9); //宽度设置为屏幕的0.9

        dialogWindow.setAttributes(lp);

        dialog.show();
}


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.manId:
                Toast.makeText(bianjiActivity.this,"性别男设置成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.womanId:
                Toast.makeText(this,"性别女设置成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
        }
    }

//    private void showSex(){
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        String[] items = {"男", "女"};
//        builder.setNegativeButton("取消", null);
//        builder.setItems(items, new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which) {
//                    case 0: //
//                        Toast.makeText(bianjiActivity.this,"性别男设置成功",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1: //
//                        Toast.makeText(bianjiActivity.this,"性别女设置成功",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
//        builder.create().show();
//    }


    public void showMyDialog() {
        // 创建退出对话框
        AlertDialog isExit = new AlertDialog.Builder(this).create();
        // 设置对话框标题
        isExit.setTitle("提示");
        // 设置对话框消息
        isExit.setMessage("修改的资料还未保存，确定要退出吗");
        // 添加选择按钮并注册监听
        isExit.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        isExit.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);

        // 显示对话框
        isExit.show();
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    public void onBackPressed(){
        showMyDialog();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ActivityCollector.addActivity(this);

        background = (LinearLayout) findViewById(R.id.cover_id);
        birthday = (EditText) findViewById(R.id.birthdayid);
        sex = (LinearLayout) findViewById(R.id.sex_id);
        city = (LinearLayout) findViewById(R.id.city_id);
        fanhui = (ImageButton) findViewById(R.id.fanhuiid);
        baocun = (TextView) findViewById(R.id.baocunid);
        headPortrait= (LinearLayout)findViewById(R.id.head_portrait);
        username = (EditText) findViewById(R.id.username);
        touxiangimage = (ImageView) findViewById(R.id.touxiangiamgeid);
        username.setText(name);


        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sex.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        showSex();
            }
        });
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        headPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bianjiActivity.this, touxiangActivity.class);
                startActivity(intent);
            }
        });

        fanhui.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                          showMyDialog();
                                      }
                                  }
        );

        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = username.getText().toString();
                Toast.makeText(bianjiActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        birthday.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    showDatePickDlg();
                    return true;
                }

                return false;
            }
        });

        birthday.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    showDatePickDlg();
                }

            }
        });


    }



    protected void showDatePickDlg() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(bianjiActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear=monthOfYear+1;
                bianjiActivity.this.birthday.setText(year + "年" + monthOfYear + "月" + dayOfMonth+"日");
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();


    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }



}

