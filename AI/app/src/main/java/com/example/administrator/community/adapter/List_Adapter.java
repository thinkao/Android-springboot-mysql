package com.example.administrator.community.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.List_list;

import java.util.List;

/**
 * Created by Administrator on 2019/5/11.
 */

public class List_Adapter extends BaseAdapter {
    private Context context;
    private List<List_list> listList = null;


    public List_Adapter(Context context, List<List_list> listList) {
        this.context = context;
        this.listList = listList;
    }

    @Override
    public int getCount() {
        return listList.size();
    }

    @Override
    public Object getItem(int position) {
        return listList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.layout_list_item,null);
        TextView lid = (TextView)view.findViewById(R.id.tv_list_lid);
        TextView lcontext = (TextView)view.findViewById(R.id.tv_list_lcontext);
        TextView ltime = (TextView)view.findViewById(R.id.tv_list_time);

        lid.setText(listList.get(position).getLid());
        lcontext.setText(listList.get(position).getLcontext());
        ltime.setText(listList.get(position).getLtime());
        return view;
    }
}
