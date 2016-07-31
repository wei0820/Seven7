package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.MyAPI.MySharedPreferences;
import com.jhengweipan.ga.MyGAManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import util.MySharedPrefernces;

public class CardDivinationActivity extends Activity {
    private ImageView mImageView;
    private Button mButton;
    private static final String TAG = "CardDivinationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_divination);
        MyGAManager.sendScreenName(CardDivinationActivity.this, getString(R.string.ga_card));
        addAd();
        initLayout();


    }

    private void initLayout() {
        final int[] photo =
                {
                        R.drawable.card_gold,
                        R.drawable.card_blaack,
                        R.drawable.seven1,
                        R.drawable.seven2,
                        R.drawable.seven3,
                        R.drawable.seven4,
                        R.drawable.seven5,
                        R.drawable.seven6,
                        R.drawable.seven7};

        mImageView = (ImageView) findViewById(R.id.card_img);
        mImageView.setImageResource(R.drawable.user_default);
        mButton = (Button) findViewById(R.id.cord_btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isbuy = MySharedPrefernces.getIsBuyed(CardDivinationActivity.this);

                String cardTime = MySharedPreferences.getMyCardTime(CardDivinationActivity.this);

                if (cardTime.equals("")) cardTime = "0";

                if (System.currentTimeMillis() - Long.valueOf(cardTime) > 10 * 60 * 1000) {
                    int num1 = (int) (Math.random() * 50);
                    if (!isbuy)
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, System.currentTimeMillis() + "");
                    if (num1 == 0 || num1 == 9 || num1 == 19 || num1 == 20) {
                        Toast.makeText(CardDivinationActivity.this, "哇！！今天運氣看起來不錯喔！！等等抽卡試試運氣如何！？", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(photo[0]);
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "金卡");
                    } else if (num1 == 2 || num1 == 10) {
                        mImageView.setImageResource(photo[2]);
                        Toast.makeText(CardDivinationActivity.this, "哇！！雷依潔兒！,可以再抽一次！！", Toast.LENGTH_SHORT).show();
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, "");
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "雷依潔兒");
                    } else if (num1 == 3 || num1 == 22 || num1 == 31) {
                        mImageView.setImageResource(photo[3]);
                        Toast.makeText(CardDivinationActivity.this, "哇！！抽到亞依林！,可以再抽一次！！", Toast.LENGTH_SHORT).show();
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, "");
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "亞依林");
                    } else if (num1 == 4 || num1 == 33) {
                        mImageView.setImageResource(photo[4]);
                        Toast.makeText(CardDivinationActivity.this, "哇！！抽到路迪！,抽卡時間改變囉！！", Toast.LENGTH_SHORT).show();
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, 5 * 60 * 1000 + "");
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "路迪");
                    } else if (num1 == 5 || num1 == 13) {

                        mImageView.setImageResource(photo[5]);
                        Toast.makeText(CardDivinationActivity.this, "哇！！抽到克里斯！,可以再抽一次！！", Toast.LENGTH_SHORT).show();
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, "");
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "克里斯");
                    } else if (num1 == 6 || num1 == 21) {
                        mImageView.setImageResource(photo[6]);
                        Toast.makeText(CardDivinationActivity.this, "哇！！抽到傑伊普！,抽卡時間改變囉！！", Toast.LENGTH_SHORT).show();
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, 2 * 60 * 1000 + "");
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "傑伊普");
                    } else if (num1 == 7 || num1 == 46) {
                        mImageView.setImageResource(photo[7]);
                        Toast.makeText(CardDivinationActivity.this, "哇！！抽到斯帕依克！,抽卡時間改變囉！！", Toast.LENGTH_SHORT).show();
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, 60 * 60 * 1000 + "");
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "斯帕依克");
                    } else if (num1 == 8 || num1 == 35) {
                        mImageView.setImageResource(photo[8]);
                        Toast.makeText(CardDivinationActivity.this, "哇！！抽到戴倫斯！,時間增長囉！！", Toast.LENGTH_SHORT).show();
                        MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, 20 * 60 * 1000 + "");
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "戴倫斯");
                    } else {
                        mImageView.setImageResource(photo[1]);
                        Toast.makeText(CardDivinationActivity.this, "今天運氣看起來很背喔！！多做點好事 存點善心", Toast.LENGTH_SHORT).show();
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "抽到" + "黑卡");
                    }

                } else {
                    if (!isbuy) {
                        Toast.makeText(CardDivinationActivity.this, "冷卻時間尚未結束喔,請等時間到再抽囉!! 偷偷告訴你一個小秘密,點擊畫面某一個東西,會將時間歸零喔", Toast.LENGTH_SHORT).show();
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "冷卻時間未到點擊");
                    } else {
                        Toast.makeText(CardDivinationActivity.this, "您是vip會員,可以無限次抽唷", Toast.LENGTH_SHORT).show();
                        MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "已購買商品,並且點擊抽卡");

                    }
                }

            }
        });


    }

    private void addAd() {
        boolean isbuy = MySharedPrefernces.getIsBuyed(CardDivinationActivity.this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (isbuy) mAdView.setVisibility(View.GONE);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Toast.makeText(CardDivinationActivity.this, "時間歸零,快去抽卡試試運氣吧!!", Toast.LENGTH_SHORT).show();
                mImageView.setImageResource(R.drawable.user_default);
                MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, "");
                MyGAManager.sendActionName(CardDivinationActivity.this, "click", "Click_Ad");

            }
        });
    }
}









