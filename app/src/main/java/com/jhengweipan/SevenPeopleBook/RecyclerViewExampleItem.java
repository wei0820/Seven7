package com.jhengweipan.SevenPeopleBook;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jhengweipan.Guandisignonehundred.R;

public class RecyclerViewExampleItem extends FrameLayout {

    TextView tvText;

    public RecyclerViewExampleItem(Context context) {
        super(context);
        inflate(context, R.layout.recyclerview_item, this);
        tvText = ((TextView) findViewById(R.id.tvText));
    }

    public void bind(String str){
        tvText.setText(str);
    }
}
