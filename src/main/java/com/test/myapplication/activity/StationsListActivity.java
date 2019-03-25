package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.test.myapplication.R;
import com.test.myapplication.adapter.StationAdapter;
import com.test.myapplication.bean.StationBean;

import java.util.ArrayList;

/**
 * Created by apple on 2017/3/7.
 */

public class StationsListActivity extends Activity implements View.OnClickListener {
    private ImageView img_back;
    private RecyclerView recy_list;
    private StationAdapter stationAdapter;
    private int tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations_list);
        findViewById();
        setClick();
        init();
    }

    private void findViewById() {
        img_back = (ImageView) findViewById(R.id.img_back);
        recy_list = (RecyclerView) findViewById(R.id.recy_list);
    }

    private void setClick() {
        img_back.setOnClickListener(this);
    }

    private void init() {
        tag = getIntent().getIntExtra("tag", 0);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recy_list.setLayoutManager(layoutManager);
        stationAdapter = new StationAdapter(this, new ArrayList<StationBean>());
        recy_list.setAdapter(stationAdapter);
        stationAdapter.setOnClickItimListener(new StationAdapter.OnClickItimListener() {
            @Override
            public void OnClickItim(View view, Object data) {
//                Toast.makeText(StationsListActivity.this, data.toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                if (tag == 1) {
                    intent.setClass(StationsListActivity.this, OverViewActivity1.class);
                }
                if (tag == 2) {
                    intent.setClass(StationsListActivity.this, StationDetailActivity.class);
                }
                Toast.makeText(StationsListActivity.this, ((StationBean) data).getNumber(),Toast.LENGTH_LONG).show();
               // intent.putExtra("name", "Electricity Consumption Sum Of " + ((StationBean) data).getNumber() + " Stations");
                intent.putExtra("name",((StationBean) data).getNumber());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
