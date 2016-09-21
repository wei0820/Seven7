package com.jhengweipan.ga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import com.google.android.gms.analytics.CampaignTrackingReceiver;

/**
 * Created by HYXEN20141227 on 2016/9/20.
 */
public class MyCampaignTrackingReceiver extends BroadcastReceiver {
    private static final String TAG="MyGaReceiver";
    private static final String PLAY_STORE_REFERRER_KEY = "referrer";
    @Override
    public void onReceive(Context context, Intent intent) {
        String referrer = intent.getStringExtra(PLAY_STORE_REFERRER_KEY);
        new CampaignTrackingReceiver().onReceive(context, intent);


    }
}