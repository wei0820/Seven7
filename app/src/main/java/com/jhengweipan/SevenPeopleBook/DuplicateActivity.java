package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

import myAppKey.mykey;
import util.MySharedPrefernces;

import static android.graphics.Color.*;

public class DuplicateActivity extends Activity implements View.OnClickListener {
    private ImageView mImageView, mImageView2, mImageView3, mImageView4, mImageView5;
    private TextView mTextView, mTextView2, mTextView3, mTextView4, mTextView5;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplicate);
        initLayout();
        MyGAManager.sendScreenName(DuplicateActivity.this, getString(R.string.ga_dargon));
        boolean isbuy= MySharedPrefernces.getIsBuyed(DuplicateActivity.this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (isbuy)mAdView.setVisibility(View.GONE);

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-7019441527375550/2925635425");
        interstitial.loadAd(adRequest);

    }

    private void initLayout() {
        ImageLoader loader = ImageLoaderInitializer.Instance(DuplicateActivity.this);
        mImageView = (ImageView) findViewById(R.id.duplicate_img1);
        mImageView2 = (ImageView) findViewById(R.id.duplicate_img2);
        mImageView3 = (ImageView) findViewById(R.id.duplicate_img3);
        mImageView4 = (ImageView) findViewById(R.id.duplicate_img4);
        mImageView5 = (ImageView) findViewById(R.id.duplicate_img5);
        findViewById(R.id.duplicate_img1).setOnClickListener(this);
        findViewById(R.id.duplicate_img2).setOnClickListener(this);
        findViewById(R.id.duplicate_img3).setOnClickListener(this);
        findViewById(R.id.duplicate_img4).setOnClickListener(this);
        findViewById(R.id.duplicate_img5).setOnClickListener(this);
//        mTextView = (TextView) findViewById(R.id.dargon_tittle1);
//        mTextView2 = (TextView) findViewById(R.id.dargon_tittle2);
//        mTextView3 = (TextView) findViewById(R.id.dargon_tittle3);
//        mTextView4 = (TextView) findViewById(R.id.dargon_tittle4);
//        mTextView5 = (TextView) findViewById(R.id.dargon_tittle5);
//        mTextView.setText(getString(R.string.dragon_tittle_1));
//        mTextView2.setText(getString(R.string.dragon_tittle_2));
//        mTextView3.setText(getString(R.string.dragon_tittle_3));
//        mTextView4.setText(getString(R.string.dragon_tittle_4));
//        mTextView5.setText(getString(R.string.dragon_tittle_5));
        loader.displayImage(getString(R.string.dragon_url_1), mImageView);
        loader.displayImage(getString(R.string.dragon_url_2), mImageView2);
        loader.displayImage(getString(R.string.dragon_url_3), mImageView3);
        loader.displayImage(getString(R.string.dragon_url_4), mImageView4);
        loader.displayImage(getString(R.string.dragon_url_5), mImageView5);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.duplicate_img1:

                String[] name = new String[]{getString(R.string.dragon_tittle_15), getString(R.string.dragon_tittle_1)};
                changeMan(name, getString(R.string.dargon_main), 5);

                break;
            case R.id.duplicate_img2:
                String[] name2 = new String[]{getString(R.string.dragon_tittle_2), getString(R.string.dragon_tittle_6),
                        getString(R.string.dragon_tittle_7), getString(R.string.dragon_tittle_8), getString(R.string.dragon_tittle_9)};
                changeMan(name2, getString(R.string.dargon_magic) + "/" + getString(R.string.dargon_defense), 1);

                break;
            case R.id.duplicate_img3:
                String[] name3 = new String[]{getString(R.string.dragon_tittle_3), getString(R.string.dragon_tittle_10), getString(R.string.dragon_tittle_11), getString(R.string.dragon_tittle_12)};
                changeMan(name3, getString(R.string.dargon_attack) + "/" + getString(R.string.dargon_break), 2);
                break;
            case R.id.duplicate_img4:
                String[] name4 = new String[]{getString(R.string.dragon_tittle_4), getString(R.string.dragon_tittle_13)};
                changeMan(name4, getString(R.string.dargon_dizzy), 3);
                break;
            case R.id.duplicate_img5:
                String[] name5 = new String[]{getString(R.string.dragon_tittle_5), getString(R.string.dragon_tittle_12), getString(R.string.dragon_tittle_11), getString(R.string.dragon_tittle_14)};
                changeMan(name5, getString(R.string.dargon_hurt) + "/" + getString(R.string.dargon_break), 4);

                break;
        }

    }

    private void changeMan(final String[] manName, final String tittle, final int number) {
        final int mannumber = number;
        final ImageLoader changeload = ImageLoaderInitializer.Instance(DuplicateActivity.this);

        ListView listView = new ListView(this);
//        listView.setBackgroundColor(Color.WHITE);

        ArrayAdapter<String> manadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, manName);
        listView.setAdapter(manadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyGAManager.sendActionName(DuplicateActivity.this, "changMan", manName[position]);
                switch (position) {
                    case 0:
                        if (mannumber == 1)
                            changeload.displayImage(getString(R.string.dragon_url_2), mImageView2);
                        if (mannumber == 2)
                            changeload.displayImage(getString(R.string.dragon_url_3), mImageView3);
                        if (mannumber == 3)
                            changeload.displayImage(getString(R.string.dragon_url_4), mImageView4);
                        if (mannumber == 4)
                            changeload.displayImage(getString(R.string.dragon_url_5), mImageView5);
                        if (mannumber == 5)
                            changeload.displayImage(getString(R.string.dragon_url_15), mImageView);


                        break;
                    case 1:
                        if (mannumber == 1)
                            changeload.displayImage(getString(R.string.dragon_url_6), mImageView2);
                        if (mannumber == 2)
                            changeload.displayImage(getString(R.string.dragon_url_10), mImageView3);
                        if (mannumber == 3)
                            changeload.displayImage(getString(R.string.dragon_url_13), mImageView4);
                        if (mannumber == 4)
                            changeload.displayImage(getString(R.string.dragon_url_12), mImageView5);
                        if (mannumber == 5)
                            changeload.displayImage(getString(R.string.dragon_url_1), mImageView);

                        break;
                    case 2:
                        if (mannumber == 1)
                            changeload.displayImage(getString(R.string.dragon_url_7), mImageView2);
                        if (mannumber == 2)
                            changeload.displayImage(getString(R.string.dragon_url_11), mImageView3);
                        if (mannumber == 4)
                            changeload.displayImage(getString(R.string.dragon_url_11), mImageView5);
                        break;
                    case 3:
                        if (mannumber == 1)
                            changeload.displayImage(getString(R.string.dragon_url_8), mImageView2);
                        if (mannumber == 2)
                            changeload.displayImage(getString(R.string.dragon_url_12), mImageView3);
                        if (mannumber == 4)
                            changeload.displayImage(getString(R.string.dragon_url_14), mImageView5);
                        break;
                    case 4:
                        if (mannumber == 1)
                            changeload.displayImage(getString(R.string.dragon_url_9), mImageView2);
                        break;
                    case 5:
                        break;
                }

            }
        });

        new AlertDialog.Builder(this, 3)
                .setTitle(tittle)
                .setView(listView)

                .setMessage(getString(R.string.dargon_change))
                .setPositiveButton(getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).show();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean isbuy=MySharedPrefernces.getIsBuyed(DuplicateActivity.this);

            if (!isbuy)interstitial.show();
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
