package com.example.xhs;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database_a extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);
        //创建数据库的操作
        dbHelper = new DatabaseHelper(this,
                "BookStore.db",
                null,
                1);
        Button createDatabase = (Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击创建数据库操作
                dbHelper.getWritableDatabase();
            }
        });
        Button addButton = (Button)findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.name);
                String nameText = name.getText().toString();

                EditText zhanghao = (EditText)findViewById(R.id.zhanghao);
                String zhanghaoText = zhanghao.getText().toString();

                EditText mima = (EditText)findViewById(R.id.mima);
                String mimaText = mima.getText().toString();
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                ContentValues Valuse = new ContentValues();
                Valuse.put("name",nameText);
                Valuse.put("zhanghao",zhanghaoText);
                Valuse.put("mima",mimaText);
                db.insert("zhuce",null,Valuse);
                Valuse.clear();
                Toast.makeText(Database_a.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
