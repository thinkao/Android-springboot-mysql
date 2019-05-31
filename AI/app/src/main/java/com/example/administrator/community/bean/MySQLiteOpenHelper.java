package com.example.administrator.community.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.LinkedList;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2019/5/15.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static Integer Version = 1;//数据库版本号
    public static final String DB_NAME = "Grade";//数据库名
    private static final String CREATE_RECORD_DB = "create table grade("
            +"context text, "
            +"time date, "
            +"num text)";


    /**
     * 构造函数
     * 在SQLiteOpenHelper的子类中，必须有该构造函数
     */

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        // 参数说明
        // context：上下文对象
        // name：数据库名称
        // param：一个可选的游标工厂（通常是 Null）
        // version：当前数据库的版本，值必须是整数并且是递增的状态

        // 必须通过super调用父类的构造函数

        super(context, name, factory, version);
    }
    public MySQLiteOpenHelper(Context context,String name,int version)
    {
        this(context,name,null,version);
    }

    public MySQLiteOpenHelper(Context context,String name)
    {
        this(context, name, Version);
    }



    /**
     * 复写onCreate（）
     * 调用时刻：当数据库第1次创建时调用
     * 作用：创建数据库 表 & 初始化数据
     * SQLite数据库创建支持的数据类型： 整型数据、字符串类型、日期类型、二进制
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("创建数据库和表");
        //创建了数据库并创建一个叫records的表
        //SQLite数据创建支持的数据类型： 整型数据，字符串类型，日期类型，二进制的数据类型
        //String sql = "create table user(id int primary key,name varchar(200))";
        //execSQL用于执行SQL语句
        //完成数据库的创建
        db.execSQL(CREATE_RECORD_DB);//执行sql语句
        //数据库实际上是没有被创建或者打开的，直到getWritableDatabase() 或者 getReadableDatabase() 方法中的一个被调用时才会进行创建或者打开


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 参数说明：
        // db ： 数据库
        // oldVersion ： 旧版本数据库
        // newVersion ： 新版本数据库

        // 使用 SQL的ALTER语句
        /*String sql = "alter table person add sex varchar(8)";
        db.execSQL(sql);*/

        System.out.println("更新数据库版本为："+newVersion);

    }
    public void addRecord(Grade grade){//添加记录
        SQLiteDatabase db = this.getWritableDatabase();//获取数据库
        ContentValues values = new ContentValues();//准备传入数据
        values.put("context",grade.getContext());
        values.put("time", grade.getTime());
        values.put("num",grade.getNum());
        db.insert(DB_NAME,null,values);
        //values.clear();
        Log.d(TAG,grade.getContext()+" added");
    }
   /* public void editRecord(String uuid,RecordBean record){//编辑记录
        removeRecord(uuid);
        record.setUuid(uuid);
        addRecord(record);
    }*/

    public LinkedList<Grade> readRecords(String dateStr){//用链表来储存账目
        LinkedList<Grade> grades = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();//获取当前数据库
        Cursor cursor = db.rawQuery("select * from grade",null);
        if(cursor.moveToFirst()){
            do{
                String context = cursor.getString(cursor.getColumnIndex("context"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                String num = cursor.getString(cursor.getColumnIndex("num"));
                Grade grade = new Grade(context,time,num);
                grade.setContext(context);
                grade.setTime(time);
                grade.setNum(num);
                grades.add(grade);//添加到列表
                System.out.println("===================================="+grades);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return grades;
    }

   /* public LinkedList<String> getGrade(){//返回有记账记录的日期，用链表来存储，以便显示记账
        LinkedList<String> dates = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT * from Record order by date asc",new String[]{});
        if(cursor.moveToFirst()){//利用游标进行遍历
            do{
                String date = cursor.getString(cursor.getColumnIndex("date"));
                if(!dates.contains(date)){//每个日期只出现一次
                    dates.add(date);
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        return dates;
    }*/
}
