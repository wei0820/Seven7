package com.jhengweipan.ga;

import android.app.Application;

/**
 * Created by HYXEN20141227 on 2016/9/20.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.appindexing.AndroidAppUri;


public class AnalyticsApplication extends Application{


    private static final String REFERRER_NAME = "android.intent.extra.REFERRER_NAME";
    private static final String QUICK_SEARCH_BOX = "com.google.android.googlequicksearchbox";
    private static final String APP_CRAWLER = "com.google.appcrawler";

    private static final String REFERRER_PARAM = "utm_source";
    private static final String MEDIUM_PARAM = "utm_medium";

    private static final String NONE = "none";
    private static final String DIRECT = "direct";
    private static final String ORGANIC = "organic";
    private static final String REFERRAL = "referral";

    private Tracker mTracker;

    public AnalyticsApplication() {
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public synchronized Tracker getDefaultTracker() {
        if (mTracker == null) {

            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker("UA-58399132-50");
        }
        return mTracker;

    }

    public synchronized void trackScreenView(Activity activity, String screenName) {
        Tracker tracker = getDefaultTracker();
        tracker.setScreenName(screenName);

        Uri referrerUri = getReferrer(activity);

        if (referrerUri == null) {
            // App was opened directly by the user
            Log.d(this.getClass().getName(), "Referrer: Direct open");
            tracker.send(new HitBuilders.ScreenViewBuilder()
                    .setCampaignParamsFromUrl(String.format("?%s=%s&%s=%s",
                            MEDIUM_PARAM, NONE, REFERRER_PARAM, DIRECT))
                    .build());
        } else {
            // App was referred via a deep link
            if (referrerUri.getScheme().equals("http") || referrerUri.getScheme().equals("https")) {
                // App was opened from a browser
                String host = referrerUri.getHost();
                if (host.equals("www.google.com")) {
                    Log.d(this.getClass().getName(), "Referrer: Browser (google.com)");
                    tracker.send(new HitBuilders.ScreenViewBuilder()
                            .setCampaignParamsFromUrl(String.format("?%s=%s&%s=%s",
                                    MEDIUM_PARAM, ORGANIC, REFERRER_PARAM, "google.com"))
                            .build());
                } else {
                    Log.d(this.getClass().getName(), "Referrer: Browser (other website)");
                    tracker.send(new HitBuilders.ScreenViewBuilder()
                            .setCampaignParamsFromUrl(String.format("?%s=%s&%s=%s",
                                    MEDIUM_PARAM, REFERRAL, REFERRER_PARAM, host))
                            .build());
                }

            } else if (referrerUri.getScheme().equals("android-app")) {
                // App was opened from another app
                AndroidAppUri appUri = AndroidAppUri.newAndroidAppUri(referrerUri);
                String referrerPackage = appUri.getPackageName();
                if (QUICK_SEARCH_BOX.equals(referrerPackage)) {
                    // App was opened from the Google app
                    Log.d(this.getClass().getName(), "Referrer: Google Search App");
                    tracker.send(new HitBuilders.ScreenViewBuilder()
                            .setCampaignParamsFromUrl(String.format("?%s=%s&%s=%s",
                                    MEDIUM_PARAM, ORGANIC, REFERRER_PARAM, "google_app"))
                            .build());

                } else if (!APP_CRAWLER.equals(referrerPackage)) {
                    // App was deep linked into from another app (excl. Google crawler)
                    Log.d(this.getClass().getName(), "Referrer: Other android app");
                    tracker.send(new HitBuilders.ScreenViewBuilder()
                            .setCampaignParamsFromUrl(String.format("?%s=%s&%s=%s",
                                    MEDIUM_PARAM, REFERRAL, REFERRER_PARAM, referrerPackage))
                            .build());
                    Log.d(this.getClass().getName(), (String.format("?%s=%s&%s=%s",
                            MEDIUM_PARAM, REFERRAL, REFERRER_PARAM, referrerPackage)));
                }
                // Otherwise, fall through to make sure Google app crawler views
                // are not counted as part of app usage.
            }

        }
    }

    /** Returns the referrer who started the Activity. */
    public Uri getReferrer(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            return activity.getReferrer();
        }
        return getReferrerCompatible(activity);
    }

    /** Returns the referrer on devices running SDK versions lower than 22. */
    private Uri getReferrerCompatible(Activity activity) {
        Intent intent = activity.getIntent();
        Uri referrerUri = intent.getParcelableExtra(Intent.EXTRA_REFERRER);
        if (referrerUri != null) {
            return referrerUri;
        }
        String referrer = intent.getStringExtra(REFERRER_NAME);
        if (referrer != null) {
            // Try parsing the referrer URL; if it's invalid, return null
            try {
                return Uri.parse(referrer);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }
}
