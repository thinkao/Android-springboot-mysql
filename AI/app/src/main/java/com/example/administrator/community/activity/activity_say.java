package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.administrator.community.R;

/**
 * Created by Administrator on 2018/11/23 0023.
 */

public class activity_say extends Activity {
    private View view;
    private Button bt_user;
    private Button bt_nouser;
    private Button bt_looksay;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_say);

        bt_user = (Button)findViewById(R.id.bt_user);
        bt_nouser = (Button)findViewById(R.id.bt_nouser);
        bt_looksay = (Button)findViewById(R.id.bt_looksay);

        bt_looksay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_say.this,activity_looksay.class);
                startActivity(intent);
            }
        });

        bt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_say.this,activity_sayone.class);
                startActivity(intent);
            }
        });
        bt_nouser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_say.this,activity_saytwo.class);
                startActivity(intent);
            }
        });

    }
}
