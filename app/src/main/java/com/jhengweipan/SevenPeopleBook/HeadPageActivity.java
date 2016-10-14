package com.jhengweipan.SevenPeopleBook;


import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Geocoder;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.location.Address;


import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.jhengweipan.ga.AnalyticsApplication;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

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
    List<Address> lstAddress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_page);
        // 建立 adView。
        MyGAManager.sendScreenName(HeadPageActivity.this, getString(R.string.ga_homeheadPage));
        MyGAManager myGAManager = new MyGAManager();
        myGAManager.getCampaignParamsFromUrl(HeadPageActivity.this);

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

        try {
            info = getPackageManager().getPackageInfo("com.jhengweipan.SevenPeopleBook", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String KeyResult = new String(Base64.encode(md.digest(), 0));//String something = new String(Base64.encodeBytes(md.digest()));
//                                MyGAManager.sendActionName(HeadPageActivity.this," Location",KeyResult);

            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
        buildGoogleApiClient();
        getAccount();
//        chaeclAPP("com.jackpan.TaiwanpetadoptionApp", "https://play.google.com/store/apps/details?id=com.jackpan.TaiwanpetadoptionApp");
    }

    private boolean getIsInstallApp(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }
    private void getAccount() {
        Log.d(TAG, "in");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS},
                    0);
        }
        Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        Account[] accounts = AccountManager.get(this).getAccounts();
        //取得手機帳號

        for (int i=0; i<accounts.length; i++) {
            if (emailPattern.matcher(accounts[i].name).matches()) {
                String name = accounts[i].name;
                String type = accounts[i].type;
//
                Log.d(TAG,   i + "\n" +
                        name + "\ntype = " +
                        type + "\n");
            }
        }

    }
    private void chaeclAPP(String packageName, String appPath) {
        // 啟動目標應用
        if (getIsInstallApp(packageName)) {
            // 獲取目標應用安裝包的Intent
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            startActivity(intent);
        }
        // 安裝目標應用
        else {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            // 設置目標應用安裝包路徑
//            intent.setDataAndType(Uri.parse((appPath)),"application/vnd.android.package-archive");
//            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
            }
        }
    }

    private void getAppList(String addresss) {
        PackageManager packageManager = this.getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
        final JSONArray jsonArray = new JSONArray();
        HashMap<String, JSONObject> hashMap = new HashMap<>();
        for (PackageInfo packageInfo : packageInfoList) {
//            Log.d(TAG, "getAppList: "+packageInfo.applicationInfo);

            try {
                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("Address",addresss);
//                jsonObject.put("DeviceId",MyApi.getEncodedDeviceId(getApplication()));
//                jsonObject.put("Imei",MyApi.getImeiandSim(getApplication()));
                /**
                             包名獲取方法：packageInfo.packageName

                             icon獲取獲取方法：packageManager.getApplicationIcon(applicationInfo)

                            應用名稱獲取方法：packageManager.getApplicationLabel(applicationInfo)

                            使用許可權獲取方法：packageManager.getPackageInfo(packageName,PackageManager.GET_PERMISSIONS)
                 *
                 * */
//                packageManager.getApplicationIcon(packageInfo.applicationInfo);
                jsonObject.put("PackageName", packageManager.getApplicationLabel(packageInfo.applicationInfo) + "");
                String key = packageInfo.applicationInfo + "";
                hashMap.put(key, jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }

//            Log.d(TAG, "getAppList: " + packageManager.getApplicationLabel(packageInfo.applicationInfo));
//            Log.d(TAG, "getAppList: " + lstAddress);
        }
        for (JSONObject object : hashMap.values()) {
            jsonArray.put(object);
        }
//        Log.d(TAG, "getAppList: " + jsonArray.toString());
        Intent intent = new Intent(HeadPageActivity.this, MyService.class);
        startService(intent);
    }

    public static List<PackageInfo> getAllApps(Context coNtext) {
        List<PackageInfo> apps = new ArrayList<PackageInfo>();
        PackageManager pManager = coNtext.getPackageManager();
        //獲取手機內所有應用
        List<PackageInfo> paklist = pManager.getInstalledPackages(0);
        for (int i = 0; i < paklist.size(); i++) {
            PackageInfo pak = (PackageInfo) paklist.get(i);
            //判斷是否為非系統預裝的應用程式
            if ((pak.applicationInfo.flags & pak.applicationInfo.FLAG_SYSTEM) <= 0) {
                // customs applications
                apps.add(pak);
            }
        }
        return apps;


    }

    public void BTC(View v) {
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
                    Log.d("Jack", "購買" + inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle());
                    MyGAManager.sendActionName(HeadPageActivity.this, "購買成功", inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle());

                }
                if (inventory.hasPurchase(ITEM_MY_VIP)) {
                    MySharedPrefernces.saveIsBuyed(HeadPageActivity.this, true);
                    Log.d("Jack", "購買" + inventory.getSkuDetails(ITEM_SPONSOR_MONth).getTitle());
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

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
            } else {
                // Permission Denied
            }
        }
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

            try {
                lstAddress = gc.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
//                String returnAddress=lstAddress.get(0).getAddressLine(0);
                MyGAManager.sendActionName(HeadPageActivity.this, " Location", lstAddress.get(0).getAddressLine(0));
                getAppList(lstAddress.get(0).getAddressLine(0));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            MyGAManager.sendActionName(HeadPageActivity.this, " Location", "NO Location");
            getAppList("NO Location");
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

}

