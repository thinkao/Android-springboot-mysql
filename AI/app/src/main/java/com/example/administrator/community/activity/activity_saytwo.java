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

public class activity_saytwo extends Activity {
    private EditText et_saytwo;
    private Button bt_saytwo;
    private SharedPreferencesUtil su;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        su = SharedPreferencesUtil.getInstance(getApplicationContext());
        setContentView(R.layout.layout_saytwo);

        et_saytwo = (EditText)findViewById(R.id.et_saytwo);
        bt_saytwo = (Button)findViewById(R.id.bt_saytwo);

        bt_saytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = et_saytwo.getText().toString().intern();
                su.setValue("text",text);
                Toast.makeText(activity_saytwo.this,"发送成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_saytwo.this,activity_say.class);
                startActivity(intent);

            }
        });
    }
}
