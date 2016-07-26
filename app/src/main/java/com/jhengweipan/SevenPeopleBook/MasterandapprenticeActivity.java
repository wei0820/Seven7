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

public class MasterandapprenticeActivity extends Activity {
    private TextView mMasterText,mMasterText2,mMasterText3,mMasterText4,mMasterText5,mMasterText6,mMasterText7,
            mMasterText8,mMasterText9,mMasterText10,mMasterText11;
    private ImageView  mImageView,mImageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterandapprentice);
        addAd();
        initLayout();
    }

    private void initLayout() {
        MyGAManager.sendScreenName(MasterandapprenticeActivity.this, getString(R.string.ga_master));
        mMasterText = (TextView)findViewById(R.id.mastretext_1);
        mMasterText2 = (TextView)findViewById(R.id.mastretext_2);
        mMasterText3 = (TextView)findViewById(R.id.mastretext_3);
        mMasterText4 = (TextView)findViewById(R.id.mastretext_4);
        mMasterText5 = (TextView)findViewById(R.id.mastretext_5);
        mMasterText6 = (TextView)findViewById(R.id.mastretext_6);
        mMasterText7 = (TextView)findViewById(R.id.mastretext_7);
        mMasterText8 = (TextView)findViewById(R.id.mastretext_8);
        mMasterText9 = (TextView)findViewById(R.id.mastretext_9);
        mMasterText10 = (TextView)findViewById(R.id.mastretext_10);
        mMasterText11 = (TextView)findViewById(R.id.mastretext_11);
        mImageView = (ImageView) findViewById(R.id.master_img_1);
        mImageView2 = (ImageView) findViewById(R.id.master_img_2);
        ImageLoader loader = ImageLoaderInitializer.Instance(MasterandapprenticeActivity.this);
        loader.displayImage(getString(R.string.master_url),mImageView);
        loader.displayImage(getString(R.string.master_url_2),mImageView2);
        mMasterText.setText(getString(R.string.master_text_1));
        mMasterText2.setText(getString(R.string.master_text_2));
        mMasterText3.setText(getString(R.string.master_text_3));
        mMasterText4.setText(getString(R.string.master_text_4));
        mMasterText5.setText(getString(R.string.master_text_5));
        mMasterText6.setText(getString(R.string.master_text_6));
        mMasterText7.setText(getString(R.string.master_text_7));
        mMasterText8.setText(getString(R.string.master_text_8));
        mMasterText9.setText(getString(R.string.master_text_9));
        mMasterText10.setText(getString(R.string.master_text_10));
        mMasterText11.setText(getString(R.string.master_text_11));



    }

    private void addAd() {
        boolean isbuy= MySharedPrefernces.getIsBuyed(MasterandapprenticeActivity.this);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7019441527375550~5747041824");
        NativeExpressAdView adView = (NativeExpressAdView)findViewById(R.id.NativeadView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);
        if (isbuy)adView.setVisibility(View.GONE);
        NativeExpressAdView adView2 = (NativeExpressAdView)findViewById(R.id.NativeadView_2);
        AdRequest request2 = new AdRequest.Builder().build();
        adView2.loadAd(request2);

        if (isbuy)adView2.setVisibility(View.GONE);


        AdLoader adLoader = new AdLoader.Builder(MasterandapprenticeActivity.this, "ca-app-pub-7019441527375550/8053302629")
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





        AdLoader adLoader2 = new AdLoader.Builder(MasterandapprenticeActivity.this, "ca-app-pub-7019441527375550/8053302629")
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
