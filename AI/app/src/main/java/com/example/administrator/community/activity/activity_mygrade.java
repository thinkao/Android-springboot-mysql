package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.community.R;

import com.example.administrator.community.adapter.Grade_Adapter;
import com.example.administrator.community.bean.Grade;
import com.example.administrator.community.bean.MySQLiteOpenHelper;
import com.example.administrator.community.bean.SharedPreferencesUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/11/22 0022.
 */

public class activity_mygrade extends Activity {
    private ScrollView sv_grade;
    private ImageView iv_grade;
    private SharedPreferencesUtil su;
    OkHttpClient client = new OkHttpClient();
    private ListView lv_grade;
    private List<Grade> gradeList = new ArrayList<>();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            gradeList = (List<Grade>)msg.obj;
            lv_grade.setAdapter(new Grade_Adapter(activity_mygrade.this,gradeList));
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        su = SharedPreferencesUtil.getInstance(getApplicationContext());
        getData();
        setContentView(R.layout.layout_mygrade);
        lv_grade = (ListView) findViewById(R.id.lv_grade);
        TextView tv_grade = (TextView) findViewById(R.id.tv_grade);
        sv_grade = (ScrollView) findViewById(R.id.sv_grade);
        iv_grade = (ImageView)findViewById(R.id.iv_grade);

        String ok1 = su.getValue("grade");
        System.out.println("传入的值为" + ok1);
        tv_grade.setText(ok1);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_interest:
                int sv_interestHeight = sv_grade.getHeight();
                int sv_interestWidth = sv_grade.getWidth();
                iv_grade.setImageResource(Integer.parseInt("高度为："+sv_interestHeight+"宽度为"+sv_interestWidth));
                break;
            case  R.id.ll_interest:
                //sv_interest.scrollTo(0,1000);//滚动时候是瞬间滚动过去
                //sv_interest.scrollBy(0,1000);//滚动时候是瞬间的，设置便宜量，在当前的位置基础上便宜设置的数值
                //sv_interest.smoothScrollTo(0,1000);//滚动时候是平缓的而不是立即滚动到某处
                //sv_interest.smoothScrollBy(0,1000);//滚动时候是平缓，在当前的位置基础上偏移设置的数值
                break;
        }
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
                    String result = getResuse("http://62.234.17.94:8080/grade/getAll");
                    Message message = Message.obtain();
                    message.obj = analyzeJSONArray(result);
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    private List<Grade> analyzeJSONArray(String data) {
        try {
            JSONArray jsonArray = new JSONArray(data);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String context = jsonObject.optString("context",null);
                String time = jsonObject.optString("time",null);
                String num =  jsonObject.optString("num",null);
                Grade grade = new Grade(context,time,num);
                gradeList.add(grade);
            }
            int grade = 0;
            for(int i=0;i<gradeList.size();i++){
                String a = gradeList.get(i).getNum();
                int b = Integer.valueOf(a);
                grade = b + grade;
                String ok = String.valueOf(grade);
                su.setValue("grade",ok);
                System.out.println("最终的grade为："+grade);
            }



            return  gradeList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gradeList;
    }
}
