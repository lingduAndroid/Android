
package com.zero.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.zeroc.myapplication.R;
import com.example.zeroc.myapplication.bianjiActivity;

public class Fragmentshouye extends Fragment {

    private ImageButton sousuo;
    private Button sendnotice;

    public void showMyDialog() {
        // 创建退出对话框
        AlertDialog isExit = new AlertDialog.Builder(getContext()).create();
        // 设置对话框标题
        isExit.setTitle("提示");
        // 设置对话框消息
        isExit.setMessage("别急，马上可以搜了");
        // 显示对话框
        isExit.show();
    }



    bianjiActivity activity =(bianjiActivity)getActivity();



        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View view=inflater.inflate(R.layout.fragment_main,container,false);

            sousuo=(ImageButton)view.findViewById(R.id.sousuoid);
            sendnotice=(Button)view.findViewById(R.id.send_notice);
            sousuo.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    showMyDialog();
                    Log.e("ljb", "onClick: 111" );
                }
            });
//            sendnotice.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    NotificationManager manager=(NotificationManager)getSystemService();
//                }
//            });
            return view;
        }

    @Override public void onResume() {
            super.onResume();

            getView().setFocusableInTouchMode(true);
            getView().requestFocus();
            getView().setOnKeyListener(new View.OnKeyListener()
            { @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            { if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK)
            {
                return true;
                }
                return false; }
                 });
                 }


    }
