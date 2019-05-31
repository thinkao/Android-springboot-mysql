package com.example.administrator.community.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.Collect;
import com.example.administrator.community.bean.Music;

import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */

public class Music_Adapter extends BaseAdapter {
    private Context context;
    private List<Music> musicList = null;

    public Music_Adapter(Context context, List<Music> musicList) {
        this.context = context;
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View view1 = null;
        ViewHolder viewHolder = null;
        if (view == null) {
            view1 = LayoutInflater.from(context).inflate(R.layout.layout_music_item, null);
            //创建布局视图
            viewHolder = new ViewHolder();
            viewHolder.titletv = view1.findViewById(R.id.song_name_tv);
            viewHolder.artisttv = view1.findViewById(R.id.singer_name_tv);
            //创建布局控件

            view1.setTag(viewHolder);

        } else {
            view1 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        Music music = musicList.get(i);
        viewHolder.titletv.setText(music.title);
        viewHolder.artisttv.setText(music.artist + " - " + music.album);
        //给行布局控件赋值

        if (music.albumbtm != null) {
            viewHolder.albumimg.setImageBitmap(music.albumbtm);
        } else {
            viewHolder.albumimg.setImageResource(R.drawable.bofang);

        }
        return view1;

    }

    class ViewHolder {
        TextView titletv;
        TextView artisttv;
        ImageView albumimg;

    }
}




