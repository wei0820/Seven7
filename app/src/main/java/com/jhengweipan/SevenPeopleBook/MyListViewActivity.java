package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

public class MyListViewActivity extends Activity {
    private AdView adView;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);
        MyGAManager.sendScreenName(this,getString(R.string.ga_mylist));
        initLayout();
        addFbAd();
    }

    private void addFbAd() {
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

        adView = new AdView(this, "583698071813390_587400221443175", AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();
    }

    private void initLayout() {
        mListView = (ListView) findViewById(R.id.mylistview_listview);
        String[] PageName = {"新四皇","舊四皇","七騎士"};
        ArrayAdapter<String> pageName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PageName);
        mListView.setAdapter(pageName);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent zero = new Intent();
                        zero.setClass(MyListViewActivity.this,MyListView_oneActivity.class);
                        startActivity(zero);
                        break;
                    case 1:

                        Intent one = new Intent();
                        one.setClass(MyListViewActivity.this,MyListView_twoActivity.class);
                        startActivity(one);
                        break;
                    case 2:

                        Intent two = new Intent();
                        two.setClass(MyListViewActivity.this,MyListView_threeActivity.class);
                        startActivity(two);
                        break;


                }

            }
        });

    }
    @Override
    protected void onDestroy() {
        adView.destroy();
        super.onDestroy();
    }
}
