package com.example.administrator.community.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.administrator.community.R;

/**
 * Created by Administrator on 2018/11/25 0025.
 */

public class activity_movie extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_movie);
    }
}
