package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;
import com.nostra13.universalimageloader.core.ImageLoader;

import myAppKey.mykey;
import util.MySharedPrefernces;

public class NewsPlayerTeachActivity extends Activity {
    private InterstitialAd interstitial;
    private TextView mTittle_01,mTittle_02,mTittle_03,mTittle_04,mTittle_05,mTittle_06,mTittle_061,mTittle_07,mTittle_08,mTittle_09,mTittle_10,
    mTittle_11,mTittle_12,mTittle_13,mTittle_14,mTittle_15,mTittle_151,mTittle_16,mTittle_17,mTittle_18,mTittle_19,mTittle_20,mTittle_201;
    private ImageView mImag_01,mImag_02,mImag_03,mImag_031,mImag_04,mImag_05,mImag_06,mImag_07,mImag_08,mImag_09,mImag_10,
    mImag_11,mImag_12,mImag_13,mImag_14,mImag_15,mImag_16,mImag_17,mImag_18,mImag_19,mImag_20, mImag_21,mImag_22,mImag_23,mImag_24,mImag_25,mImag_26,mImag_27,mImag_28;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_player_teach);
        boolean isbuy= MySharedPrefernces.getIsBuyed(NewsPlayerTeachActivity.this);

        AdView mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (isbuy)mAdView.setVisibility(View.GONE);

        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-7019441527375550/5879101820");

        // Create ad request.


        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);
        MyGAManager.sendScreenName(NewsPlayerTeachActivity.this, getResources().getString(R.string.ga_newsplayerteach));
        initLayout();

    }

    private void initLayout() {
        ImageLoader loader = ImageLoaderInitializer.Instance(NewsPlayerTeachActivity.this);
        mTittle_01 =(TextView) findViewById(R.id.newsPalaytittle_01);
        mTittle_02 =(TextView) findViewById(R.id.newsPalaytittle_02);
        mTittle_03 =(TextView) findViewById(R.id.newsPalaytittle_03);
        mTittle_04 =(TextView) findViewById(R.id.newsPalaytittle_04);
        mTittle_05 =(TextView) findViewById(R.id.newsPalaytittle_05);
        mTittle_06 =(TextView) findViewById(R.id.newsPalaytittle_06);
        mTittle_061 =(TextView) findViewById(R.id.newsPalaytittle_061);
        mTittle_07 =(TextView) findViewById(R.id.newsPalaytittle_07);
        mTittle_08 =(TextView) findViewById(R.id.newsPalaytittle_08);
        mTittle_09 =(TextView) findViewById(R.id.newsPalaytittle_09);
        mTittle_10 =(TextView) findViewById(R.id.newsPalaytittle_10);
        mTittle_11 =(TextView) findViewById(R.id.newsPalaytittle_11);
        mTittle_12 =(TextView) findViewById(R.id.newsPalaytittle_12);
        mTittle_13 =(TextView) findViewById(R.id.newsPalaytittle_13);
        mTittle_14 =(TextView) findViewById(R.id.newsPalaytittle_14);
        mTittle_15 =(TextView) findViewById(R.id.newsPalaytittle_15);
        mTittle_151 =(TextView) findViewById(R.id.newsPalaytittle_151);
        mTittle_16 =(TextView) findViewById(R.id.newsPalaytittle_16);
        mTittle_17 =(TextView) findViewById(R.id.newsPalaytittle_17);
        mTittle_18 =(TextView) findViewById(R.id.newsPalaytittle_18);
        mTittle_19 =(TextView) findViewById(R.id.newsPalaytittle_19);
        mTittle_20 =(TextView) findViewById(R.id.newsPalaytittle_20);
        mTittle_20 =(TextView) findViewById(R.id.newsPalaytittle_20);
        mTittle_201 =(TextView) findViewById(R.id.newsPalaytittle_201);
        mImag_01 =(ImageView) findViewById(R.id.newplay_img01);
        mImag_02 =(ImageView) findViewById(R.id.newplay_img02);
        mImag_03 =(ImageView) findViewById(R.id.newplay_img03);
        mImag_031 =(ImageView) findViewById(R.id.newplay_img031);

        mImag_04 =(ImageView) findViewById(R.id.newplay_img04);
        mImag_05 =(ImageView) findViewById(R.id.newplay_img05);
        mImag_06 =(ImageView) findViewById(R.id.newplay_img06);
        mImag_07 =(ImageView) findViewById(R.id.newplay_img07);
        mImag_08 =(ImageView) findViewById(R.id.newplay_img08);
        mImag_09 =(ImageView) findViewById(R.id.newplay_img09);
        mImag_10 =(ImageView) findViewById(R.id.newplay_img10);
        mImag_11 =(ImageView) findViewById(R.id.newplay_img11);
        mImag_12 =(ImageView) findViewById(R.id.newplay_img12);
        mImag_13 =(ImageView) findViewById(R.id.newplay_img13);
        mImag_14 =(ImageView) findViewById(R.id.newplay_img14);
        mImag_15 =(ImageView) findViewById(R.id.newplay_img15);
        mImag_16 =(ImageView) findViewById(R.id.newplay_img16);
        mImag_17 =(ImageView) findViewById(R.id.newplay_img17);
        mImag_18 =(ImageView) findViewById(R.id.newplay_img18);
        mImag_19 =(ImageView) findViewById(R.id.newplay_img19);
        mImag_20 =(ImageView) findViewById(R.id.newplay_img20);
        mImag_21 =(ImageView) findViewById(R.id.newplay_img21);
        mImag_22 =(ImageView) findViewById(R.id.newplay_img22);
        mImag_23 =(ImageView) findViewById(R.id.newplay_img23);
        mImag_24 =(ImageView) findViewById(R.id.newplay_img24);
        mImag_25 =(ImageView) findViewById(R.id.newplay_img25);
        mImag_26 =(ImageView) findViewById(R.id.newplay_img26);
        mImag_27 =(ImageView) findViewById(R.id.newplay_img27);
        mImag_28 =(ImageView) findViewById(R.id.newplay_img28);
        String[] tittle = getResources().getStringArray(R.array.newplayteach_tittle);
        String [] url =getResources().getStringArray(R.array.teachurl);
        mTittle_01.setText(tittle[0]);
        loader.displayImage(url[0],mImag_01);
        loader.displayImage(url[1],mImag_02);
        mTittle_02.setText(tittle[1]);
        loader.displayImage(url[2],mImag_03);
        loader.displayImage(url[3],mImag_031);
        mTittle_03.setText(tittle[2]);
        loader.displayImage(url[4],mImag_04);
        mTittle_04.setText(tittle[3]);
        loader.displayImage(url[5],mImag_05);
        mTittle_05.setText(tittle[4]);
        loader.displayImage(url[6],mImag_06);
        mTittle_06.setText(tittle[5]);
        mTittle_061.setText(tittle[6]);
        loader.displayImage(url[7],mImag_07);
        mTittle_07.setText(tittle[7]);
        loader.displayImage(url[8],mImag_08);
        mTittle_08.setText(tittle[8]);
        loader.displayImage(url[9],mImag_09);
        mTittle_09.setText(tittle[9]);
        loader.displayImage(url[10],mImag_10);
        loader.displayImage(url[11],mImag_11);
        mTittle_10.setText(tittle[10]);
        loader.displayImage(url[12],mImag_12);
        mTittle_11.setText(tittle[11]);
        loader.displayImage(url[13],mImag_13);
        loader.displayImage(url[14],mImag_14);
        mTittle_12.setText(tittle[12]);
        loader.displayImage(url[15],mImag_15);
        mTittle_13.setText(tittle[13]);
        loader.displayImage(url[16],mImag_16);
        mTittle_14.setText(tittle[14]);
        loader.displayImage(url[17],mImag_17);
        mTittle_15.setText(tittle[15]);
        loader.displayImage(url[18],mImag_18);
        mTittle_151.setText(tittle[16]);
        loader.displayImage(url[19],mImag_19);
        mTittle_16.setText(tittle[17]);
        loader.displayImage(url[20],mImag_20);
        mTittle_17.setText(tittle[18]);
        loader.displayImage(url[21],mImag_21);
        mTittle_18.setText(tittle[19]);
        loader.displayImage(url[22],mImag_22);
        mTittle_19.setText(tittle[20]);
        loader.displayImage(url[23],mImag_23);
        mTittle_20.setText(tittle[21]);
        loader.displayImage(url[24],mImag_24);
        loader.displayImage(url[25],mImag_25);
        mTittle_201.setText(tittle[22]);
        loader.displayImage(url[26],mImag_26);
        loader.displayImage(url[27],mImag_27);
        loader.displayImage(url[28],mImag_28);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean isbuy=MySharedPrefernces.getIsBuyed(NewsPlayerTeachActivity.this);

           if (!isbuy)interstitial.show();
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
