package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.test.myapplication.R;
import com.test.myapplication.adapter.DetailsAdapter;
import com.test.myapplication.bean.DetailsBean;
import com.test.myapplication.dao.DetailsDao;
import com.test.myapplication.util.NetCallBack;

import java.util.List;

/**
 * Created by apple on 2017/3/13.
 */

public class StationDetailActivity extends Activity implements View.OnClickListener {
    private ImageView img_back;
    private List<DetailsBean> detailsBeans;
    private Intent intent;
    private TextView Chargingpileid, Textbatterytype, Textnoimalvotage, Textequipmentstate, Textchargingtimes;
    private DetailsAdapter detailsAdapter;
    private RecyclerView recy_list;
    private String name;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_details);
        intent=getIntent();
        name=intent.getStringExtra("name");
        DetailsDao detailsDao=new DetailsDao();
        detailsDao.getDetails(this,name,new NetCallBack() {
            public void onSuccess(String mssage) {
                detailsBeans= JSONObject.parseArray(mssage, DetailsBean.class);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StationDetailActivity.this);
                recy_list.setLayoutManager(layoutManager);
                detailsAdapter = new DetailsAdapter(StationDetailActivity.this, detailsBeans);
                recy_list.setAdapter(detailsAdapter);
                    }

            @Override
            public void onFail(String strMsg) {

            }
        });
        Chargingpileid=(TextView) findViewById(R.id.chargingpileid);
        Textbatterytype=(TextView)findViewById(R.id.textbatterytype);
        Textnoimalvotage=(TextView)findViewById(R.id.textnoimalvotage);
        Textequipmentstate=(TextView)findViewById(R.id.textequipmentstate);
        Textchargingtimes=(TextView)findViewById(R.id.textchargingtimes);
        img_back = (ImageView) findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

         recy_list = (RecyclerView) findViewById(R.id.recy_list2);


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

