package com.zero.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.AlphabeticIndex;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zero°c on 2018/3/12.
 */

public class DBManager {
    //声明类型
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context){
        dbHelper=new DatabaseHelper(context);     //dbHelper
    }

    public void add(Record record) {
        record.setId(UUID.randomUUID().toString());
        db = dbHelper.getWritableDatabase();
        db.beginTransaction();  //开始事务
        try {
            db.execSQL("INSERT INTO Record VALUES(?, ?, ?, ?)", new Object[]{record.getId(), record.getPath(), record.getSecond(), record.isPlayed() ? 0 : 1});
            db.setTransactionSuccessful();  //设置事务成功完成
        }
        catch (Exception e){
            //捕获异常
        }
        finally {
            db.endTransaction();    //结束事务
            db.close();
            Log.e("ljb", "sqlite7 " );
        }
//        Log.e("ljb", "添加数据库成功："+record.toString());
    }

    public void updateRecord(Record record) {
        db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("isPlayed", record.isPlayed() ? 0 : 1);
        db.update("record", cv, "id = ?", new String[]{record.getId()});
        db.close();

    }

    public List<Record> query() {

        ArrayList<Record> records = new ArrayList<Record>();
        Cursor c = queryTheCursor();
        while (c.moveToNext()) {
            Record record = new Record();
            record.setId(c.getString(c.getColumnIndex("id")));
            record.setPath(c.getString(c.getColumnIndex("path")));
            record.setSecond(c.getInt(c.getColumnIndex("second")));
            record.setPlayed(c.getInt(c.getColumnIndex("isPlayed"))==0?true:false);
            records.add(record);
        }
        c.close();
        return records;
    }

    public Cursor queryTheCursor() {
        Cursor c = db.rawQuery("SELECT * FROM record", null);
        return c;
    }

    //登录
    public boolean login(String username,String password){

        SQLiteDatabase sdb=dbHelper.getReadableDatabase(); //返回一个可对数据库进行操作的对象

        String sql="select * from user where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql,new String[]{username,password});//执行select语句
        if (cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
                return false;
    }
    //注册
    public boolean register(User user){
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();   //可供操作数据库的对象
        String sql="insert into user(username,password)values(?,?)";
        Object obj[]={user.getUsername(),user.getPassword()};
        sdb.execSQL(sql,obj);
        sdb.close();
        return true;
    }

}

