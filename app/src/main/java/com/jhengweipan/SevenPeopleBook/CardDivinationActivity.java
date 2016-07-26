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

import util.MySharedPrefernces;

public class CardDivinationActivity extends Activity  {
    private ImageView mImageView;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_divination);
        MyGAManager.sendScreenName(CardDivinationActivity.this, getString(R.string.ga_card));
        addAd();
        initLayout();




    }

    private void initLayout() {
        final int [] photo = {R.drawable.card_gold,R.drawable.card_blaack};

        mImageView = (ImageView)findViewById(R.id.card_img);
        mImageView.setImageResource(R.drawable.user_default);
        mButton =(Button) findViewById(R.id.cord_btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isbuy= MySharedPrefernces.getIsBuyed(CardDivinationActivity.this);

                String cardTime = MySharedPreferences.getMyCardTime(CardDivinationActivity.this);
                if (cardTime.equals("")) cardTime = "0";
                if(System.currentTimeMillis()- Long.valueOf(cardTime)>10*60*1000){
                    int  num1= (int)(Math.random()*2);
                    mImageView.setImageResource(photo[num1]);
                   if (!isbuy)MySharedPreferences.saveMyCardTime(CardDivinationActivity.this,System.currentTimeMillis()+"");
                    if (num1==0)Toast.makeText(CardDivinationActivity.this,"哇！！今天運氣看起來不錯喔！！等等抽卡試試運氣如何！？",Toast.LENGTH_SHORT).show();
                    else Toast.makeText(CardDivinationActivity.this,"今天運氣看起來很背喔！！多做點好事 存點善心",Toast.LENGTH_SHORT).show();
                    MyGAManager.sendActionName(CardDivinationActivity.this,"抽卡","抽到＿"+num1);
                }else {
                   if(!isbuy) {

                       Toast.makeText(CardDivinationActivity.this,"冷卻時間尚未結束喔,請等10分鐘再抽囉!! 偷偷告訴你一個小秘密,點擊畫面某一個東西,會將時間歸零喔",Toast.LENGTH_SHORT).show();
                       MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "冷卻時間未到點擊");
                   }else {
                       Toast.makeText(CardDivinationActivity.this,"您是vip會員,可以無限次抽唷",Toast.LENGTH_SHORT).show();
                       MyGAManager.sendActionName(CardDivinationActivity.this, "抽卡", "已購買商品,並且點擊抽卡");

                   }
                }

            }
        });


    }

    private void addAd() {
        boolean isbuy= MySharedPrefernces.getIsBuyed(CardDivinationActivity.this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (isbuy)mAdView.setVisibility(View.GONE);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Toast.makeText(CardDivinationActivity.this,"時間歸零,快去抽卡試試運氣吧!!",Toast.LENGTH_SHORT).show();
                mImageView.setImageResource(R.drawable.user_default);
                MySharedPreferences.saveMyCardTime(CardDivinationActivity.this, "");
                MyGAManager.sendActionName(CardDivinationActivity.this,"click","Click_Ad");

            }
        });
    }
}









