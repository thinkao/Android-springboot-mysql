package com.example.administrator.community.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.administrator.community.R;

import java.io.File;

/**
 * Created by Administrator on 2018/11/26 0026.
 */

public class activity_find extends Activity implements View.OnClickListener{
    private VideoView videoView;
    private ScrollView sv_find;
    private LinearLayout ll_find;
    private ImageView iv_find;
    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_find);
        videoView = (VideoView)findViewById(R.id.video_view);
        Button bt_play  = (Button)findViewById(R.id.bt_play);
        Button bt_pause = (Button)findViewById(R.id.bt_pause);
        Button bt_replay = (Button)findViewById(R.id.bt_replay);
        sv_find = (ScrollView)findViewById(R.id.sv_find);
        ll_find = (LinearLayout)findViewById(R.id.ll_find);
        iv_find = (ImageView)findViewById(R.id.iv_find);
        bt_play.setOnClickListener(this);
        bt_pause.setOnClickListener(this);
        bt_replay.setOnClickListener(this);
        if(ContextCompat.checkSelfPermission(activity_find.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity_find.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },1);
        }else {
            initVideoPath();//初始化VideoView
        }
    }
    private void initVideoPath(){
        File file = new File(Environment.getExternalStorageDirectory(),"/DCIM/Camera/AAA.mp4");
        videoView.setVideoPath(file.getPath());
    }


    public void onRequestPermissionResult(int requestCode,String [] permissions,int [] grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initVideoPath();
                }else {
                    Toast.makeText(this,"拒绝权限将无法使用程序",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
                default:
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bt_play:
                if(!videoView.isPlaying()){
                    videoView.start();
                }
                break;
            case R.id.bt_pause:
                if(videoView.isPlaying()){
                    videoView.pause();
                }
                break;
            case R.id.bt_replay:
                if(videoView.isPlaying()){
                    videoView.resume();
                }
                break;
        }
        switch (view.getId()){
            case R.id.iv_find:
                int sv_findHeight = sv_find.getHeight();
                int sv_findWidth = sv_find.getWidth();
                iv_find.setImageResource(Integer.parseInt("高度为："+sv_findHeight+"宽度为"+sv_findWidth));
                break;
            case  R.id.ll_find:
                //sv_interest.scrollTo(0,1000);//滚动时候是瞬间滚动过去
                //sv_interest.scrollBy(0,1000);//滚动时候是瞬间的，设置便宜量，在当前的位置基础上便宜设置的数值
                //sv_interest.smoothScrollTo(0,1000);//滚动时候是平缓的而不是立即滚动到某处
                //sv_interest.smoothScrollBy(0,1000);//滚动时候是平缓，在当前的位置基础上偏移设置的数值
                break;
        }
    }
    public void onDestroy(){
        super.onDestroy();
        if(videoView!=null){
            videoView.suspend();
        }

    }

}
