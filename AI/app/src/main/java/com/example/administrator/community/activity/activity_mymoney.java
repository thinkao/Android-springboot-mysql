package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.community.R;

/**
 * Created by Administrator on 2018/11/22 0022.
 */

public class activity_mymoney extends Activity {
    private TextView tv_mymoney;
    private TextView tv_myyinhangka;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mymoney);

        tv_myyinhangka = (TextView)findViewById(R.id.tv_myyinhangka);
        tv_mymoney = (TextView)findViewById(R.id.tv_mymoney);

        tv_mymoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_mymoney.this,activity_money.class);
                startActivity(intent);
            }
        });
    }
}

