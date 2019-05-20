package com.example.msi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    /**
     * 建表语句
     * integer = int 整型
     * text 文本
     * blob 二进制
     * real 小数
     */
    public static final String CREATE_BOOK = "create table Book("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text"
            +")";
    /**
     * 书的信息表
     */
    public static final String CREATE_CATEGORY = "create table Category("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";
    /**
     * test
     *
     * db.execSQL("drop table if exists Book");
     * db.execSQL("drop table if exists Category");
     * db.execSQL("drop table if exists test");
     */
    public static final String test = "create table test(" +
            "id integer primary key autoincrement," +
            "remark text," +
            "k integer)";
    private Context mContext;
    /**
     * 构造函数
     * @param context -- 上下文
     * @param name -- 库名称
     * @param factory -- 数据库连接池
     * @param version -- 版本--用于更新数据--自定义
     */
    public MyDatabaseHelper(
            Context context,
            String name,
            SQLiteDatabase.CursorFactory factory,
            int version){
        super(context,name,factory,version);
        mContext = context;
    }

    /**
     * 创建数据库和表
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //execute执行 SQL
        //创建数据库
        db.execSQL(CREATE_BOOK);//第一张表
        db.execSQL(CREATE_CATEGORY);//第二张表
        db.execSQL(test);
        Toast.makeText(mContext,"数据库创建成功！",Toast.LENGTH_LONG).show();
    }

    /**
     * 更新数据库
     * @param db -- 数据库(BookStore.db)
     * @param oldVersion -- 旧版本编号
     * @param newVersion -- 新版本编号
     */
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
