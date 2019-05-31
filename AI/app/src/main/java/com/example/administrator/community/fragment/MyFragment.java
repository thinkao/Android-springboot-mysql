package com.example.administrator.community.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.activity.activity_head;
import com.example.administrator.community.activity.activity_message;
import com.example.administrator.community.activity.activity_collect;
import com.example.administrator.community.activity.activity_myeyes;
import com.example.administrator.community.activity.activity_mygrade;
import com.example.administrator.community.activity.activity_mylist;
import com.example.administrator.community.activity.activity_mymoney;
import com.example.administrator.community.activity.activity_myset;
import com.example.administrator.community.base.BaseFragment;

/**
 * Created by Administrator on 2018/5/18 0018.
 * 我的
 */

public class MyFragment extends BaseFragment {

    private TextView textView;
    private View view;
    private TextView tv_mymoney;
    private TextView tv_mybaby;
    private TextView tv_mygrade;
    private TextView tv_mylist;
    private TextView tv_myeyes;
    private LinearLayout iv_head;


    @Override
    protected View initView() {
        view = View.inflate(mContext, R.layout.layout_my, null);
        tv_mybaby = view.findViewById(R.id.tv_mybaby);
        tv_myeyes = view.findViewById(R.id.tv_myeyes);
        tv_mylist = view.findViewById(R.id.tv_mylist);
        tv_mymoney = view.findViewById(R.id.tv_mymoney);
        tv_mygrade = view.findViewById(R.id.tv_mygrade);
        iv_head = view.findViewById(R.id.iv_head);

        iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_message.class);
            }
        });

        tv_mybaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_collect.class);
                startActivity(intent);
            }
        });
        tv_myeyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_myeyes.class);
                startActivity(intent);
            }
        });
        tv_mylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_mylist.class);
                startActivity(intent);
            }
        });
        tv_mymoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_mymoney.class);
                startActivity(intent);
            }
        });
        tv_mygrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_mygrade.class);
                startActivity(intent);
            }
        });
        iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_head.class);
                startActivity(intent);
            }
        });
/*

        Bmob.initialize(mContext,"801156660aa3f9fb96092b95916f0c4d");
        Person person = new Person();
        person.setName("布莱恩特");
        person.setAdress("天津滨海");
        person.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    toast("添加数据成功，返回objectId为："+objectId);
                }else{
                    toast("创建数据失败：" + e.getMessage());
                }
            }
        });
*/

        return view;
    }

  /*  private void toast(String s) {
    }

*/
    protected void initData(){
        super.initData();
    }
}


