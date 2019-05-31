package com.example.administrator.community.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2018/5/18 0018.
 */
/*基类，公众类
* 四个底部按钮框架都要继承该类
* */
public abstract class BaseFragment extends Fragment{
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();//得到上下文
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }
    /*
    * 强制子类重写，实现子类特有的ui
    * */
    protected   abstract View initView();
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /*
    * 当孩子需要初始化数据，或者联网请求绑定数据，展示数据的等可以重写方法
    * */
    protected void initData() {
    }
}
