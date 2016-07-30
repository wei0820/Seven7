package com.jhengweipan.SevenPeopleBook;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.Thunderstormsdivisiononehundredsign.ZeroActivity;
import com.jhengweipan.ga.MyGAManager;

import util.IabHelper;
import util.IabResult;
import util.Inventory;
import util.MySharedPrefernces;

public class HeadPageActivity extends Activity {
    private MediaPlayer mp;
    private AdView adView;
    IabHelper mHelper;
    static final String ITEM_SPONSOR_MONth = "sponsor_month";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_page);
        // 建立 adView。
        MyGAManager.sendScreenName(HeadPageActivity.this,getString(R.string.ga_homeheadPage));

        mHelper = new IabHelper(this, getString(R.string.key));
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    MySharedPrefernces.saveIsBuyed(HeadPageActivity.this, false);
                    Log.d("Jack", "Problem setting up In-app Billing: " + result);
                    return;
                }
                // Hooray, IAB is fully set up!
                MySharedPrefernces.saveIsBuyed(HeadPageActivity.this, false);
                mHelper.queryInventoryAsync(mGotInventoryListener);

            }
        });
//		AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

//
//	    // 啟動一般請求。
//	    AdRequest adRequest = new AdRequest.Builder().build();
//
//	    // 以廣告請求載入 adView。
//	    adView.loadAd(adRequest);
//		LinearLayout myLayout = (LinearLayout) findViewById(R.id.container);
//		AdLocusLayout ALLayout = new AdLocusLayout(this, 
//				AdLocusLayout.AD_SIZE_BANNER, //廣告大小, 可參考下表的ADSIZE, 非平板建議使用此項即可
//				"cd499e695a4171fb3a9d45b8863b872a127951d2",               //app key
//				15                            //輪播時間，最低 15 秒，-1 為不輪播只顯示一則
//				);
//
//		// 設定輪播動畫: 隨機, 置中
//		ALLayout.setTransitionAnimation(AdLocusLayout.ANIMATION_RANDOM);
//		LinearLayout.LayoutParams ALParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//		ALParams.gravity = Gravity.CENTER;
//
//		// 監聽廣告可加入下方範例
//
//		// 加入至您的Layout中
//		myLayout.addView(ALLayout, ALParams);
//		myLayout.setGravity(Gravity.CENTER_HORIZONTAL);
//		myLayout.invalidate();
//		mp = MediaPlayer.create(this, R.raw.music);
//		 mp.start();
//	        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//	            
//	            public void onCompletion(MediaPlayer mp) {
//	                mp.start();
//	            }
//	        });
////
////		
    }

    public void BTC(View v) {
//	 mp.reset();
        MyGAManager.sendActionName(HeadPageActivity.this,"點擊進入","進入選擇頁面");
        Intent i = new Intent();
        i.setClass(this, SevenPeopleBook_MenuActivity.class);
        startActivity(i);


    }
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result,
                                             Inventory inventory) {

            if (result.isFailure()) {
                // handle error here
                Log.d("Jack", "失敗");
                MySharedPrefernces.saveIsBuyed(HeadPageActivity.this, false);
                MyGAManager.sendActionName(HeadPageActivity.this,"購買失敗"," 原因："+result.getMessage() );
                return;
            }
            else {
                // does the user have the premium upgrade?
                Log.d("Jack", "成功開始查詢購買");
                MyGAManager.sendActionName(HeadPageActivity.this, "購買成功", "查詢購買的商品");

                if(inventory.hasPurchase(ITEM_SPONSOR_MONth))
                {
                    MySharedPrefernces.saveIsBuyed(HeadPageActivity.this, true);
                    Log.d("Jack", "成功開始查詢購買");
                    MyGAManager.sendActionName(HeadPageActivity.this, "購買成功",inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle() );

                }
                // update UI accordingly
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }
}

