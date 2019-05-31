package com.example.administrator.community.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.community.R;

import java.util.List;

/**
 * Created by Administrator on 2018/11/23 0023.
 */

public class Adapter_Comment extends BaseAdapter {

    private Context context;
    private List<String> stringList;

    public Adapter_Comment(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    static int[] src = {R.drawable.loginhead,R.drawable.loginhead,R.drawable.loginhead,R.drawable.loginhead,R.drawable.loginhead,
            R.drawable.loginhead,R.drawable.loginhead, R.drawable.loginhead,R.drawable.loginhead,R.drawable.loginhead,R.drawable.loginhead};

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        View contextview = View.inflate(context,R.layout.layout_adapter_comment,null);
        ImageView imageView = (ImageView)contextview.findViewById(R.id.show_image);
        TextView textView = (TextView)contextview.findViewById(R.id.my_text);
        loadImage(position,imageView);
        return contextview;
    }

    public void loadImage(int position,ImageView imageView){
        int count = position;
        if(count<src.length){
            imageView.setImageResource(src[count]);
        }else {
            loadImage(1,imageView);
        }

    }
}
