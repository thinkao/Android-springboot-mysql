package com.example.administrator.community.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyNotYetValidException;
import android.util.Log;

/**
 * 状态保存工具类
 */
public class SharedPreferencesUtil {


    private static final String TOKEN = "TOKEN";
    // SharedPreferences是Android平台上一个轻量级的存储辅助类
    private static SharedPreferences myPreferences;
    private static SharedPreferences.Editor editor;
    private static SharedPreferencesUtil mSharedPreferencesUtil;

    private final Context context;

    public SharedPreferencesUtil(Context context) {
        this.context = context.getApplicationContext();
        // 调用Context对象的getSharedPreferences()方法获得的SharedPreferences对象可以被同一应用程序下的其他组件共享.
        myPreferences = this.context.getSharedPreferences("TAG", Context.MODE_PRIVATE);
        editor = myPreferences.edit();

    }

    /**
     * 单例实现
     * @param context
     * @return
     */
    public static SharedPreferencesUtil getInstance(Context context) {
        if(mSharedPreferencesUtil == null ) {
            mSharedPreferencesUtil = new SharedPreferencesUtil(context);
        }
        return mSharedPreferencesUtil;
    }


    /**
     * 设置值
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 清空
     */
    public void clear() {
        editor.clear();
        editor.commit();
    }

    /**
     * 获取值
     * @param key
     * @return
     */
    public String getValue(String key) {
        return myPreferences.getString(key, "");
    }


    /**
     * 设置登陆状态（存入token）
     * @param token
     */
    public void toLogin(String token) {
        setValue(TOKEN, token);
    }

    public boolean isLogin() {
        String token = getValue(TOKEN);
        Log.e("token", token);
        if("".equals(token)) {
            return false;
        } else {
             return true;
        }
    }




}
