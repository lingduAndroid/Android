package com.example.before;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeroc.myapplication.R;
import com.zero.news.ActivityCollector;
import com.zero.SQLite.DatabaseHelper;
import com.zero.SQLite.User;
import com.zero.SQLite.DBManager;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zero°c on 2018/3/8.
 */

public class ZCActivity extends AppCompatActivity {

    private Button huoqu;
    private Button wanchengzhuce;
    private DatabaseHelper dHeleper;
    private EditText phone;
    private EditText mima;
    private TextView test;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce);
        ActivityCollector.addActivity(this);


        test=(TextView)findViewById(R.id.Text) ;
        huoqu = (Button) findViewById(R.id.huoqu);
        wanchengzhuce = (Button) findViewById(R.id.wanchengzhuce);
        dHeleper = new DatabaseHelper(ZCActivity.this );
        phone = (EditText) findViewById(R.id.shoujihao);
        mima = (EditText) findViewById(R.id.mima);



        huoqu.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {

                                     }
                                 }
        );

        wanchengzhuce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        SQLiteDatabase db=dHeleper.getWritableDatabase();
                        ContentValues values=new ContentValues();
                        /**
                         * 注册逻辑
                         * 两个参数
                         */
                        String phoneNumber = String.valueOf(phone.getText());
                        String passWord = String.valueOf(mima.getText());
                        User newUser = new User(phoneNumber,passWord);
                        DBManager DBManager = new DBManager(ZCActivity.this);

                        Boolean zhuceuser = DBManager.register(newUser);
                       sendRequestWithOKHttp();//
                       Toast.makeText(ZCActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//                       finish();


                    }
                }
        );

    }
    private void sendRequestWithOKHttp(){

        new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RequestBody requestBody =new FormBody.Builder()
                            .add("username","phoneNumber")
                            .add("password","passWord")
                            .build();

                    OkHttpClient client =new OkHttpClient();
                    Request request=new Request.Builder()
                            .url("http://47.106.102.202/get_data.xml")
                            .post(requestBody)
                            .build();
                    Response response =client.newCall(request).execute();
                    String respomseData=response.body().string();
                    showResponse(respomseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
    private void showResponse (final String responce){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                test.setText(responce);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        //删除该活动
        ActivityCollector.removeActivity(this);
    }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("ljb", "获取验证码2222");
//                HttpURLConnection connection = null;
//                BufferedReader reader = null;
//                Log.e("ljb", "获取验证码2");
//                try {
//                    Log.e("ljb", "获取验证码1");
//                    URL url = new URL("http://www.baidu.com");
//                     connection = (HttpURLConnection) url.openConnection();
//                     connection.setRequestMethod("POSget_data.xmlT");//服务器中写入数据
//                    DataOutputStream out =new DataOutputStream(connection.getOutputStream());
//                    out.writeBytes("username=phoneNumber&password=passWord");
//
//                    connection.setRequestMethod("GET");//获取
//                    connection.setConnectTimeout(8000);
//                    connection.setReadTimeout(8000);
//                    InputStream in =connection.getInputStream();//获取服务器返回的输入流
//                    //对输入流读取
//                    reader=new BufferedReader(new InputStreamReader(in));
//                    StringBuilder response =new StringBuilder();
//                    String line;
//                    Log.e("ljb", "run: " );
//                    while((line=reader.readLine())!=null){
//                        response.append(line);
//                    }
//                    showResponce(response.toString());
//                } catch (java.io.IOException e) {
//                    Log.e("ljb", "run: catch" );
//                    e.printStackTrace();
//                }finally {
//                    if(reader!=null) {
//                        try {
//                            reader.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if(connection!=null){
//                        connection.disconnect();
//                    }
//                }
//            }
//        });
//        }
//

}

