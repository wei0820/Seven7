package com.jhengweipan.SevenPeopleBook;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Created by HYXEN20141227 on 2016/10/14.
 */
public class MyService extends Service {
    private static final String TAG = "MyService";
    private static List<ActivityManager.RunningAppProcessInfo> procList =null;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: "+"MyService in");
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        Log.d(TAG, "pkg:"+cn.getPackageName());
        Log.d(TAG, "cls:"+cn.getClassName());
        getRunAppList();
    }



    private  void getRunAppList(){
        getProcessInfo();
        showProcessInfo();
    }
    public void showProcessInfo() {
        procList =new ArrayList<ActivityManager.RunningAppProcessInfo>();
        // 更新進程清單
        List<HashMap<String,String>> infoList =new ArrayList<HashMap<String,String>>();
        for (Iterator<ActivityManager.RunningAppProcessInfo> iterator = procList.iterator(); iterator.hasNext();) {
            ActivityManager.RunningAppProcessInfo procInfo = iterator.next();
            Log.d(TAG, "showProcessInfo: "+procInfo.processName);
            Log.d(TAG, "showProcessInfo: "+procInfo.pid+"");

        }


    }


    public int getProcessInfo() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        procList = activityManager.getRunningAppProcesses();
        return procList.size();
    }


}
