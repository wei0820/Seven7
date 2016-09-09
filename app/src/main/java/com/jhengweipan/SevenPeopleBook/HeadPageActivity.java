package com.jhengweipan.SevenPeopleBook;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Geocoder;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

import util.IabHelper;
import util.IabResult;
import util.Inventory;
import util.MySharedPrefernces;

public class HeadPageActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "HeadPageActivity";
    private MediaPlayer mp;
    private AdView adView;
    IabHelper mHelper;
    static final String ITEM_SPONSOR_MONth = "sponsor_month";
    static final String ITEM_MY_VIP = "my_vip";
    protected Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    PackageInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_page);
        // 建立 adView。
        MyGAManager.sendScreenName(HeadPageActivity.this, getString(R.string.ga_homeheadPage));

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

        try{
            info = getPackageManager().getPackageInfo("com.jhengweipan.SevenPeopleBook",PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures)
            {      MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String KeyResult =new String(Base64.encode(md.digest(),0));//String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", KeyResult);
                Toast.makeText(this,"My FB Key is \n"+ KeyResult , Toast.LENGTH_LONG ).show();
            }
        }catch(PackageManager.NameNotFoundException e1){Log.e("name not found", e1.toString());
        }catch(NoSuchAlgorithmException e){Log.e("no such an algorithm", e.toString());
        }catch(Exception e){Log.e("exception", e.toString());}
        buildGoogleApiClient();

    }

    public void BTC(View v) {
//	 mp.reset();
        MyGAManager.sendActionName(HeadPageActivity.this, "點擊進入", "進入選擇頁面");
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
                MyGAManager.sendActionName(HeadPageActivity.this, "購買失敗", " 原因：" + result.getMessage());
                return;
            } else {
                // does the user have the premium upgrade?
                Log.d("Jack", "成功開始查詢購買");
                MyGAManager.sendActionName(HeadPageActivity.this, "購買成功", "查詢購買的商品");

                if (inventory.hasPurchase(ITEM_SPONSOR_MONth)) {
                    MySharedPrefernces.saveIsBuyed(HeadPageActivity.this, true);
                    Log.d("Jack", "購買"+inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle());
                    MyGAManager.sendActionName(HeadPageActivity.this, "購買成功", inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle());

                }
                if (inventory.hasPurchase(ITEM_MY_VIP)) {
                    MySharedPrefernces.saveIsBuyed(HeadPageActivity.this, true);
                    Log.d("Jack", "購買"+inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle());
                    MyGAManager.sendActionName(HeadPageActivity.this, "購買成功", inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle());
                }
                // update UI accordingly
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            Geocoder gc = new Geocoder(HeadPageActivity.this, Locale.TRADITIONAL_CHINESE);
            List<Address> lstAddress = null;
            try {
                lstAddress = gc.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
//                String returnAddress=lstAddress.get(0).getAddressLine(0);
//                MyGAManager.sendActionName(HeadPageActivity.this," Location",returnAddress);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            MyGAManager.sendActionName(HeadPageActivity.this," Location","NO Location");
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}

