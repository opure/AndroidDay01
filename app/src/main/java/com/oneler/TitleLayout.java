package com.oneler;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by vanvalt123 on 2016/5/23.
 */
public class TitleLayout extends LinearLayout implements View.OnClickListener {

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button titleBack = (Button) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);
        titleBack.setOnClickListener(this);
        titleEdit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                ((Activity)getContext()).finish();
                break;

            case R.id.title_edit:
                Toast.makeText(getContext(),"点击了编辑按钮", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
