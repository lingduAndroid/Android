package com.example.zeroc.myapplication;

/**
 * Created by zero°c on 2018/3/8.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.zero.Fragment.FragmentHuiyuan;
import com.zero.Fragment.FragmentLuying;
import com.zero.Fragment.FragmentWode;
import com.zero.Fragment.Fragmentshouye;
import com.zero.Fragment.Fragmentyyou;
import com.zero.news.ActivityCollector;

import java.util.List;


public class shouyeActivity extends AppCompatActivity  {

    private ImageButton wode;
    private ImageButton fuwu;
    private ImageButton haoyou;
    private ImageButton shiping;
    private  ImageButton liwu;
    private ImageButton luying;
    private Button fankui;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shouye);
        ActivityCollector.addActivity(this);

       replaceFragment(new Fragmentshouye());



        wode = (ImageButton) findViewById(R.id.wodeid);
        fuwu = (ImageButton) findViewById(R.id.fuwuid);
        haoyou = (ImageButton) findViewById(R.id.haoyouid);
        shiping = (ImageButton) findViewById(R.id.shipingid);

        luying = (ImageButton) findViewById(R.id.luyingid);
        fankui = (Button) findViewById(R.id.fankuiid);
        final ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){

        }



        wode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new FragmentWode());
            }
        });

       fuwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new FragmentHuiyuan());
            }
        });


        haoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                replaceFragment(new Fragmentyyou());
            }
        });


        shiping.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        replaceFragment(new Fragmentshouye());
                    }
                });


        luying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FragmentLuying());
            }
        });


    }


    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = shouyeActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }

    private long mExitTime;
    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(shouyeActivity.this, "再按一次退出演绎秀", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            ActivityCollector.finishAll();
            System.exit(0);
        }
    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentXianshi,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }

}
