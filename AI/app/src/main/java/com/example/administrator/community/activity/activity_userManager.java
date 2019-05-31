package com.example.administrator.community.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.community.R;
import com.example.administrator.community.adapter.User_Adapter;
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
 * Created by Administrator on 2019/5/15.
 */

public class activity_userManager extends Activity {

    private ListView listView;
    OkHttpClient client = new OkHttpClient();
    private List<User> userList = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            userList = (List<User>)msg.obj;
            listView.setAdapter(new User_Adapter(activity_userManager.this,userList));
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_usermanager);

        listView = (ListView)findViewById(R.id.ll_list_user);


    }
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
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String uid = jsonObject.optString("uid",null);
                String username = jsonObject.optString("username",null);
                String upassword = jsonObject.optString("upassword",null);
                String uname = jsonObject.optString("uname",null);
                User user = new User(uid,username,upassword,uname);
                userList.add(user);
            }
            return  userList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
