package com.example.xhs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text"
            +")";
    public static final String CREATE_CATEGORY = "create table Category("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";
    public static final String test = "create table test(" +
            "id integer primary key autoincrement," +
            "remark text," +
            "k integer)";
    private Context mContext;
    public DatabaseHelper(
            Context context,
            String name,
            SQLiteDatabase.CursorFactory factory,
            int version){
        super(context,name,factory,version);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //execute执行 SQL
        //创建数据库
        db.execSQL(CREATE_BOOK);//第一张表
        db.execSQL(CREATE_CATEGORY);//第二张表
        db.execSQL(test);
        Toast.makeText(mContext,"数据库创建成功！",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
        //如果表存在则删除以后重新创建
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        db.execSQL("drop table if exists test");
        //执行创建动作
        onCreate(db);
    }
}
