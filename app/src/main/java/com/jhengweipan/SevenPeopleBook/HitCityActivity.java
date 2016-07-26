package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.Calendar;

import myAppKey.mykey;
import util.MySharedPrefernces;

public class HitCityActivity extends Activity implements  View.OnClickListener {
    private TextView mDayName;
    private TextView mBossName;
    private ImageView mBossphoto;
    private ImageView mPrerequisitesImagView;
    private ImageView mPrerequisitesImagView_2;
    private TextView mEffectName;
    private TextView mBility;
    private InterstitialAd interstitial;
    private TextView mHelpPeople ;
    private TextView mHelpPeople_2;
    private Button mHitCityBtn,mHitCityBtn2,mHitCityBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hit_city);
        boolean isbuy= MySharedPrefernces.getIsBuyed(HitCityActivity.this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (isbuy)mAdView.setVisibility(View.GONE);
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(mykey.ad);


        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);
        MyGAManager.sendScreenName(HitCityActivity.this, getResources().getString(R.string.ga_hitCity));
        initLayout();
        howDat();
    }


    private  void howDat(){
        Calendar calendar =  Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
        ImageLoader loader = ImageLoaderInitializer.Instance(HitCityActivity.this);
        String [] bossUrl = getResources().getStringArray(R.array.sevenpeopleurl);
        String [] bossName = getResources().getStringArray(R.array.sevenpeoplename);
        String [] effectnamearry =getResources().getStringArray(R.array.effectnamearry);
        String [] aility = getResources().getStringArray(R.array.ability);
        switch (week){
            case 1:
                mDayName.setText(getString(R.string.todayis)+getString(R.string.monday));
                loader.displayImage(bossUrl[week - 1], mBossphoto);
                mBossName.setText(getString(R.string.bossis)+bossName[week-1]);
                mEffectName.setText(effectnamearry[week-1]);
                mBility.setText(aility[week-1]);
                mHelpPeople.setText(getString(R.string.monday_name));
                mHelpPeople_2.setText(getString(R.string.monday_name_2));
                loader.displayImage(getString(R.string.monday_phtot),mPrerequisitesImagView);
                loader.displayImage(getString(R.string.monday_phtot_2),mPrerequisitesImagView_2);

                break;
            case 2:
                mDayName.setText(getString(R.string.todayis)+getString(R.string.tuesday));
                loader.displayImage(bossUrl[week-1], mBossphoto);
                mBossName.setText(getString(R.string.bossis)+bossName[week-1]);
                mEffectName.setText(effectnamearry[week-1]);
                mBility.setText(aility[week-1]);
                mHelpPeople.setText(getString(R.string.tuesday_name));
                loader.displayImage(getString(R.string.tuesday_phtot),mPrerequisitesImagView);
                break;
            case 3:
                mDayName.setText(getString(R.string.todayis)+getString(R.string.wednesday));
                loader.displayImage(bossUrl[week-1],mBossphoto);
                mBossName.setText(getString(R.string.bossis)+bossName[week-1]);
                mEffectName.setText(effectnamearry[week-1]);
                mBility.setText(aility[week-1]);
                mHelpPeople.setText(getString(R.string.wednesday_name));
                loader.displayImage(getString(R.string.wednesday_phtot),mPrerequisitesImagView);
                break;
            case 4:
                mDayName.setText(getString(R.string.todayis)+getString(R.string.thurday));
                loader.displayImage(bossUrl[week-1],mBossphoto);
                mBossName.setText(getString(R.string.bossis)+bossName[week-1]);
                mEffectName.setText(effectnamearry[week-1]);
                mBility.setText(aility[week-1]);
                mHelpPeople.setText(getString(R.string.thurday_name));
                loader.displayImage(getString(R.string.thurday_photo),mPrerequisitesImagView);
                break;
            case 5:
                mDayName.setText(getString(R.string.todayis)+getString(R.string.friday));
                loader.displayImage(bossUrl[week-1],mBossphoto);
                mBossName.setText(getString(R.string.bossis)+bossName[week-1]);
                mEffectName.setText(effectnamearry[week-1]);
                mBility.setText(aility[week-1]);
                mHelpPeople.setText(getString(R.string.friday_name));
                loader.displayImage(getString(R.string.friday_photo),mPrerequisitesImagView);

                break;
            case 6:
                mDayName.setText(getString(R.string.todayis)+getString(R.string.saturday));
                loader.displayImage(bossUrl[week - 1], mBossphoto);
                mBossName.setText(getString(R.string.bossis)+bossName[week-1]);
                mEffectName.setText(effectnamearry[week-1]);
                mBility.setText(aility[week-1]);
                mHelpPeople.setText(getString(R.string.saturday_name));
                loader.displayImage(getString(R.string.saturday_photo),mPrerequisitesImagView);
                break;
            case 7:
                mDayName.setText(getString(R.string.todayis)+getString(R.string.sunday));
                loader.displayImage(bossUrl[week-1], mBossphoto);
                mBossName.setText(getString(R.string.bossis)+bossName[week-1]);
                mEffectName.setText(effectnamearry[week-1]);
                mBility.setText(aility[week-1]);
                mHelpPeople.setText(getString(R.string.sunday_name));
                mHelpPeople_2.setText(getString(R.string.sunday_name_2));
                loader.displayImage(getString(R.string.sunday_photo),mPrerequisitesImagView);
                loader.displayImage(getString(R.string.sunday_photo_2),mPrerequisitesImagView_2);

                break;


        }



    }

    private void initLayout() {
        mBossphoto = (ImageView) findViewById(R.id.hitCityImagView);
        mBossName = (TextView) findViewById(R.id.bossname);
        mDayName = (TextView) findViewById(R.id.weekname);
        mEffectName = (TextView) findViewById(R.id.effectText);
        mBility = (TextView) findViewById(R.id.ability);
        mPrerequisitesImagView =(ImageView)findViewById(R.id.prerequisitesImagView);
        mPrerequisitesImagView_2 = (ImageView) findViewById(R.id.prerequisitesImagView2);
        mHelpPeople = (TextView) findViewById(R.id.hitpeopleName);
        mHelpPeople_2 = (TextView) findViewById(R.id.hitpeopleName2);
        mHitCityBtn = (Button) findViewById(R.id.hitCitybutton);
        mHitCityBtn2 =(Button) findViewById(R.id.hitCitybutton2);
        mHitCityBtn3 =(Button) findViewById(R.id.hitCitybutton3);
        findViewById(R.id.hitCitybutton).setOnClickListener(this);
        findViewById(R.id.hitCitybutton2).setOnClickListener(this);
        findViewById(R.id.hitCitybutton3).setOnClickListener(this);



    }

    private ImageLoadingListener onLoadIconImage = new ImageLoadingListener() {
        @Override
        public void onLoadingStarted(String s, View view) {
        }

        @Override
        public void onLoadingFailed(String s, View view, FailReason failReason) {
        }

        @Override
        public void onLoadingComplete(String s, View view, Bitmap bitmap) {

            if (bitmap == null) return;

//            Bitmap corner = ImageHelper.convertToRoundCornerBitmap(getActivity(), bitmap, 20);
//           imagvew.setImageBitmap(corner);//  insert ImagView
//                mBossphoto.setImageBitmap(bitmap);
//            ImageView iv = (ImageView) view;
//            if (iv != null) {
//              iv.setImageBitmap(bitmap);
//            }
        }

        @Override
        public void onLoadingCancelled(String s, View view) {

        }

    };


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            boolean isbuy=MySharedPrefernces.getIsBuyed(HitCityActivity.this);
            if (!isbuy)interstitial.show();
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hitCitybutton:
                showAlert(getString(R.string.hitcitybtn),getString(R.string.hitcitybtnmessage));
                break;
            case R.id.hitCitybutton2:
                showAlert(getString(R.string.hitcitybtn_2),getString(R.string.hitcityBtn2Message));

                break;
            case R.id.hitCitybutton3:
                showAlert(getString(R.string.hitcitybtn_3),getString(R.string.hitcitybtn3Message));
                break;

        }

    }
    private  void showAlert(final String tittle ,String message){
        new AlertDialog.Builder(HitCityActivity.this)
                .setTitle(tittle)
                .setMessage(message)
                .setNegativeButton(getText(R.string.alert_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyGAManager.sendActionName(HitCityActivity.this,tittle,"click");
                        dialog.dismiss();

                    }
                })
                .show();
    }
}
