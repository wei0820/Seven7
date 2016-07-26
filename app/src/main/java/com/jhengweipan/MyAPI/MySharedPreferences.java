package com.jhengweipan.MyAPI;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JackPan on 2016/6/14.
 */
public class MySharedPreferences {
    public static final String NAME = " MySharedPreferences";


    // 	// 通知中心 時間記錄
    public  static  final  String KEY_MYCARD_TIME = "mycardtime";
    public static  void saveMyCardTime (Context context ,String time){
        SharedPreferences sp = context.getSharedPreferences(NAME,Activity.MODE_PRIVATE);
        sp.edit().putString(KEY_MYCARD_TIME, time + "").commit();


    }
    public static String getMyCardTime(Context context) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Activity.MODE_PRIVATE);
        return sp.getString(KEY_MYCARD_TIME, "");
    }

}
