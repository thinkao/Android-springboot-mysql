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
 * Created by Administrator on 2018/11/25 0025.
 */

public class activity_head extends Activity {
    private TextView tv_erweima;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_head);
        tv_erweima = (TextView)findViewById(R.id.tv_erweima);

        tv_erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_head.this,activity_erwei.class);
                startActivity(intent);
            }
        });
    }
}
