package com.zero.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zero°c on 2018/3/12.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    static String name ="user.db";
    static int dbversion=1;

   public DatabaseHelper(Context context)
    {
        super(context,name, null, dbversion);
    }
    //创建一个数据库

    @Override
    public void onCreate(SQLiteDatabase db) {
       //创建一个名为user的表
        String sql="create table user(id integer primary Key autoincrement,username varchar(20),password varchar(20),age integer,sex varchar(2))";
        //执行建表语句
        db.execSQL(sql);
//        db.execSQL( "create table luying(id varchar(225), path varchar(225), second int, isPlayed int)");//0:true,1：false);
        db.execSQL("create table Record(id varchar(225), path varchar(225), second int, isPlayed int)");//0:true,1：false);

    }
//数据库升级

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS Record");
        onCreate(db);
    }
}
