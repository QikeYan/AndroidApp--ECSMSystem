package com.test.myapplication.histogramview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.test.myapplication.R;

/**
 * Created by apple on 2017/3/14.
 */

public class MyDialog extends Dialog {


    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public MyDialog(Context context,boolean b) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_inside, null);
        setContentView(view);
        //View bv = this.findViewById(android.R.id.title);
        //bv.setVisibility(View.GONE);
    }
}
