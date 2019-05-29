package com.example.xhs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Index extends AppCompatActivity implements View.OnClickListener {
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        Button goto_login = (Button)findViewById(R.id.goto_login);
        goto_login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goto_login:
                //跳转到登录界面
                Intent i = new Intent(Index.this,Login.class);
                startActivity(i);
                break;
            case R.id.user_g:
                //跳转到登录界面
                Intent j = new Intent(Index.this,Database_a.class);
                startActivity(j);
                break;

        }
    }
    /**
     * 存储数据
     */
    public void save(String data) {
        //String data = "hello android!";
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            //data表示存储文件的名称，MODE_PRIVATE表示存储方式为私有
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}