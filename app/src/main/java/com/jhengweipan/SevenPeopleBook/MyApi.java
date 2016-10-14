package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by HYXEN20141227 on 2016/5/6.
 */
public class MyApi {
    public static  void loadImage(final String path,
                           final ImageView imageView,final Activity activity){

        new Thread(){

            @Override
            public void run() {

                try {
                    URL imageUrl = new URL(path);
                    HttpURLConnection httpCon =
                            (HttpURLConnection) imageUrl.openConnection();
                    InputStream imageStr =  httpCon.getInputStream();
                    final Bitmap bitmap =  BitmapFactory.decodeStream(imageStr);

                    activity.runOnUiThread(new Runnable() {

                       @Override
                       public void run() {
                           // TODO Auto-generated method stub
                           imageView.setImageBitmap(bitmap);
                       }
                   });


                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    Log.e("Howard", "MalformedURLException:" + e);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Log.e("Howard", "IOException:"+e);
                }



            }


        }.start();

    }
public static String getImeiandSim(Context context){
    TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    String imei = tm.getDeviceId();
    String sim = tm.getSimSerialNumber();

    return  imei+"-"+sim;
}

    public static String getEncodedDeviceId(Context context)
    {
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

        String hashedId;
        if ((androidId == null) || isEmulator())
        {
            hashedId = sha1("emulator");
        }
        else
        {
            hashedId = sha1(androidId);
        }

        if (hashedId == null)
        {
            return null;
        }

        return hashedId;
    }
    public static boolean isEmulator()
    {
        return (Build.BOARD.equals("unknown") && Build.DEVICE.equals("generic") && Build.BRAND.equals("generic"));
    }
    private static String sha1(String val)
    {
        String result = null;

        if ((val != null) && (val.length() > 0))
        {
            try
            {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                md.update(val.getBytes());
                return String.format("and://%040x", new BigInteger(1, md.digest()));
            }
            catch (NoSuchAlgorithmException nsae)
            {
                result = val.substring(0, 40);
            }
        }
        return result;
    }
}
