package com.example.administrator.community.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IInterface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.activity.activity_find;
import com.example.administrator.community.activity.activity_interest;
import com.example.administrator.community.activity.activity_say;
import com.example.administrator.community.activity.show_good_info;
import com.example.administrator.community.adapter.Adapter_Comment;
import com.example.administrator.community.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/18 0018.
 * 评论
 */

public class CommentFragment extends BaseFragment {

    /*private static final String TAG =CommentFragment.class.getSimpleName() ;//"得到CommentFragment"*/
    private TextView textView;
    private View  view;
    private TextView tv_interest;
    private TextView tv_say;
    private TextView tv_find;
    private ListView lv_listview_comment;


    @Override
    protected View initView() {
        view = View.inflate(mContext, R.layout.layout_comment,null);
        tv_find = (TextView)view.findViewById(R.id.tv_find);
        tv_say = (TextView)view.findViewById(R.id.tv_say);
        tv_interest = (TextView)view.findViewById(R.id.tv_interest);
        /*lv_listview_comment = (ListView)view.findViewById(R.id.lv_listview_comment);*/

        String[] src = {"新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息","新消息"};
        final List<String> list = new ArrayList<>();
        for(String s:src)
            list.add(s);

        //设置默认适配器页面
        final Adapter_Comment adapter_comment = new Adapter_Comment(mContext,list);
        /*lv_listview_comment.setAdapter(adapter_comment);
        lv_listview_comment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView type = (TextView) view.findViewById(R.id.type);
                TextView value = (TextView)view.findViewById(R.id.value);
                Bundle bundle   = new Bundle();
                bundle.putString("type",type.getText().toString().intern());
                bundle.putString("value",value.getText().toString().intern());
                Intent intent = new Intent(mContext,show_good_info.class);
                intent.putExtras(intent);
                startActivity(intent);
            }
        });*/
        //最新发现的监听事件
        /*tv_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adapter_Comment adapter_comment = new Adapter_Comment(mContext,list);
                lv_listview_comment.setAdapter(adapter_comment);
                lv_listview_comment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView type = (TextView) view.findViewById(R.id.type);
                        TextView value = (TextView)view.findViewById(R.id.value);
                        Bundle bundle   = new Bundle();
                        bundle.putString("type",type.getText().toString().intern());
                        bundle.putString("value",value.getText().toString().intern());
                        Intent intent = new Intent(mContext,show_good_info.class);
                        intent.putExtras(intent);
                        startActivity(intent);
                    }
                });
            }
        });*/
        //兴趣部落的监听事件
        /*tv_interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adapter_Comment adapter_comment = new Adapter_Comment(mContext,list);
                lv_listview_comment.setAdapter(adapter_comment);
                lv_listview_comment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView type = (TextView) view.findViewById(R.id.type);
                        TextView value = (TextView)view.findViewById(R.id.value);
                        Bundle bundle   = new Bundle();
                        bundle.putString("type",type.getText().toString().intern());
                        bundle.putString("value",value.getText().toString().intern());
                        Intent intent = new Intent(mContext,show_good_info.class);
                        intent.putExtras(intent);
                        startActivity(intent);
                    }
                });
            }
        });*/


        //我要吐槽的监听事件
        /*tv_say.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Adapter_Comment adapter_comment = new Adapter_Comment(mContext,list);
                lv_listview_comment.setAdapter(adapter_comment);
                lv_listview_comment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView type = (TextView) view.findViewById(R.id.type);
                        TextView value = (TextView)view.findViewById(R.id.value);
                        Bundle bundle   = new Bundle();
                        bundle.putString("type",type.getText().toString().intern());
                        bundle.putString("value",value.getText().toString().intern());
                        Intent intent = new Intent(mContext,show_good_info.class);
                        intent.putExtras(intent);
                        startActivity(intent);
                    }
                });
            }
        });
*/
        tv_say.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_say.class);
                startActivity(intent);
            }
        });
        tv_interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_interest.class);
                startActivity(intent);
            }
        });
        tv_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_find.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    protected void initData() {
        super.initData();

    }
}
