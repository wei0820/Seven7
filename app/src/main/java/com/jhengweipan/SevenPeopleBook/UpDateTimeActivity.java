package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import myAppKey.mykey;
import util.MySharedPrefernces;

public class UpDateTimeActivity extends Activity {
    private InterstitialAd interstitial;
    private TextView mTextView, mTextView_2, mTextView_3, mTextView_4, mTextView_5, mTextView_6,
            mTextView_7,mTextView_8,mTextView_9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date_time);

        addAd();
        getTime();
        initLayout();
    }

    private void getTime() {
        String locale = getResources().getConfiguration().locale.getDisplayName();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date dt=new Date();
        MyGAManager.sendActionName(UpDateTimeActivity.this, " 登入地區/時間", locale + "" +sdf.format(dt));


    }

    private void addAd() {
        boolean isbuy= MySharedPrefernces.getIsBuyed(UpDateTimeActivity.this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (isbuy)mAdView.setVisibility(View.GONE);

    }

    private void initLayout() {
        Calendar mCalendar = Calendar.getInstance();
        int nowTime =mCalendar.get(Calendar.HOUR_OF_DAY);
        if(nowTime ==0) nowTime =24;
        mTextView = (TextView) findViewById(R.id.update_text1);
        mTextView_2 = (TextView) findViewById(R.id.update_text2);
        mTextView_3 = (TextView) findViewById(R.id.update_text3);
        mTextView_4 = (TextView) findViewById(R.id.update_text4);
        mTextView_5 = (TextView) findViewById(R.id.update_text5);
        mTextView_6 = (TextView) findViewById(R.id.update_text6);
        mTextView_7 = (TextView) findViewById(R.id.update_text7);
        mTextView_8 = (TextView) findViewById(R.id.update_text8);
        mTextView_9 = (TextView) findViewById(R.id.update_text9);

        mTextView.setText(getString(R.string.updata_1));
        mTextView_2.setText(getString(R.string.updata_2));
        mTextView_3.setText(getString(R.string.updata_3));
        mTextView_4.setText(getString(R.string.updata_4));
        mTextView_5.setText(getString(R.string.updata_5));
        mTextView_6.setText(getString(R.string.updata_6));
        mTextView_7.setText("離公會簽到結算還有約：" + (24 - nowTime + 6) + "小時" + "\n\n" +
                        "離攻城戰結算還有約：" + (24 - nowTime + 7) + "小時" + "\n\n" +
                        "離一日刪除好友結算還有約：" + (24 - nowTime + 8) + "小時" + "\n\n" +
                        "離一日贈送名譽結算還有約：" + (24 - nowTime + 8) + "小時" + "\n\n" +
                        "離每日副本結算還有約：" + (24 - nowTime + 8) + "小時" + "\n\n" +
                        "離一天一百隻英雄30級限制更新結算還有約：" + (24 - nowTime + 8) + "小時" + "\n\n"
        );
       int monday= mCalendar.get(Calendar.DAY_OF_WEEK);
        int monthDay = mCalendar.get(Calendar.DAY_OF_MONTH);
       if(monday==2&&nowTime<15) mTextView_8.setText("離每週任務結算還有約："+(24-nowTime+8)+"小時"+ "\n\n" +
               "離決鬥場成績結算還有約："+(24-nowTime+12)+"小時"+ "\n\n" +
               "離決鬥場開放還有約："+(24-nowTime+14)+"小時" );
       if(monthDay==1&&nowTime<9)mTextView_9.setText("離每月任務結算還有約："+(24-nowTime+8)+"小時");
        MyGAManager.sendScreenName(UpDateTimeActivity.this, getString(R.string.ga_updatetime));

    }

    
}
