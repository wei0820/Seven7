package com.jhengweipan.SevenPeopleBook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jhengweipan.Guandisignonehundred.R;
import com.jhengweipan.ga.MyGAManager;

public class ForIdeaAndShareActivity extends Activity implements View.OnClickListener{
    private EditText mNameEdt,mMailEdt,mTiitleEdt,mMessageEdt;
    private Button mSureBtn,mCancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_idea_and_share);
        initLayout();
        MyGAManager.sendScreenName(ForIdeaAndShareActivity.this,getString(R.string.ga_ideaandshare));
    }

    private void initLayout() {
        mNameEdt = (EditText) findViewById(R.id.nameedt);
        mMailEdt = (EditText) findViewById(R.id.mailedt);
        mTiitleEdt = (EditText) findViewById(R.id.tittle);
        mMessageEdt = (EditText) findViewById(R.id.ideaedt);
        mSureBtn = (Button) findViewById(R.id.btn_sure_send);
        mCancelBtn = (Button) findViewById(R.id.btn_cancel_send);
        findViewById(R.id.btn_sure_send).setOnClickListener(this);
        findViewById(R.id.btn_cancel_send).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sure_send:
                MyGAManager.sendActionName(ForIdeaAndShareActivity.this,
                        "sendMail",
                        "Name:"+mNameEdt.getText().toString()+","+
                        "Mail:"+mMailEdt.getText().toString()+","+
                         "Tittle"+mTiitleEdt.getText().toString()+","+
                        "Message"+mMessageEdt.getText().toString());
                new AlertDialog.Builder(this)
                       .setMessage("感謝您的建議與分享！！")
                        .setCancelable(false)
                        .setNegativeButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                ForIdeaAndShareActivity.this.finish();
                            }
                        }).show();
                break;
            case R.id.btn_cancel_send:
                ForIdeaAndShareActivity.this.finish();
                break;
        }

    }

}
