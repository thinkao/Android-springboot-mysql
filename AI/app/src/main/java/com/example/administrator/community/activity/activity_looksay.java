package com.example.administrator.community.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.SharedPreferencesUtil;

/**
 * Created by Administrator on 2019/5/6.
 */

public class activity_looksay extends Activity {
    private SharedPreferencesUtil su;
    private TextView tv_texts;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        su = SharedPreferencesUtil.getInstance(getApplicationContext());
        setContentView(R.layout.layout_looksay);
        tv_texts = (TextView)findViewById(R.id.tv_texts);

        String texts = su.getValue("text");
        tv_texts.setText(texts);
    }
}
