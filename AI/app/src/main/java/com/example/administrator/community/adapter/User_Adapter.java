package com.example.administrator.community.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.community.R;
import com.example.administrator.community.bean.User;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/5/15.
 */

public class User_Adapter extends BaseAdapter {
    private Context context;
    private List<User> userList = null;

    public User_Adapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.layout_user_item,null);
        TextView uid = (TextView)view.findViewById(R.id.tv_user_userid);
        TextView username = (TextView)view.findViewById(R.id.tv_user_username);
        TextView upassword = (TextView)view.findViewById(R.id.tv_user_upassword);
        TextView uname = (TextView)view.findViewById(R.id.tv_user_uname);
        Button bt_delete = (Button)view.findViewById(R.id.bt_delete);
        uid.setText(userList.get(position).getUid());
        username.setText(userList.get(position).getUsername());
        upassword.setText(userList.get(position).getUpassword());
        uname.setText(userList.get(position).getUname());


        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userList.get(position).getUsername();
                System.out.println("-----------------"+username);
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            getDelete(username);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
        return view;
    }
    /*删除*/
    private String getDelete(String username) throws IOException {
        OkHttpClient client=new OkHttpClient();
        FormBody body=new FormBody.Builder().add("username",username).build();
        System.out.println("==================="+username);
        String url = "http://62.234.17.94:8080/user/delete/"+username;
        System.out.println("00000000000"+url);
        Request request=new Request.Builder().url(url).post(body).build();
        Response response=client.newCall(request).execute();
        String responseDate=response.body().string();
        return responseDate;

    }
}
