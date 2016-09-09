package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;

public class MyListView_twoActivity extends Activity  implements View.OnClickListener{
    private AdView adView,adView2,adView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view_two);
        addFbAd();
        initLayout();
    }

    private void initLayout() {
        findViewById(R.id.mylist_btn).setOnClickListener(this);
        findViewById(R.id.mylist_btn_2).setOnClickListener(this);
        findViewById(R.id.mylist_btn_3).setOnClickListener(this);
    }

    private void addFbAd() {
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

        adView = new AdView(this, "583698071813390_587400221443175", AdSize.BANNER_HEIGHT_50);
        adViewContainer.addView(adView);
        adView.loadAd();
        /////
        RelativeLayout adViewContainer2 = (RelativeLayout) findViewById(R.id.adViewContainer2);

        adView2 = new AdView(this, "583698071813390_587400221443175", AdSize.BANNER_HEIGHT_50);
        adViewContainer2.addView(adView2);
        adView2.loadAd();
        /////
        RelativeLayout adViewContainer3 = (RelativeLayout) findViewById(R.id.adViewContainer3);

        adView3 = new AdView(this, "583698071813390_587400221443175", AdSize.BANNER_HEIGHT_50);
        adViewContainer3.addView(adView3);
        adView3.loadAd();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mylist_btn:
                Intent img1 = new Intent();
                img1.setClass(MyListView_twoActivity.this,ShowImageView_twoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Uri", "1");
                img1.putExtras(bundle);
                startActivity(img1);
                break;
            case R.id.mylist_btn_2:
                Intent img2 = new Intent();
                img2.setClass(MyListView_twoActivity.this,ShowImageView_twoActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("Uri", "2");
                img2.putExtras(bundle2);
                startActivity(img2);

                break;
            case R.id.mylist_btn_3:
                Intent img3 = new Intent();
                img3.setClass(MyListView_twoActivity.this,ShowImageView_twoActivity.class);
                Bundle bundle3 = new Bundle();
                bundle3.putString("Uri", "3");
                img3.putExtras(bundle3);
                startActivity(img3);

                break;
        }

    }
}
