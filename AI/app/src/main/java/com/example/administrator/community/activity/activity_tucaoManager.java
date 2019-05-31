package com.example.administrator.community.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.SharedPreferencesUtil;

/**
 * Created by Administrator on 2019/5/15.
 */

public class activity_tucaoManager extends Activity {
    private TextView tv_text;
    private SharedPreferencesUtil su;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_admin_tucao);
        su = SharedPreferencesUtil.getInstance(getApplicationContext());

        tv_text = (TextView)findViewById(R.id.tv_text);
        String text = su.getValue("text");
        tv_text.setText(text);
    }
}
