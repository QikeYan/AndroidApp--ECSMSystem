package com.test.myapplication.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.test.myapplication.R;
import com.test.myapplication.adapter.SimpleFragmentPaperAdapter;

/**
 * Created by apple on 2017/4/17.
 */

public class ThirdActivity extends FragmentActivity {

    private SimpleFragmentPaperAdapter pagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon1);
        pagerAdapter = new SimpleFragmentPaperAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
