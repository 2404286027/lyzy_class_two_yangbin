package com.example.xhs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    //键值对存储对象
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    //编辑框
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button login;
    private Button userng;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        usernameEdit = (EditText)findViewById(R.id.user_name);
        passwordEdit = (EditText)findViewById(R.id.pass_word);
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);
        userng = (Button)findViewById(R.id.user_g);
        login = (Button)findViewById(R.id.login);
        //是否存储用户密码
        boolean isRemember = pref.getBoolean("remember_pass",false);
        if (isRemember){
            //存储
            String username = pref.getString("username","");
            String password = pref.getString("password","");
            //记住密码
            usernameEdit.setText(username);
            passwordEdit.setText(password);
            //默认被勾选
            rememberPass.setChecked(true);


        }
    }
}
