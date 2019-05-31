package com.example.administrator.community.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.activity.activity_game;
import com.example.administrator.community.activity.activity_movie;
import com.example.administrator.community.activity.activity_music;
import com.example.administrator.community.activity.activity_novel;
import com.example.administrator.community.activity.activity_shop;
import com.example.administrator.community.activity.activity_tuling;
import com.example.administrator.community.base.BaseFragment;

/**
 * Created by Administrator on 2018/5/18 0018.
 * 分区
 */

public class ModuleFragment extends BaseFragment {

    private TextView textView;
    private View view;
    private View v;
    private Button bt_novel;
    private Button bt_tuling;
    private Button bt_shop;
    private Button bt_game;
    private Button bt_movie;
    private Button bt_music;
    private ScrollView sv_mou;
    private LinearLayout ll_mou;


    @Override
    protected View initView() {
        view = View.inflate(mContext, R.layout.layout_moudle, null);
        bt_game = (Button)view.findViewById(R.id.bt_game);
        bt_movie = (Button)view.findViewById(R.id.bt_movie);
        bt_music = (Button)view.findViewById(R.id.bt_music);
        bt_shop = (Button)view.findViewById(R.id.bt_shop);
        bt_tuling = (Button)view.findViewById(R.id.bt_tuling);
        bt_novel = (Button)view.findViewById(R.id.bt_novel);
        sv_mou = (ScrollView) view.findViewById(R.id.sv_mou);
        ll_mou = (LinearLayout)view.findViewById(R.id.ll_mou);
        bt_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_game.class);
                startActivity(intent);
            }
        });
        bt_tuling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_tuling.class);
                startActivity(intent);
            }
        });
        bt_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_shop.class);
                startActivity(intent);
            }
        });
        bt_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_movie.class);
                startActivity(intent);
            }
        });
        bt_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_music.class);
                startActivity(intent);
            }
        });
        bt_novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_novel.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    protected void initData() {
        super.initData();

    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_interest:
                /*int sv_mouHeight = sv_mou.getHeight();
                int sv_mouWidth = sv_mou.getWidth();
                bt_game.(Integer.parseInt("高度为："+sv_mouHeight+"宽度为"+sv_mouWidth);*/
                break;
            case  R.id.ll_mou:
                sv_mou.scrollTo(0,1000);//滚动时候是瞬间滚动过去
                //sv_mou.scrollBy(0,1000);//滚动时候是瞬间的，设置便宜量，在当前的位置基础上便宜设置的数值
                //sv_mou.smoothScrollTo(0,1000);//滚动时候是平缓的而不是立即滚动到某处
                //sv_mou.smoothScrollBy(0,1000);//滚动时候是平缓，在当前的位置基础上偏移设置的数值
                break;
        }
    }
}
