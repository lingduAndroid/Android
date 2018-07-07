package com.zero.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.zeroc.myapplication.QianbaoActivity;
import com.example.zeroc.myapplication.R;
import com.example.zeroc.myapplication.huiyuanActivity;
import com.example.zeroc.myapplication.writeActivity;

public class FragmentHuiyuan extends Fragment{
    private ImageButton huiyuan;
    private ImageButton qianbao;
    private ImageButton write;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_member,container,false);

       huiyuan=(ImageButton)view.findViewById(R.id.YYhuiyuanid);
        qianbao=(ImageButton)view.findViewById(R.id.qianbaoid);
        write=(ImageButton)view.findViewById(R.id.write_id);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),writeActivity.class);
                startActivity(intent);
            }
        });

       huiyuan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getContext(),huiyuanActivity.class);
               startActivity(intent);
           }
       });


        qianbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),QianbaoActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}