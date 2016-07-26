package com.jhengweipan.ga;

import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.jhengweipan.Guandisignonehundred.R;

public class MyGAManager {

    private static Tracker TRACKER;
    private static GoogleAnalytics analytics;

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
