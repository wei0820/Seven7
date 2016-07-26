package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.jhengweipan.Guandisignonehundred.R;

public class WhoActivity extends Activity {
    private ListView whoListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7019441527375550~5747041824");
        NativeExpressAdView adView = (NativeExpressAdView)findViewById(R.id.NativeadView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);



        AdLoader adLoader = new AdLoader.Builder(WhoActivity.this, "ca-app-pub-7019441527375550/8053302629")
                .forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener() {
                    @Override
                    public void onAppInstallAdLoaded(NativeAppInstallAd appInstallAd) {
                        Log.d("Jack","onAppInstallAdLoaded");


                    }
                })
                .forContentAd(new NativeContentAd.OnContentAdLoadedListener() {
                    @Override
                    public void onContentAdLoaded(NativeContentAd contentAd) {
                        Log.d("Jack", "onContentAdLoaded");
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {
                        Log.d("Jack", "onAdFailedToLoad");
                        Log.d("Jack", errorCode+"");

                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
        initLayout();
    }

    private void initLayout() {
        whoListView = (ListView) findViewById(R.id.who_Listview);
        String[] whotittleName = getResources().getStringArray(R.array.whoActivity_name);
        ArrayAdapter<String> whoadpter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,whotittleName);
        whoListView.setAdapter(whoadpter);
    }


}
