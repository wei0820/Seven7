package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.Thunderstormsdivisiononehundredsign.TenActivity;
import com.jhengweipan.ga.MyGAManager;

import java.util.Calendar;

import util.MySharedPrefernces;

public class SuggestActivity extends Activity {
    private TextView mTextView1,mTextView2,mTextView3,mTextView4,mTextView5,mTextView6,mTextView7,
            mTextView8,mTextView9,mTextView10,mTextView11,mTextView12,mTextView13,mTextView14;
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        addAd();
        ininLayout();
    }

    private void ininLayout() {
        MyGAManager.sendScreenName(SuggestActivity.this,getString(R.string.ga_suggest));
        String [] suggest = getResources().getStringArray(R.array.suggest_name);
        mBtn = (Button) findViewById(R.id.suggestBtn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getweek();
            }
        });
        mTextView1 = (TextView) findViewById(R.id.suggest_text_1);
        mTextView2 = (TextView) findViewById(R.id.suggest_text_2);
        mTextView3 = (TextView) findViewById(R.id.suggest_text_3);
        mTextView4 = (TextView) findViewById(R.id.suggest_text_4);
        mTextView5 = (TextView) findViewById(R.id.suggest_text_5);
        mTextView6 = (TextView) findViewById(R.id.suggest_text_6);
        mTextView7 = (TextView) findViewById(R.id.suggest_text_7);
        mTextView8 = (TextView) findViewById(R.id.suggest_text_8);
        mTextView9 = (TextView) findViewById(R.id.suggest_text_9);
        mTextView10 = (TextView) findViewById(R.id.suggest_text_10);
        mTextView11 = (TextView) findViewById(R.id.suggest_text_11);
        mTextView12= (TextView) findViewById(R.id.suggest_text_12);
        mTextView13 = (TextView) findViewById(R.id.suggest_text_13);
        mTextView14 = (TextView) findViewById(R.id.suggest_text_14);
        mTextView1.setText(suggest[0]);
        mTextView2.setText(getString(R.string.suggest_txet_1));
        mTextView3.setText(suggest[1]);
        mTextView4.setText(getString(R.string.suggest_txet_2));
        mTextView5.setText(suggest[2]);
        mTextView6.setText(getString(R.string.suggest_txet_3));
        mTextView7.setText(suggest[3]);
        mTextView8.setText(getString(R.string.suggest_txet_4));

        mTextView9.setText(suggest[4]);
        mTextView10.setText(getString(R.string.suggest_txet_5));
        mTextView11.setText(suggest[5]);
        mTextView12.setText(getString(R.string.suggest_txet_6));
        mTextView13.setText(suggest[6]);
        mTextView14.setText(getString(R.string.suggest_txet_7));

    }

    private void addAd(){
        boolean isbuy= MySharedPrefernces.getIsBuyed(SuggestActivity.this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (isbuy) mAdView.setVisibility(View.GONE);
    }
    private  void getweek(){
        String [] suggest = getResources().getStringArray(R.array.suggest_name);

        Calendar cal = Calendar.getInstance();

        //取得星期幾的整數值
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        MyGAManager.sendActionName(SuggestActivity.this, "點擊重點按鈕", suggest[dayOfWeek]);
        //判斷取得的數值等於星期幾
        switch(dayOfWeek){
            case Calendar.SUNDAY:
                ShowDilog(suggest[6], getString(R.string.suggest_txet_7));


                break;
            case Calendar.MONDAY:
                ShowDilog(suggest[0], getString(R.string.suggest_txet_1));
                break;
            case Calendar.TUESDAY:
                ShowDilog(suggest[1], getString(R.string.suggest_txet_2));
                break;
            case Calendar.WEDNESDAY:
                ShowDilog(suggest[2], getString(R.string.suggest_txet_3));
                break;
            case Calendar.THURSDAY:
                ShowDilog(suggest[3], getString(R.string.suggest_txet_4));
                break;
            case Calendar.FRIDAY:
                ShowDilog(suggest[4], getString(R.string.suggest_txet_5));
                break;
            case Calendar.SATURDAY:
                ShowDilog(suggest[5],getString(R.string.suggest_txet_6));
                break;
        }

    }
    private  void ShowDilog(String tittle,String Message){
        new AlertDialog.Builder(this)
                .setTitle(tittle)
                .setMessage(Message)
                .setPositiveButton(getString(R.string.alert_ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

    }

}
