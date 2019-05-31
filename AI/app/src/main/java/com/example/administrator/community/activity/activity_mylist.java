package com.example.administrator.community.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.administrator.community.R;
import com.example.administrator.community.adapter.List_Adapter;
import com.example.administrator.community.bean.List_list;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/11/22 0022.
 */

public class activity_mylist extends Activity {
    private ListView listView;
    OkHttpClient client = new OkHttpClient();
    private List<List_list> listList = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            listList = (List<List_list>)msg.obj;
            listView.setAdapter(new List_Adapter(activity_mylist.this,listList));
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setContentView(R.layout.layout_mylist);
        listView = (ListView)findViewById(R.id.ll_list_list);

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
                    String result = getResuse("http://62.234.17.94:8080/list/getAll");
                    Message message = Message.obtain();
                    message.obj = analyzeJSONArray(result);
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private List<List_list> analyzeJSONArray(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String lid = jsonObject.optString("lid",null);
                String lcontext = jsonObject.optString("lcontext",null);
                String ltime = jsonObject.optString("ltime",null);
                List_list list_list = new List_list(lid,lcontext,ltime);
                listList.add(list_list);
            }
            return  listList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
