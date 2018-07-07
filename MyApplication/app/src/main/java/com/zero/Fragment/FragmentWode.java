package com.zero.Fragment;


import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zeroc.myapplication.R;
import com.example.zeroc.myapplication.bianjiActivity;
import com.example.zeroc.myapplication.liwuActivity;
import com.example.zeroc.myapplication.pinglunActivity;
import com.example.zeroc.myapplication.shezhiActivity;
import com.example.zeroc.myapplication.yanyiActivity;

import java.util.Collections;
import java.util.List;

import static com.example.zeroc.myapplication.bianjiActivity.name;

public class FragmentWode extends Fragment implements View.OnClickListener{


    private Button fankui;
    private Button fenxiang;
    private ImageButton pinglun;
    private ImageButton yanyi;
    private ImageButton liwu;
    private TextView bianji;
    private TextView shezhi;
    private TextView YYphone;
    private TextView attention;
    private TextView fans;
    public static ImageView image;
    private TextView username;
    public static int yyphone;
    public static int attentions=0;
    public static int fanss=0;
    private Dialog dialog;
    private View inflate;
    public static final int FILL_PARENT = -1;
    public static final int MATCH_PARENT = -1;
    public static final int WRAP_CONTENT = -2;

    private void show(){

        dialog = new Dialog(getContext(),R.style.CustomDialogTheme);//填充对话框的布局
        inflate = LayoutInflater.from (getContext()).inflate(R.layout.dialog_share, null);
        //初始化控件
        TextView qq = (TextView) inflate.findViewById(R.id.share_qq);
        TextView wx = (TextView) inflate.findViewById(R.id.share_wx_chat);
        TextView yy = (TextView) inflate.findViewById(R.id.share_yy);
        TextView copy = (TextView) inflate.findViewById(R.id.share_copy);
        TextView cancel=(TextView)inflate.findViewById(R.id.share_cancel);
        qq.setOnClickListener(this);
        wx.setOnClickListener(this);
        yy.setOnClickListener(this);
        copy.setOnClickListener(this);
        cancel.setOnClickListener(this);

        //将布局设置给Dialog
        dialog.setContentView(inflate);

        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity( Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
        dialogWindow.setLayout(-1,-2);//设置宽高
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.share_qq:
                openApp("mobileqq");
                break;
            case R.id.share_wx_chat:
                openApp("com.tencent.mm");
                break;
            case R.id.share_yy:

                break;

            case R.id.share_copy:
                Intent share_intent = new Intent();

                share_intent.setAction(Intent.ACTION_SEND);

                share_intent.setType("text/plain");

                share_intent.putExtra(Intent.EXTRA_SUBJECT, "f分享");

                share_intent.putExtra(Intent.EXTRA_TEXT, "HI 推荐您使用一款软件:" + "演绎秀");

                share_intent = Intent.createChooser(share_intent, "分享");

                startActivity(share_intent);
                break;
            case R.id.share_cancel:
                dialog.dismiss();
        }
    }

    private void openApp(String str) {

        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory((Intent.CATEGORY_LAUNCHER));
        PackageManager packageManager = getContext().getPackageManager();
        List<ResolveInfo> mAllapps = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(mAllapps, new ResolveInfo.DisplayNameComparator(packageManager));


        for (ResolveInfo res : mAllapps) {
            String pkg = res.activityInfo.packageName;
            String cls = res.activityInfo.name;
            if (pkg.contains(str)) {
                ComponentName componentName = new ComponentName(pkg, cls);
                Intent intent1 = new Intent();
                intent1.setComponent(componentName);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(intent1);


            }
        }
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        fankui = (Button) view.findViewById(R.id.fankuiid);
        fenxiang=(Button)view.findViewById(R.id.fenxiangid);
        pinglun = (ImageButton) view.findViewById(R.id.pinglunid);
        yanyi=(ImageButton)view.findViewById(R.id.yanyiid);
        liwu=(ImageButton)view.findViewById(R.id.liwuid);
        bianji=(TextView)view.findViewById(R.id.bianjiid);
        shezhi=(TextView)view.findViewById(R.id.shezhiid);
        fans=(TextView)view.findViewById(R.id.fans);
        YYphone=(TextView)view.findViewById(R.id.YYphone);
        attention=(TextView)view.findViewById(R.id.attention);
        username=(TextView)view.findViewById(R.id.username);
        image=(ImageView) view.findViewById(R.id.imageid);


        yyphone=(int)((Math.random()*9+1)*100000);
        YYphone.setText(""+yyphone);
        attention.setText(""+attentions);
        fans.setText(""+fanss);


        pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(),pinglunActivity.class);
                startActivity(intent);

            }
        });

       yanyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),yanyiActivity.class);
                startActivity(intent);
            }
        });

        liwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),liwuActivity.class);
                startActivity(intent);
            }
        });

        bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(),bianjiActivity.class);
                startActivity(intent);

            }
        });

        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),shezhiActivity.class);
                startActivity(intent);
            }
        });

        fankui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:15116183734"));
                startActivity(intent);

            }
        });

        fenxiang.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                show();
//                openApp("mobileqq");
            }
        });


        return view;

    }



    public void onStart() {
        super.onStart();

        username.setText("" + name);
    }


}







