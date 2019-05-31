package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.community.R;
import com.example.administrator.community.adapter.Grade_Adapter;
import com.example.administrator.community.bean.Grade;
import com.example.administrator.community.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/11/24 0024.
 */

public class activity_register extends Activity{
    OkHttpClient client = new OkHttpClient();
    private Button bt_register1;
    private TextView tv_haveuser;
    private EditText et_user1;
    private EditText et_name;
    private EditText et_password1;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        bt_register1 = (Button)findViewById(R.id.bt_register1);
        tv_haveuser = (TextView)findViewById(R.id.tv_haveuser);
        et_user1 = (EditText)findViewById(R.id.et_user1);
        et_password1 = (EditText) findViewById(R.id.et_password1);
        et_name = (EditText)findViewById(R.id.et_name);


        bt_register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString().intern();
                String phone = et_user1.getText().toString().intern();
                String pass = et_password1.getText().toString().intern();

                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            getResuse(name,phone,pass);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();


                Toast.makeText(activity_register.this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_register.this,activity_login.class);
                startActivity(intent);
            }
        });

        tv_haveuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this,activity_login.class);
                startActivity(intent);
            }
        });
    }
    private String getResuse(String name,String phone,String pass) throws IOException {
        OkHttpClient client=new OkHttpClient();
        FormBody body=new FormBody.Builder().add("uname",name).add("username",phone).add("upassword",pass).build();
        Request request=new Request.Builder().url("http://62.234.17.94:8080/user/addUser").post(body).build();
        Response response=client.newCall(request).execute();
        String responseDate=response.body().string();
        return responseDate;

    }

}
