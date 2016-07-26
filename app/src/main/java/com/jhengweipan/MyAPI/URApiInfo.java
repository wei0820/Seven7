package com.jhengweipan.MyAPI;

import android.content.Context;

/**
 * Created by redjack on 15/9/22.
 */
public class URApiInfo {

    public static String ANDROID_ID;
    public static String API_TOKEN;


    public static void initialApiInfo(Context context)
    {
//        Log.e("initialApiInfo","initialApiInfo");
//        if (ANDROID_ID == null) ANDROID_ID = ALAUtil.getEncodedDeviceId(context);
//        if (API_TOKEN == null) takeAPIToken(context);
    }

    public static String apiToken()
    {
        return API_TOKEN;
    }

    public static void takeAPIToken(Context context)
    {
//        API_TOKEN = TaskSharedPreferences.getApiToken(context);
//        if ("".equals(API_TOKEN)) API_TOKEN = null;
    }
}
