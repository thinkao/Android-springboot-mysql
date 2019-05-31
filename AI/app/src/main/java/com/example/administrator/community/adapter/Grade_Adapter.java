package com.example.administrator.community.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.activity.activity_mygrade;
import com.example.administrator.community.bean.Grade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/16.
 */

public class Grade_Adapter extends BaseAdapter {
    private Context context;
    private List<Grade> gradeList = null;

    public Grade_Adapter(Context context, List<Grade> gradeList) {
        this.context = context;
        this.gradeList = gradeList;
    }

    @Override
    public int getCount() {
        return gradeList.size();
    }

    @Override
    public Object getItem(int position) {
        return gradeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.layout_grade_item,null);
        TextView tv_time = (TextView)view.findViewById(R.id.tv_time);
        TextView tv_context = (TextView)view.findViewById(R.id.tv_context);
        TextView tv_num = (TextView)view.findViewById(R.id.tv_num);
        tv_context.setText(gradeList.get(position).getContext());
        tv_time.setText(gradeList.get(position).getTime());
        tv_num.setText(gradeList.get(position).getNum());
        return view;
    }
}
