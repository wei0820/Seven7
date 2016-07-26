package util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HYXEN20141227 on 2016/6/20.
 */
public class MySharedPrefernces {


    public static final String  NAME = "MySharedPrefernces";

    //首頁-是否第一次使用
    public static final String KEY_IS_BUY = "isBuy";
    public static void saveIsBuyed(Context context, boolean isBuyed) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Activity.MODE_PRIVATE);
        sp.edit().putBoolean(KEY_IS_BUY, isBuyed).apply();
    }

    public static boolean getIsBuyed(Context context) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Activity.MODE_PRIVATE);
        return sp.getBoolean(KEY_IS_BUY, false);
    }

}
