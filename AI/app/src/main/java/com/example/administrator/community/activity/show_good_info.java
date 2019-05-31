package com.example.administrator.community.activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.community.R;

/**
 * Created by Administrator on 2018/11/23 0023.
 */

public class show_good_info extends AppCompatActivity{
    private TextView show_type;
    private TextView show_value;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_comment_show_good_info);
        show_type = (TextView)findViewById(R.id.show_type);
        show_value = (TextView)findViewById(R.id.value);
        Bundle bundle = this.getIntent().getExtras();
        show_type.setText(bundle.get("type").toString().intern());
        show_value.setText(bundle.get("value").toString().intern());
    }
}
