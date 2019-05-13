package com.example.icmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        //监听点击时间
        Button button = (Button)findViewById(R.id.getJsonData);
        button.setOnClickListener((View.OnClickListener) this);

    }

    //使用GSON解析json格式数据
    //1、请求该json数据所在的服务器
    private void sendRequestWithOKHttp(){
        Log.d("1","断点1");
        //进程编程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Log.d("2","断点2");
                    OkHttpClient client = new OkHttpClient();
                    //构建请求
                    Request request = new Request.Builder()
                            //指定要访问的服务器
                    .url("http://guolin.tech/api/china")
                    .build();
                //实例化返回对象
                Response response = client.newCall(request).execute();
                //获取到服务器返回的json格式数据
                 String responseData = response.body().string();
                 //调用解析函数
                 parseJsonWithGSON(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
     //2、解析

    private void parseJsonWithGSON(String jsonDate){
        Gson gson = new Gson();
        try {
            List<AppJsonDate> appList = (List<AppJsonDate>) gson.fromJson(jsonDate, new TypeToken<List<AppJsonDate>>() {
            }.getRawType());
            for (AppJsonDate a : appList) {
                Log.d("MainActivity", "id" + a.getId());
                Log.d("MainActivity", "name" + a.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    //接口方法
    public void  onClick(View v){
        switch (v.getId()){
            case  R.id.getJsonData:
                sendRequestWithOKHttp();
               break;
            //case R.id.get1:
              //  break;
            default:
                   break;
        }
    }
}
