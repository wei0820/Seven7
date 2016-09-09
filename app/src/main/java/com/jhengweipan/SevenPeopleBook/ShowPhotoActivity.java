package com.jhengweipan.SevenPeopleBook;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.adapters.InterstitialAdapterListener;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

public class ShowPhotoActivity extends Activity implements InterstitialAdListener {
    private ProgressDialog mProgressDialog;
    private String url = "";
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);
        loadInterstitialAd();
        readBundle();
        addFbAd();
        initLayout();

    }
    private void loadInterstitialAd(){
        interstitialAd = new InterstitialAd(this, "583698071813390_587398738109990");
        interstitialAd.setAdListener(this);
        interstitialAd.loadAd();
    }
    private void readBundle() {
        Bundle bundle =this.getIntent().getExtras();
        String uriStr = bundle.getString("Uri");
        switch (uriStr){
            case "0":
                url = "https://na.cx/i/453b7n.gif";
                break;
            case "1":
                url = "https://na.cx/i/X9vS42.gif";
                break;
            case "2":

                url = "https://na.cx/i/T5uyt0.gif";
                break;
            case  "3" :   url = "https://na.cx/i/fiL3uT.gif"; break;
            case  "4" :   url = "https://na.cx/i/06w3Nj.gif"; break;
            case  "5" :    url = "https://na.cx/i/J7Z8G7.gif";break;
            case  "6" :   url = "https://na.cx/i/RUw5A7.gif"; break;
        }

    }

    private void addFbAd() {
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

        AdView adView = new AdView(this, "583698071813390_587400221443175", AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();
    }

    private void initLayout() {
        MyGAManager.sendScreenName(ShowPhotoActivity.this, getString(R.string.ga_Befall));
        WebView mWebView = (WebView) findViewById(R.id.newsWeb);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.requestFocus();
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(url);

    }
    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onInterstitialDisplayed(Ad ad) {

    }

    @Override
    public void onInterstitialDismissed(Ad ad) {

    }

    @Override
    public void onError(Ad ad, AdError adError) {

    }

    @Override
    public void onAdLoaded(Ad ad) {
        interstitialAd.show();
    }

    @Override
    public void onAdClicked(Ad ad) {

    }

    private class MyWebViewClient extends WebViewClient {
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressDialog = new ProgressDialog(ShowPhotoActivity.this);
            mProgressDialog.setMessage("讀取中...");
            mProgressDialog.setProgressStyle(ProgressDialog.THEME_HOLO_LIGHT);
            mProgressDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgressDialog.dismiss();
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
