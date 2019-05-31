package com.example.administrator.community.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.administrator.community.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Administrator on 2018/11/25 0025.
 */

public class activity_interest extends Activity {
    public static final int TAKE_PHOTO = 1;
    private ImageView iv_picture;
    private Uri imageUri;
    private Button bt_photo;
    private ScrollView sv_interest;
    private LinearLayout ll_interest;
    private ImageView iv_interest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_interest);
        bt_photo = (Button) findViewById(R.id.bt_photo);
        iv_picture = (ImageView) findViewById(R.id.iv_picture);
        sv_interest = (ScrollView)findViewById(R.id.sv_interest);
        ll_interest = (LinearLayout)findViewById(R.id.ll_interest);
        iv_interest = (ImageView)findViewById(R.id.iv_interest);


        bt_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outputImage = new File(activity_interest.this.getExternalCacheDir(), "output_image.jpg");
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    imageUri = FileProvider.getUriForFile(activity_interest.this, "com.example.cameraalbumtest.fileprovider", outputImage);
                } else {
                    imageUri = Uri.fromFile(outputImage);
                }
                //启动相机程序
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PHOTO);
            }
        });
    }
        @Override
        public void onActivityResult(int requestCode,int resultCode,Intent data){
            switch (requestCode){
                case TAKE_PHOTO:
                    if(requestCode==RESULT_OK){
                        try {
                            //将拍摄的照片显示出来
                            Bitmap bitmap = BitmapFactory.decodeStream(activity_interest.this.getContentResolver().openInputStream(imageUri));
                            iv_picture.setImageBitmap(bitmap);
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        public void onClick(View view){
            switch (view.getId()){
                case R.id.iv_interest:
                    int sv_interestHeight = sv_interest.getHeight();
                    int sv_interestWidth = sv_interest.getWidth();
                    iv_interest.setImageResource(Integer.parseInt("高度为："+sv_interestHeight+"宽度为"+sv_interestWidth));
                    break;
                case  R.id.ll_interest:
                    //sv_interest.scrollTo(0,1000);//滚动时候是瞬间滚动过去
                    //sv_interest.scrollBy(0,1000);//滚动时候是瞬间的，设置便宜量，在当前的位置基础上便宜设置的数值
                    //sv_interest.smoothScrollTo(0,1000);//滚动时候是平缓的而不是立即滚动到某处
                    //sv_interest.smoothScrollBy(0,1000);//滚动时候是平缓，在当前的位置基础上偏移设置的数值
                    break;
            }
        }


}
