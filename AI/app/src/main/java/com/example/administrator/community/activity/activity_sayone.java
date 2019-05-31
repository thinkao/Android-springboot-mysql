package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.SharedPreferencesUtil;

/**
 * Created by Administrator on 2018/11/23 0023.
 */

public class activity_sayone extends Activity {
    private EditText et_say;
    private Button bt_say;
    private SharedPreferencesUtil su;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sayone);
        su = SharedPreferencesUtil.getInstance(getApplicationContext());

        et_say = (EditText)findViewById(R.id.et_say);
        bt_say = (Button)findViewById(R.id.bt_say);

        bt_say.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = et_say.getText().toString().intern();
                su.setValue("text",text);
                Toast.makeText(activity_sayone.this,"发送成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_sayone.this,activity_say.class);
                startActivity(intent);

            }
        });
    }
}
