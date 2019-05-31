package com.example.administrator.community.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.community.R;

/**
 * Created by Administrator on 2018/11/24 0024.
 */

public class activity_forgettwo extends Activity{
    private Button bt_forgettwo;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("haimeiyouchengg");
        setContentView(R.layout.layout_forgettwo);

        System.out.println("chenggongl");
        bt_forgettwo = (Button)findViewById(R.id.bt_forgettwo);


        bt_forgettwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_forgettwo.this,"您当前余额不足",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
