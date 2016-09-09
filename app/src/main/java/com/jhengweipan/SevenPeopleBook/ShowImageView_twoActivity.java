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

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

public class ShowImageView_twoActivity extends Activity {
    private ProgressDialog mProgressDialog;
    private String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image_view_two);
        readBundle();
        addFbAd();
        initLayout();

    }
    private void readBundle() {
        Bundle bundle =this.getIntent().getExtras();
        String uriStr = bundle.getString("Uri");
        switch (uriStr){
            case "1":
                url = "http://i407.photobucket.com/albums/pp155/pkpkis123/Teo_zpsw9nbjxxr.gif";
                break;
            case "2":
                url = "https://na.cx/i/R1kNH9.gif";
                break;
            case "3":

                url = "https://na.cx/i/Anz9cZ.gif";
                break;


        }

    }

    private void addFbAd() {
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

        AdView adView = new AdView(this, "583698071813390_587400221443175", AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();
    }

    private void initLayout() {
        MyGAManager.sendScreenName(ShowImageView_twoActivity.this, getString(R.string.ga_Befall));
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


    private class MyWebViewClient extends WebViewClient {
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressDialog = new ProgressDialog(ShowImageView_twoActivity.this);
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
