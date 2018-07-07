package com.zero.Fragment;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.zeroc.myapplication.R;
import com.zero.SQLite.DBManager;
import com.zero.SQLite.Record;
import com.zero.news.AdapterComment;
import com.zero.news.Comment;
import com.zero.news.Recorder;

import java.util.ArrayList;
import java.util.List;

import static com.example.zeroc.myapplication.QianbaoActivity.balance;
import static com.zero.news.Recorder.FilePath;

public class Fragmentyyou extends Fragment implements View.OnClickListener {

    private TextView dongtai, juben;
    private ImageButton liwu;
    private TextView yanyixiu;
    private TextView yue;
    private View inflate;
    private Dialog dialog;
    private Button xianhua;
    private Button songchu;
    private Button jian;
    private Button add;
    private TextView hidedown;
    private RelativeLayout rcomment;
    private LinearLayout renroll;
    private EditText shuliang;
    private LinearLayout comment;
    private ListView commentList;
    private EditText commentContent;
    private int count;
    private List<Comment> data;
    private Button commentSend, send, play;
    private AdapterComment adapterComment;
    private ImageButton record;
    private RelativeLayout recorderImage;
    private TextView dm_tv_txt;
    public  boolean model = true;
    public Recorder recorder;

    private void show() {
        dialog = new Dialog(getContext(), R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_layout, null);
        //初始化控件
        xianhua = (Button) inflate.findViewById(R.id.xianhuaid);
        songchu = (Button) inflate.findViewById(R.id.songchuid);
        jian = (Button) inflate.findViewById(R.id.jianid);
        add = (Button) inflate.findViewById(R.id.jiaid);
        shuliang = (EditText) inflate.findViewById(R.id.shuliangid);
        yue = (TextView) inflate.findViewById(R.id.yueid);
        xianhua.setOnClickListener(this);
        songchu.setOnClickListener(this);
        jian.setOnClickListener(this);
        add.setOnClickListener(this);
        shuliang.setText("1");
        yue.setText(balance + "Y币");
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }

    public void showRecorder() {
        dialog = new Dialog(getContext());
        inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_recorder, null);
        recorderImage = (RelativeLayout) inflate.findViewById(R.id.dm_rl_bg);
        dm_tv_txt = (TextView) inflate.findViewById(R.id.dm_tv_txt);
        send = (Button) inflate.findViewById(R.id.send);
        play = (Button) inflate.findViewById(R.id.play);
        recorder = new Recorder(getContext());

        dialog.setContentView(inflate);
        //窗体
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams layoutParams = dialogWindow.getAttributes();
        layoutParams.y = 0;
        dialogWindow.setLayout(-1, -2);//设置宽高
        dialogWindow.setAttributes(layoutParams);
        dialog.show();
        recorderImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modeDecision(model);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
    }


    public void onClick(View view) {
        count = Integer.parseInt(shuliang.getText().toString());
        switch (view.getId()) {
            case R.id.songchuid:
                Toast.makeText(getContext(), "当前余额不足，请充值", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jiaid:
                count++;
                shuliang.setText("" + count);
                break;
            case R.id.jianid:
                if ( count > 0 ) {
                    count--;
                    shuliang.setText("" + count);
                }
                break;
            case R.id.xianhuaid:
                xianhua.setBackgroundResource(R.drawable.biankuang);
                break;
//            case R.id.dm_rl_bg:
//                modeDecision(model);
//                break;
//            case R.id.send:
//                send();
//                break;
//            case R.id.play:
//                play();
//                break;
        }
    }

    public void send(){
        DBManager dbm=new DBManager(getContext());
        Record recordModel = new Record();
        recordModel.setPath(FilePath);
        recordModel.setPlayed(false);
        Log.e("ljb", "send: " );
        dbm.add(recordModel);
        Log.e("ljb", "send:1" );
    }
    public void play(){
        recorder.playRecording();
        Log.e("ljb", "modeDecision: 2" );
    }
    public void  modeDecision(boolean mode){
        if(mode==true){
            recorder.startRecording();
            Log.e("ljb", "modeDecision: " );
            model=false;
            dm_tv_txt.setText("点击停止");
        }
        else{
            Log.e("ljb", "modeDecision:1 " );
            recorder.stopRecording();
            dm_tv_txt.setText("点击录音");
            model=true;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_yyfriend,container,false);

        dongtai=(TextView)view.findViewById(R.id.dongtaiid);
        juben =(TextView)view.findViewById(R.id.jubenid);
        yanyixiu=(TextView)view.findViewById(R.id.yanyixiuid);
        renroll=(LinearLayout)view.findViewById(R.id.r_enroll);
        hidedown =(TextView)view.findViewById(R.id.hide_down);
        commentList=(ListView)view.findViewById(R.id.comment_list);
        liwu=(ImageButton)view.findViewById(R.id.liwuid);
        comment=(LinearLayout)view.findViewById(R.id.comment_id);
        rcomment=(RelativeLayout)view.findViewById(R.id.rl_comment);
        commentContent = (EditText) view.findViewById(R.id.comment_content);
        commentSend=(Button)view.findViewById(R.id.comment_send);
        record=(ImageButton)view.findViewById(R.id.record_image);

        data=new ArrayList<>();
        adapterComment=new AdapterComment(getContext(),data);
        commentList.setAdapter(adapterComment);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecorder();
            }
        });

        commentSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendComment();
            }
        });
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显示评论框
                renroll.setVisibility(View.GONE); //隐藏
                rcomment.setVisibility(View.VISIBLE);//显示
//                popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                // 弹出输入法
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
        hidedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renroll.setVisibility(View.VISIBLE); //显示
                rcomment.setVisibility(View.GONE);//隐藏
                InputMethodManager im = (InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(commentContent.getWindowToken(), 0); //隐藏输入法键盘
             }
        });
        liwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

        dongtai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                dongtai.setTextColor(Color.GREEN);
                dongtai.setBackgroundColor(getResources().getColor(R.color.colorHui));
                juben.setBackgroundColor(Color.WHITE);
                yanyixiu.setBackgroundColor(Color.WHITE);
                juben.setTextColor(Color.BLACK);
                yanyixiu.setTextColor(Color.BLACK);
            }
        });

        juben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                juben.setTextColor(Color.GREEN);
                dongtai.setTextColor(Color.BLACK);
                yanyixiu.setTextColor(Color.BLACK);
                juben.setBackgroundColor(getResources().getColor(R.color.colorHui));
                dongtai.setBackgroundColor(Color.WHITE);
                yanyixiu.setBackgroundColor(Color.WHITE);

            }
        });

        yanyixiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                yanyixiu.setTextColor(Color.GREEN);
                juben.setTextColor(Color.BLACK);
                dongtai.setTextColor(Color.BLACK);
                yanyixiu.setBackgroundColor(getResources().getColor(R.color.colorHui));
                dongtai.setBackgroundColor(Color.WHITE);
                juben.setBackgroundColor(Color.WHITE);
            }
        });

        return view;
    }
    public void sendComment() {
        if ( commentContent.getText().toString().equals("") ) {
            Toast.makeText(getContext(), "评论不能为空！", Toast.LENGTH_SHORT).show();
        } else {
            // 生成评论数据
            Comment comment = new Comment();
            comment.setName("评论者" + (data.size() + 1) + "：");
            comment.setContent(commentContent.getText().toString());
            adapterComment.addComment(comment);
            // 发送完，清空输入框
            commentContent.setText("");

            Toast.makeText(getContext(), "评论成功！", Toast.LENGTH_SHORT).show();
        }
    }


}