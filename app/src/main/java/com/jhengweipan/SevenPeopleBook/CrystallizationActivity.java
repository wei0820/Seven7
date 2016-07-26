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

public class CrystallizationActivity extends Activity {
    private ImageView mImageView,mImageView2,mImageView3;
    private TextView mTextView,mTextView2,mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crystallization);
        addAd();
        initLayout();
        MyGAManager.sendScreenName(CrystallizationActivity.this,getString(R.string.ga_crystaillzation));
    }

    private void initLayout() {
        mImageView =(ImageView) findViewById(R.id.CrystallizationActivity_img);
        mImageView2 =(ImageView) findViewById(R.id.CrystallizationActivity_img_2);
        mImageView3 =(ImageView) findViewById(R.id.CrystallizationActivity_img_3);
        mTextView =(TextView) findViewById(R.id.CrystallizationActivity_text);
        mTextView2 =(TextView) findViewById(R.id.CrystallizationActivity_text_2);
        mTextView3 =(TextView) findViewById(R.id.CrystallizationActivity_text_3);
        ImageLoader loader = ImageLoaderInitializer.Instance(CrystallizationActivity.this);
        loader.displayImage("https://scontent-tpe1-1.xx.fbcdn.net/v/t1.0-9/13450928_597621780405608_7579120620520543420_n.png?oh=4c0d7c6901ee690203486a36a7a87bab&oe=57F60915",mImageView);
        loader.displayImage("https://scontent-tpe1-1.xx.fbcdn.net/v/l/t1.0-9/13450808_597622263738893_5714739432807240062_n.png?oh=9741beacecd66654a44475854b262aea&oe=5801BEC7",mImageView2);
        loader.displayImage(getString(R.string.crystallization_url),mImageView3);
         mTextView.setText(getString(R.string.crystallization_text));
        mTextView2.setText(getString(R.string.crystallization_text_2));
        mTextView3.setText(getString(R.string.crystallization_text_3));





    }
    private void addAd() {
        {

            boolean isbuy= MySharedPrefernces.getIsBuyed(CrystallizationActivity.this);

            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            if (isbuy) mAdView.setVisibility(View.GONE);
        }

    }
}
