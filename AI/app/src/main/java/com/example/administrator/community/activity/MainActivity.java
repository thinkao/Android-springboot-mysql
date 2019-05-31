package com.example.administrator.community.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.community.JavaBean.Person;
import com.example.administrator.community.R;
import com.example.administrator.community.base.BaseFragment;
import com.example.administrator.community.fragment.CommentFragment;
import com.example.administrator.community.fragment.IndexFragment;
import com.example.administrator.community.fragment.ModuleFragment;
import com.example.administrator.community.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Administrator on 2018/5/16 0016.
 */

class MainActivity extends FragmentActivity{

    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;
    private TextView tv_back;
    private TextView bt_force;
    private int position;//选择Fragment对应的位置
    private BaseFragment mFragment;//上次切换的Fragment



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听事件
        setListener();

        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        /*获取bundle传过来的值*/
        /*Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String unames = bundle.getString("uname");
        bundle.putString("uname",unames);
        Intent intent1 = new Intent(MainActivity.this,IndexFragment.class);
        startActivity(intent1);*/

    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        mRg_main.check(R.id.rb_index);//设置默认使用框架
    }


    class  MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup Group, int checkedId) {
            switch (checkedId){
                case R.id.rb_index://首页
                    position=0;
                    break;
                case R.id.rb_module://分区
                    position=1;
                    break;
                case R.id.rb_comment://评论
                    position=2;
                    break;
                case R.id.rb_my://我的
                    position=3;
                    break;
                default:
                    position=0;
                    break;

            }
            //根据位置得到对应的Fragment
            BaseFragment to = getFragment( );
            //替换
            switchFragment(mFragment,to);

        }
    }
    //隐藏刚刚显示的Fragment
    //一会要显示的Fragment
    private  void switchFragment(BaseFragment from,BaseFragment to) {
        if (from != to) {
            mFragment = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!to.isAdded()) {
                //没有被添加
                //from被隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //添加to
                if (to != null) {
                    ft.add(R.id.fl_content, to).commit();
                }
            } else {
                //to已被添加
                //from被隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //显示to
                if (to != null) {
                    ft.show(to).commit();
                }
            }

        }
    }
    /*private void switchFragment(BaseFragment fragment) {
        //得到FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        //替换
        transaction.replace(R.id.fl_content,fragment);
        //提交事务
        transaction.commit();
    }*/

    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return  fragment;
    }


    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new IndexFragment());//首页
        mBaseFragment.add(new ModuleFragment());//分区
        mBaseFragment.add(new CommentFragment());//评论
        mBaseFragment.add(new MyFragment());//我的
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = (RadioGroup)findViewById(R.id.rg_main);//获取ID

    }
}

