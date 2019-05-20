package com.example.msi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OptionsDatabase extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_view);
        //创建数据库的操作
        dbHelper = new MyDatabaseHelper(this,
                "BookStore.db",
                null,
                4);
        Button createDatabase = (Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击创建数据库操作
                dbHelper.getWritableDatabase();
            }
        });

        //添加书目
        Button addButton = (Button)findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText zuozhe = (EditText)findViewById(R.id.zuozhe);
                String zuozheText = zuozhe.getText().toString();

                EditText shuming = (EditText)findViewById(R.id.shuming);
                String shumingText = shuming.getText().toString();

                EditText jiage = (EditText)findViewById(R.id.jiage);
                String jiageText = jiage.getText().toString();

                EditText yeshu = (EditText)findViewById(R.id.yeshu);
                String yeshuText = yeshu.getText().toString();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name",shumingText);
                values.put("author",zuozheText);
                values.put("price",jiageText);
                values.put("pages",yeshuText);
                db.insert("Book",null,values);
                values.clear();
                Toast.makeText(OptionsDatabase.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });
        //查询书目列表
        Button chaxunButton = (Button)findViewById(R.id.chaxun);
        chaxunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book",null,
                        null,null,null,null,null);
                if (cursor.moveToFirst()){
                    //先执行一次再循环
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("***",name);
                        Log.d("***",author);
                        Log.d("***",pages + "");
                        Log.d("***",price + "");
                    }while (cursor.moveToNext());
                    //关闭连接
                    cursor.close();
                }
            }
        });

    }
}
