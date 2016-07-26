package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import util.MySharedPrefernces;

public class StrengtheningCopyActivity extends Activity {
    private ImageView mImageView1,mImageView2,mImageView3,mImageView4;
    private TextView mTextView1,mTextView2,mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strengthening_copy);
        MyGAManager.sendScreenName(StrengtheningCopyActivity.this, getString(R.string.ga_copy));
        addAd();
        addAd2();
        initLayout();
    }


    private void initLayout() {
        ImageLoader loader = ImageLoaderInitializer.Instance(StrengtheningCopyActivity.this);

        mImageView1 = (ImageView) findViewById(R.id.copy_img1);
        mImageView2 = (ImageView) findViewById(R.id.copy_img2);
        mImageView3 = (ImageView) findViewById(R.id.copy_img3);
        mImageView4 = (ImageView) findViewById(R.id.copy_img4);
        mTextView1 = (TextView) findViewById(R.id.copy_text_1);
        mTextView2 = (TextView) findViewById(R.id.copy_text_2);
        mTextView3 = (TextView) findViewById(R.id.copy_text_3);
        loader.displayImage(getString(R.string.copy_url_1),mImageView1);
        loader.displayImage(getString(R.string.copy_url_2),mImageView2);
        loader.displayImage(getString(R.string.copy_url_3),mImageView3);
        loader.displayImage(getString(R.string.copy_url_4),mImageView4);
        mTextView1.setText(getString(R.string.copy_1));
        mTextView2.setText(getString(R.string.copy_2));
        mTextView3.setText(getString(R.string.copy_3));

    }

    private void addAd() {
        boolean isbuy= MySharedPrefernces.getIsBuyed(StrengtheningCopyActivity.this);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7019441527375550~5747041824");
        NativeExpressAdView adView = (NativeExpressAdView)findViewById(R.id.NativeadView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        if (isbuy)adView.setVisibility(View.GONE);


        AdLoader adLoader = new AdLoader.Builder(StrengtheningCopyActivity.this, "ca-app-pub-7019441527375550/8053302629")
                .forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener() {
                    @Override
                    public void onAppInstallAdLoaded(NativeAppInstallAd appInstallAd) {



                    }
                })
                .forContentAd(new NativeContentAd.OnContentAdLoadedListener() {
                    @Override
                    public void onContentAdLoaded(NativeContentAd contentAd) {
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }
    private void addAd2() {
        boolean isbuy= MySharedPrefernces.getIsBuyed(StrengtheningCopyActivity.this);


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7019441527375550~5747041824");
        NativeExpressAdView adView2 = (NativeExpressAdView)findViewById(R.id.NativeadView2);
        AdRequest request2 = new AdRequest.Builder().build();
        adView2.loadAd(request2);
        if (isbuy)adView2.setVisibility(View.GONE);


        AdLoader adLoader2 = new AdLoader.Builder(StrengtheningCopyActivity.this, "ca-app-pub-7019441527375550/8053302629")
                .forAppInstallAd(new NativeAppInstallAd.OnAppInstallAdLoadedListener() {
                    @Override
                    public void onAppInstallAdLoaded(NativeAppInstallAd appInstallAd) {



                    }
                })
                .forContentAd(new NativeContentAd.OnContentAdLoadedListener() {
                    @Override
                    public void onContentAdLoaded(NativeContentAd contentAd) {
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int errorCode) {


                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
        adLoader2.loadAd(new AdRequest.Builder().build());

    }
}
