package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import util.MySharedPrefernces;

public class Suggest2Activity extends Activity {
    private ImageView mimg1,mimg2,mimg3,mimg4,mimg5,mimg6,mimg7;
    private TextView mtext1,mtext2,mtext3,mtext4,mtext5,mtext6,mtext7,mtext8,mtext9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest2);
        addAd();
        initLayOut();
        MyGAManager.sendScreenName(Suggest2Activity.this,getString(R.string.ga_suggest_2));
    }

    private void initLayOut() {
        ImageLoader loader = ImageLoaderInitializer.Instance(Suggest2Activity.this);
        String[] url = getResources().getStringArray(R.array.suggest2_url);
        String [] message = getResources().getStringArray(R.array.suggest2_text);
        mimg1 =(ImageView) findViewById(R.id.suggest2_img);
        mimg2 =(ImageView) findViewById(R.id.suggest2_img_2);
        mimg3 =(ImageView) findViewById(R.id.suggest2_img_3);
        mimg4 =(ImageView) findViewById(R.id.suggest2_img_4);
        mimg5 =(ImageView) findViewById(R.id.suggest2_img_5);
        mimg6 =(ImageView) findViewById(R.id.suggest2_img_6);
        mimg7 =(ImageView) findViewById(R.id.suggest2_img_7);

        mtext1 = (TextView) findViewById(R.id.suggest2_text);
        mtext2 = (TextView) findViewById(R.id.suggest2_text_2);
        mtext3 = (TextView) findViewById(R.id.suggest2_text_3);
        mtext4 = (TextView) findViewById(R.id.suggest2_text_4);
        mtext5 = (TextView) findViewById(R.id.suggest2_text_5);
        mtext6 = (TextView) findViewById(R.id.suggest2_text_6);
        mtext7 = (TextView) findViewById(R.id.suggest2_text_7);
        mtext8 = (TextView) findViewById(R.id.suggest2_text_8);
        mtext9 = (TextView) findViewById(R.id.suggest2_text_9);

        loader.displayImage(url[0],mimg1);
        loader.displayImage(url[1],mimg2);
        loader.displayImage(url[2],mimg3);
        loader.displayImage(url[3],mimg4);
        loader.displayImage(url[4],mimg5);
        loader.displayImage(url[5], mimg6);
        loader.displayImage(url[6], mimg7);
        mtext1.setText(message[0]);
        mtext2.setText(message[1]);
        mtext3.setText(message[2]);
        mtext4.setText(message[3]);
        mtext5.setText(message[4]);
        mtext6.setText(message[5]);
        mtext7.setText(message[6]);
        mtext8.setText(message[7]);
        mtext9.setText(message[8]);


    }

    private void addAd() {
        {

            boolean isbuy= MySharedPrefernces.getIsBuyed(Suggest2Activity.this);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            if (isbuy) mAdView.setVisibility(View.GONE);
        }

    }

}
