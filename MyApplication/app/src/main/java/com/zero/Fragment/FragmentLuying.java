package com.zero.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.zeroc.myapplication.R;
import com.example.zeroc.myapplication.classifyActivity;
import com.example.zeroc.myapplication.collectActivity;
import com.example.zeroc.myapplication.everyDayActivity;

public class FragmentLuying extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_recorder,container,false);

        ImageButton collect=(ImageButton)view.findViewById(R.id.collect_id);
        ImageButton classify=(ImageButton)view.findViewById(R.id.class_id);
        ImageButton hot=(ImageButton)view.findViewById(R.id.hot_id);
        ImageButton day=(ImageButton)view.findViewById(R.id.day_id);


        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),collectActivity.class);
                startActivity(intent);

            }
        });

        classify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),classifyActivity.class);
                startActivity(intent);

            }
        });

        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),collectActivity.class);
                startActivity(intent);

            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(),everyDayActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}