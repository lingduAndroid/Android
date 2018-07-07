package com.zero.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zeroc.myapplication.R;

/**
 * Created by zero°c on 2018/3/19.
 */

public class FragmentButton extends Fragment{


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View view=inflater.inflate(R.layout.fragment_imagebutton,container,false);
            return view;

    }
}
