package com.jhengweipan.ga;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.jhengweipan.Guandisignonehundred.R;

public class MyGAManager {

    private static Tracker TRACKER;
    private static GoogleAnalytics analytics;
    private static final String TAG = "MyGAManager";
    public synchronized static Tracker getTracker(Context context)
    {
        if (TRACKER == null)
        {
            String trackerId = context.getResources().getString(R.string.ga_trackingId);
            TRACKER = GoogleAnalytics.getInstance(context).newTracker(trackerId);
//            TRACKER.enableExceptionReporting(true);
            TRACKER.enableAdvertisingIdCollection(true);
//            TRACKER.enableAutoActivityTracking(true);
        }

        return TRACKER;
    }

    public static void sendScreenName(Context context, String name)
    {
        Tracker tracker = getTracker(context);
        tracker.setScreenName(name);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    public static void sendActionName(Context context,String categort ,String action){

        Tracker tracker = getTracker(context);
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(categort)
                .setAction(action)

                .build());


    }
    public  static void setCampaignParamsFromUrl(Context context){
        Intent intent = ((Activity)context).getIntent();
        Uri data = intent.getData();
        if(data==null) return;
        String campaignData = data.getEncodedPath();
        Tracker tracker = getTracker(context);
        tracker.send(new HitBuilders.ScreenViewBuilder()
                .setCampaignParamsFromUrl(campaignData)
                .build()
        );


    }
//    public static void sendIddeaAndShare(Context context,String categort ,String action,String name,String mail,String tittle,String message){
//
//        Tracker tracker = getTracker(context);
//        tracker.send(new HitBuilders.EventBuilder()
//                .setCategory(categort)
//                .setAction(action)
//                .set("Name",name)
//                .set("Mail",mail)
//                .set("Tittle",tittle)
//                .set("Message",message)
//                .build());
//
//
//    }
}
