package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;

public class MyListView_oneActivity extends Activity implements View.OnClickListener{
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view_one);
        initLayout();
        addFbAd();
    }

    private void addFbAd() {
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

        adView = new AdView(this, "583698071813390_587400221443175", AdSize.RECTANGLE_HEIGHT_250);
        adViewContainer.addView(adView);
        adView.loadAd();

    }

    private void initLayout() {
        ImageView  img1 = (ImageView) findViewById(R.id.img_1);
        ImageView  img2= (ImageView) findViewById(R.id.img_2);
        ImageView  img3 = (ImageView) findViewById(R.id.img_3);
        ImageView  img4= (ImageView) findViewById(R.id.img_4);
        findViewById(R.id.img_1).setOnClickListener(this);
        findViewById(R.id.img_2).setOnClickListener(this);
        findViewById(R.id.img_3).setOnClickListener(this);
        findViewById(R.id.img_4).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_1:
                Intent img1 = new Intent();
                img1.setClass(MyListView_oneActivity.this,ShowImageViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Uri", "1");
                img1.putExtras(bundle);
                startActivity(img1);
                break;
            case R.id.img_2:
                Intent img2 = new Intent();
                img2.setClass(MyListView_oneActivity.this,ShowImageViewActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("Uri", "2");
                img2.putExtras(bundle2);
                startActivity(img2);
                break;
            case R.id.img_3:
                Intent img3 = new Intent();
                img3.setClass(MyListView_oneActivity.this,ShowImageViewActivity.class);
                Bundle bundle3 = new Bundle();
                bundle3.putString("Uri", "3");
                img3.putExtras(bundle3);
                startActivity(img3);
                break;
            case R.id.img_4:

                Intent img4 = new Intent();
                img4.setClass(MyListView_oneActivity.this,ShowImageViewActivity.class);
                Bundle bundle4 = new Bundle();
                bundle4.putString("Uri", "4");
                img4.putExtras(bundle4);
                startActivity(img4);

                break;



        }


    }

}
