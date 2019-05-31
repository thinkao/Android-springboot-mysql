package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.community.R;
import com.example.administrator.community.adapter.Collect_Adapter;
import com.example.administrator.community.adapter.Music_Adapter;
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
 * Created by Administrator on 2018/11/25 0025.
 */

public class activity_music extends Activity {
    OkHttpClient client = new OkHttpClient();
    private List<Collect> musicList = new ArrayList<>();
    private ListView listView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_music);
        listView = (ListView) findViewById(R.id.lv_music);


    }
}
