package com.jhengweipan.SevenPeopleBook;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
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

        new AsyncTask<Void, Void, List<ProcessManager.Process>>() {

            long startTime;

            @Override
            protected List<ProcessManager.Process> doInBackground(Void... params) {
                startTime = System.currentTimeMillis();
                return ProcessManager.getRunningApps();
            }

            @Override
            protected void onPostExecute(List<ProcessManager.Process> processes) {
                StringBuilder sb = new StringBuilder();
                sb.append("Execution time: ").append(System.currentTimeMillis() - startTime).append("ms\n");
                sb.append("Running apps:\n");
                for (ProcessManager.Process process : processes) {
                    sb.append('\n').append(process.name);
                }
                Log.d(TAG, "onPostExecute: "+sb.toString());
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }




}
