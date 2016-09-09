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

public class MyListView_threeActivity extends Activity {
    private AdView adView;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view_three);
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
        mListView = (ListView) findViewById(R.id.mylistview_listview);
        String[] PageName = getResources().getStringArray(R.array.sevenpeoplename);
        ArrayAdapter<String> pageName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PageName);
        mListView.setAdapter(pageName);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        putBundle("0");
                        break;
                    case 1:
                        putBundle("1");
                        break;
                    case 2:
                        putBundle("2");
                        break;
                    case 3:
                        putBundle("3");
                        break;
                    case 4:
                        putBundle("4");
                        break;
                    case 5:
                        putBundle("5");
                        break;
                    case 6:
                        putBundle("6");
                        break;

                }

            }
        });

    }

    private void putBundle(String string) {
        Intent i = new Intent();
        i.setClass(MyListView_threeActivity.this, ShowPhotoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("Uri", string);
        i.putExtras(bundle);
        startActivity(i);

    }

    @Override
    protected void onDestroy() {
        adView.destroy();
        super.onDestroy();
    }
}
