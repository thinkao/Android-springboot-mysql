package com.example.administrator.community.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.administrator.community.R;
import com.example.administrator.community.adapter.Collect_Adapter;
import com.example.administrator.community.bean.Collect;

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

public class activity_collect extends Activity {
    private ListView listView;
    OkHttpClient client = new OkHttpClient();
    private List<Collect> collectList = new ArrayList<>();
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            collectList = (List<Collect>)msg.obj;
            listView.setAdapter(new Collect_Adapter(activity_collect.this,collectList));
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setContentView(R.layout.layout_mybaby);
        listView = (ListView)findViewById(R.id.ll_list_collect);
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
                    String result = getResuse("http://62.234.17.94:8080/collect/getAll");
                    Message message = Message.obtain();
                    message.obj = analyzeJSONArray(result);
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private List<Collect> analyzeJSONArray(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.optString("cid",null);
                String context = jsonObject.optString("context",null);
                String time = jsonObject.optString("time",null);
                Collect collect = new Collect(id,context,time);
                collectList.add(collect);
            }
            return  collectList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
