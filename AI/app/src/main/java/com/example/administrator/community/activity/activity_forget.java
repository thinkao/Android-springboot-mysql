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
 * Created by Administrator on 2018/11/24 0024.
 */

public class activity_forget extends Activity {
    private Button bt_email;
    private Button bt_message;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        bt_email = (Button)findViewById(R.id.bt_email);
        bt_message = (Button)findViewById(R.id.bt_message);

        bt_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_forget.this,activity_forgetone.class);
                startActivity(intent);
            }
        });
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_forget.this,activity_forgettwo.class);
                startActivity(intent);
            }
        });
    }
}
