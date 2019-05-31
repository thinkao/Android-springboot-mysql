package com.example.administrator.community.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.Collect;


import java.util.List;

/**
 * Created by Administrator on 2019/3/30.
 */

public class Collect_Adapter extends BaseAdapter {
    private Context context;
    private List<Collect> collectList = null;


    public Collect_Adapter(Context context, List<Collect> collectList) {
        this.context = context;
        this.collectList = collectList;
    }

    @Override
    public int getCount() {
        return collectList.size();
    }

    @Override
    public Object getItem(int position) {
        return collectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view = View.inflate(context, R.layout.layout_collect_item,null);
       TextView cid = (TextView)view.findViewById(R.id.tv_collect_id);
       TextView context = (TextView)view.findViewById(R.id.tv_collect_context);
       TextView time = (TextView)view.findViewById(R.id.tv_collect_time);
       cid.setText(collectList.get(position).getCid());
       context.setText(collectList.get(position).getContext());
       time.setText(collectList.get(position).getTime());
        return view;
    }
}
