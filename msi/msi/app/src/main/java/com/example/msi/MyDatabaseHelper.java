package com.example.msi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book("
        +"id integer primary key autoincrement,"
        +"author text,"+"price integer,"
        +"pages integer,"
        +"name text"
        +")";
    private Context mContext;
    /**
     *构造函数
     * @param context -- 上下文
     * @param name -- 表名称
     * @param factory -- 数据库连接池
     * @param version -- 版本--用于更新数据--自定义
     */
    public MyDatabaseHelper(
            Context context,
            String name,
            SQLiteDatabase.CursorFactory factory,
            int version){
        super(context,name,factory,version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext,"数据库创建成功",Toast.LENGTH_LONG).show();

    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
