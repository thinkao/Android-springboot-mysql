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

public class activity_forgetone extends Activity{
    private Button bt_forgetone;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_forgetone);
        bt_forgetone = (Button)findViewById(R.id.bt_forgetone);

        bt_forgetone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_forgetone.this,"您不是VIP用户",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
