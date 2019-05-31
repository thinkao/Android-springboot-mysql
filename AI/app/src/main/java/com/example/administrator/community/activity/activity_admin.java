package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.SharedPreferencesUtil;

/**
 * Created by Administrator on 2019/5/15.
 */

public class activity_admin extends Activity {
    private Button bt_admin_tucao;
    private Button bt_test;
    private Button bt_admin_back;
    private Button bt_admin_user;
    private SharedPreferencesUtil su;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_admin);
        su = SharedPreferencesUtil.getInstance(getApplicationContext());


        bt_admin_back = (Button)findViewById(R.id.bt_admin_back);
        bt_admin_tucao = (Button)findViewById(R.id.bt_admin_tucao);
        bt_admin_user = (Button)findViewById(R.id.bt_admin_user);
        bt_test = (Button)findViewById(R.id.bt_test);



        bt_admin_tucao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_admin.this,activity_tucaoManager.class);
                startActivity(intent);
            }
        });
        bt_admin_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_admin.this,activity_userManager.class);
                startActivity(intent);
            }
        });
        bt_admin_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_admin.this,activity_login.class);
                startActivity(intent);
            }
        });
        bt_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_admin.this,activity_test.class);
                startActivity(intent);
            }
        });
    }
}
