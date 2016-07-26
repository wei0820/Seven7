package com.jhengweipan.SevenPeopleBook;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Build;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

import util.MySharedPrefernces;

public class NewsActivity extends Activity {
    private String url = "http://www.mobirum.com/zh-tw/sevenknights";
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initLayout();
        addAd();

    }

    private void initLayout() {
        MyGAManager.sendScreenName(NewsActivity.this, getString(R.string.ga_news));
        WebView mWebView = (WebView) findViewById(R.id.newsWeb);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.requestFocus();
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(url);

    }

    private void addAd() {
        {
            boolean isbuy= MySharedPrefernces.getIsBuyed(NewsActivity.this);



            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            if (isbuy)mAdView.setVisibility(View.GONE);
        }

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


    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressDialog = new ProgressDialog(NewsActivity.this);
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
