package com.example.administrator.community.activity;

import android.app.Activity;;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.SharedPreferencesUtil;
import com.example.administrator.community.bean.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/11/22 0022.
 */

public class activity_login extends Activity {
    private  List<User> userList = new ArrayList<>();
    private SharedPreferencesUtil su;
    OkHttpClient client = new OkHttpClient();
    private Button bt_login;
    private TextView bt_register;
    private TextView tv_forget;
    private EditText et_getphone;
    private EditText et_getpassword;
    private CheckBox cb_box;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            userList = (List<User>)msg.obj;
        }
    };

    /*json数据解析*/
    private String getResuse(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public void getData(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = getResuse("http://62.234.17.94:8080/user/getAll");
                    System.out.println("================解析成功============");
                    Message message = Message.obtain();
                    message.obj = analyzeJSONArray(result);
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    private List<User> analyzeJSONArray(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            System.out.println("=========开始获取值=================");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String uid = jsonObject.optString("uid",null);
                String username = jsonObject.optString("username",null);
                String upassword = jsonObject.optString("upassword",null);
                String uname = jsonObject.optString("uname",null);

                User user = new User(uid,username,upassword,uname);
                userList.add(user);
            }
            System.out.println("------------------------------------"+userList);
            return  userList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*json数据解析*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setContentView(R.layout.layout_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        cb_box = (CheckBox)findViewById(R.id.cb_box);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_register = (TextView) findViewById(R.id.bt_register);
        tv_forget = (TextView) findViewById(R.id.tv_forget);
        et_getphone = (EditText)findViewById(R.id.et_getphone);
        et_getpassword = (EditText)findViewById(R.id.et_getpassword);

        su = SharedPreferencesUtil.getInstance(getApplicationContext());


        boolean isremember = pref.getBoolean("cb_box",false);
        if(isremember){
            //将账号和密码全部设置到文本框中
            String phone = pref.getString("phone","");
            String password = pref.getString("password","");
            et_getphone.setText(phone);
            et_getpassword.setText(password);
            cb_box.setChecked(true);
        }


        tv_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_forget.class);
                startActivity(intent);
            }
        });

        //注册
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_register.class);
                startActivity(intent);

            }
        });
        //登录
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = et_getphone.getText().toString().intern();
                String password = et_getpassword.getText().toString().intern();
                System.out.println("======success===========");
                if(phone.equals("admin")&&password.equals("admin")){
                    Intent intent = new Intent(activity_login.this,activity_admin.class);
                    String uname = "admin";
                    su.setValue("uname",uname);
                    startActivity(intent);
                }
                if (!phone.equals("")&&!password.equals("")){
                    System.out.println("==========success1=========");
                    System.out.println(userList.size());
                    System.out.println(userList);
                    for(int i=0;i<userList.size();i++){
                        System.out.println("=========success2==========");
                        if(userList.get(i).getUsername().equals(phone)&&userList.get(i).getUpassword().equals(password)){
                            Toast.makeText(activity_login.this,"登陆成功",Toast.LENGTH_SHORT).show();
                            System.out.println("======success===success========");
                            Intent intent = new Intent(activity_login.this,MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("uname",userList.get(i).getUname());
                            String test = userList.get(i).getUname();
                            String test1 = userList.get(i).getUsername();
                            su.setValue("test",test);
                            su.setValue("test1",test1);

                            System.out.println("000000000000000000000000000"+test+"0000000000000000000000");
                            su.getValue("test");
                            System.out.println("hahahahaha"+su.getValue("test"));
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    }
                    editor = pref.edit();
                    if(cb_box.isChecked()){
                        editor.putBoolean("cb_box",true);
                        editor.putString("phone",phone);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                }else if(phone.equals("")||password.equals("")){
                    Toast.makeText(activity_login.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(activity_login.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}