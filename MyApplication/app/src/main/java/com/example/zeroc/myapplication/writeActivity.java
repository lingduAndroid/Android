package com.example.zeroc.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zero.news.ActivityCollector;

public class writeActivity extends AppCompatActivity {
    private Button sendnotice;
    private Button canclenotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        ActivityCollector.addActivity(this);
        sendnotice = (Button) findViewById(R.id.send_notice);
        canclenotice = (Button) findViewById(R.id.cancle_notice);


        sendnotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyFirstNotification();

            }
        });

        canclenotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.cancel(1);
            }
        });

}

    private void notifyFirstNotification() {
        //点击事件
        Intent intent = new Intent(this, shouyeActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 0, intent, 0);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("演绎秀")
                .setContentText("演绎秀给你发送了一条通知")
                .setContentIntent(pendingIntent)//点击事件
                .setAutoCancel(true) // 设置点击通知之后通知是否消失
                .setWhen(System.currentTimeMillis()) //设定通知显示的时间
                .setLights(Color.BLUE, 2000, 1000)//设置手机的LED灯为蓝色并且灯亮2秒，熄灭1秒
                .setVibrate(new long[]{1000, 0, 1000})//震动，数组内基数震动时间，偶数停止时间
                .setSmallIcon(R.drawable.yan)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))  //转化为Bitmap型
                .build();
        //RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        //.setContent(remoteViews) // 通过设置RemoteViews对象来设置通知的自定义布局

        /*
        * 使用从系统服务获得的通知管理器发送通知，第一个参数是通知的id，不同的通知应该有不同的id，
         * 这样当我们要取消哪条通知的时候我们调用notificationManager（通知管理器）.cancel(int id)
         * 方法并传入发送通知时的对应id就可以了。在这里如果我们要取消这条通知，
         * 我们调用manager.cancel(1);就可以了
                * 第二个参数是要发送的通知对象
                *  */
        manager.notify(1, notification);
    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }


}


