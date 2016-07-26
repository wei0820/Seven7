package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BefallActivity extends Activity {
    private TextView mBefallText,mBefallText2,mBefallText3;
    private ImageView mBefall,mBefallImg2,mBefallimg3;
    private ImageView mImageView, mImageView2, mImageView3, mImageView4, mImageView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_befall);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        initLayout();

    }

    private void initLayout() {
        MyGAManager.sendScreenName(BefallActivity.this,getString(R.string.ga_Befall));
        ImageLoader loader = ImageLoaderInitializer.Instance(BefallActivity.this);
        mBefallText = (TextView) findViewById(R.id.befall_text);
        mBefallText2 = (TextView) findViewById(R.id.befall_text_2);
        mBefallText3 = (TextView) findViewById(R.id.befall_text_3);
        mBefallText.setText(getString(R.string.befall_text));
        mBefallText2.setText(getString(R.string.befall_text_2));
        mBefallText3.setText(getString(R.string.befall_text_3));
        mBefall =(ImageView)findViewById(R.id.befall_img);
        mBefallImg2 = (ImageView)findViewById(R.id.befall_img_2);
        mBefallimg3 =(ImageView) findViewById(R.id.befall_img_3);
        loader.displayImage(getString(R.string.befall_url), mBefall);
        loader.displayImage(getString(R.string.befall_url_2), mBefallImg2);
        loader.displayImage(getString(R.string.befall_url_3),mBefallimg3);
        // 這邊放入 推薦隊伍
        mImageView = (ImageView) findViewById(R.id.duplicate_img1);
        mImageView2 = (ImageView) findViewById(R.id.duplicate_img2);
        mImageView3 = (ImageView) findViewById(R.id.duplicate_img3);
        mImageView4 = (ImageView) findViewById(R.id.duplicate_img4);
        mImageView5 = (ImageView) findViewById(R.id.duplicate_img5);
        loader.displayImage(getString(R.string.dragon_url_1), mImageView);
        loader.displayImage(getString(R.string.befall_url_5), mImageView2);
        loader.displayImage(getString(R.string.dragon_url_3), mImageView3);
        loader.displayImage(getString(R.string.befall_url_4), mImageView4);
        loader.displayImage(getString(R.string.dragon_url_5), mImageView5);

    }
}
