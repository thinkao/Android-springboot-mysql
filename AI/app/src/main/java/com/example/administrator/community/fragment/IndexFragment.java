package com.example.administrator.community.fragment;




import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.community.R;

import com.example.administrator.community.activity.activity_login;
import com.example.administrator.community.activity.activity_myset;
import com.example.administrator.community.activity.activity_notification;
import com.example.administrator.community.base.BaseFragment;
import com.example.administrator.community.bean.SharedPreferencesUtil;
import com.example.administrator.community.bean.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import okhttp3.FormBody;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Administrator on 2018/5/18 0018.
 * 首页
 */

public class IndexFragment extends BaseFragment implements View.OnClickListener {
    private List<User> userList = null;
    private ListView lv_listview;
    private SharedPreferencesUtil su;
    private static final String TAG = IndexFragment.class.getSimpleName();//"得到IndexFragment"
    private TextView textView;
    private Button bt_send;
    private View view;
    private ScrollView sv_index;
    private LinearLayout ll_index;
    private ImageView iv_indexx;
    private DrawerLayout mDrawerLayout;
    private TextView tv_backlogin;
    private TextView tv_myset;


    private static ViewPager viewPager;
    private RadioGroup group;
    //图片资源，实际项目需要从网络获取
    private int[] imageIds = {R.drawable.happy, R.drawable.happyone, R.drawable.happytwo, R.drawable.happythree};
    //存放图片的数组
    private List<ImageView> mList;
    //当前索引位置以及上一个索引位置
    private static int index = 0, preIndex = 0;
    //是否需要轮播标志
    private boolean isContinue = true;
    //定时器，用于实现轮播
    private Timer timer = new Timer();
    private MyHandler mHandler;

    public static class MyHandler extends Handler {
        private WeakReference<IndexFragment> weakReference;

        public MyHandler(IndexFragment activity) {
            weakReference = new WeakReference<>(activity);
        }


        public void handleMessage(Message msg) {
            if (weakReference.get() != null) {
                index++;
                viewPager.setCurrentItem(index);
            }
            handleMessage(msg);
        }

        @Override
        public void publish(LogRecord logRecord) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }

        public void sendEmptyMessage(int i) {
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        su = SharedPreferencesUtil.getInstance(getContext());
        initView();
        initData();
        addListener();
        //让当前图片位于中间某个位置，目的就是为了开始能够左滑
        viewPager.setCurrentItem(imageIds.length * 100);
        initRadioButton(imageIds.length);//注意这句和上面那句顺序不能写反，否则会出现第一个圆点无法显示选中状态
        startSwitch();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_send:
                Intent intent = new Intent(mContext, activity_notification.class);
                PendingIntent pi = PendingIntent.getActivity(mContext, 0, intent, 0);
                NotificationManager manager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(mContext)
                        .setSound(Uri.fromFile(new File("/qqmusic/song/bbb.mp3")))
                        .setVibrate(new long[]{0, 1000, 1000, 1000})
                        .setContentTitle("解忧社区来了")
                        .setContentText("解忧小君带你走向另一个世界...")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.launcher1))
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
        switch (view.getId()){
            case R.id.iv_indexx:
                int sv_indexHeight = sv_index.getHeight();
                int sv_indexWidth = sv_index.getWidth();
                iv_indexx.setImageResource(Integer.parseInt("高度为："+sv_indexHeight+"宽度为"+sv_indexWidth));
                break;
            case  R.id.ll_index:
                //sv_interest.scrollTo(0,1000);//滚动时候是瞬间滚动过去
                //sv_interest.scrollBy(0,1000);//滚动时候是瞬间的，设置便宜量，在当前的位置基础上便宜设置的数值
                //sv_interest.smoothScrollTo(0,1000);//滚动时候是平缓的而不是立即滚动到某处
                //sv_interest.smoothScrollBy(0,1000);//滚动时候是平缓，在当前的位置基础上偏移设置的数值
                break;
        }
    }

   /* public int getCount() {
        return userList.size();
    }


    public Object getItem(int position) {
        return userList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }*/

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.layout_index, null);//获取页面，上下文
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        group = (RadioGroup) view.findViewById(R.id.group);
        sv_index = (ScrollView)view.findViewById(R.id.sv_index);
        ll_index = (LinearLayout)view.findViewById(R.id.ll_index);
        iv_indexx = (ImageView)view.findViewById(R.id.iv_indexx);
        tv_backlogin = (TextView)view.findViewById(R.id.tv_backlogin);
        bt_send = (Button) view.findViewById(R.id.bt_send);
        tv_myset = (TextView)view.findViewById(R.id.tv_myset);




        TextView uname = (TextView)view.findViewById(R.id.tv_uname);
        TextView username = (TextView)view.findViewById(R.id.tv_username);

        /*获取通过登录传过来的用户姓名*/

        String test = su.getValue("test");
        String test1 = su.getValue("test1");

        uname.setText(test);
        username.setText(test1);
        //RequestBody body = new FormBody.Builder().add("test",su.getValue("test")).build();

        /*获取通过登录传过来的用户姓名*/


        bt_send.setOnClickListener(this);

        tv_backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,activity_login.class);
                startActivity(intent);
            }
        });

        tv_myset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,activity_myset.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout)view.findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.index02);
        }
        return view;
    }

    private ActionBar getSupportActionBar() {
        return null;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
                default:
        }
        return true;
    }


    /**
     * 初始化控件
     */


    /**
     * 初始化数据
     */
    public void initData() {
        mList = new ArrayList<>();
        viewPager.setAdapter(pagerAdapter);
        mHandler = new MyHandler(this);
    }
    /**
     * 添加监听
     */
    public void addListener() {
        viewPager.addOnPageChangeListener(onPageChangeListener);
        viewPager.setOnTouchListener(onTouchListener);
    }
    /**
     * 进行图片轮播
     */
    public void startSwitch() {
        //执行定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //首先判断是否需要轮播，是的话我们才发消息
                if (isContinue) {
                    mHandler.sendEmptyMessage(1);
                }
            }
        }, 3000, 3500);//延迟3秒，每隔3.5秒发一次消息;
    }
    /**
     * 根据图片个数初始化按钮
     * @param length 图片所在集合长度
     */
    private void initRadioButton(int length) {
        for (int i = 0; i < length; i++) {
            ImageView imageview = new ImageView(mContext);
            imageview.setImageResource(R.drawable.rg_selector);//设置背景选择器
            imageview.setPadding(20, 0, 0, 0);//设置每个按钮之间的间距
            //将按钮依次添加到RadioGroup中
            group.addView(imageview, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            //默认选中第一个按钮，因为默认显示第一张图片
            group.getChildAt(0).setEnabled(false);
        }
    }


    /**
     * 根据当前触摸事件判断是否要轮播
     */
    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                //手指按下和划动的时候停止图片的轮播
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                    isContinue = false;
                    break;
                default:
                    isContinue = true;
            }
            return false;//注意这里只能返回false,如果返回true，Dwon就会消费掉事件，MOVE无法获得事件，
            // 导致图片无法滑动
        }
    };
    /**
     * 根据当前选中的页面设置按钮的选中
     */
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            index = position;//当前位置赋值给索引
            setCurrentDot(index % imageIds.length);//因为只有四个按钮，所以我们在此要对长度区域，保证范围在0到4
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    /**
     * 设置对应位置按钮的状态
     * @param i 当前位置
     */
    private void setCurrentDot(int i) {
        if (group.getChildAt(i) != null) {
            group.getChildAt(i).setEnabled(false);//当前按钮选中,显示蓝色
        }
        if (group.getChildAt(preIndex) != null) {
            group.getChildAt(preIndex).setEnabled(true);//上一个取消选中。显示灰色
            preIndex = i;//当前位置变为上一个，继续下次轮播
        }
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            //返回一个比较大的值，目的是为了实现无限轮播
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position % imageIds.length;//因为position非常大，而我们需要的position不能大于图片集合长度
            //所以在此取余
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(imageIds[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);
            mList.add(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//         注意在此不要做任何操作，因为我们需要实现向左滑动，否则会产生IndexOutOfBoundsException
        }
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        //页面销毁的时候取消定时器
        if (timer != null) {
            preIndex = 0;
            timer.cancel();
        }
    }

}
