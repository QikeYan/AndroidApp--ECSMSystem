package com.test.myapplication.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.idtk.smallchart.chart.BarChart;
import com.idtk.smallchart.data.BarData;
import com.idtk.smallchart.interfaces.iData.IBarData;
import com.test.myapplication.R;

import java.util.ArrayList;

public class OverViewActivity extends Activity implements View.OnClickListener {
    protected float[][] points = new float[][]{{1,10}, {2,47}, {3,11}, {4,38}, {5,9},{6,52}, {7,14}, {8,37}, {9,29}, {10,31},{1,10}, {2,47}, {3,11}, {4,38}, {5,9},{6,52}, {7,14}, {8,37}, {9,29}, {10,31},{1,10}, {2,47}, {3,11}, {4,38}};
    protected float[][] points2 = new float[][]{{1,52}, {2,13}, {3,51}, {4,20}, {5,19},{6,20}, {7,54}, {8,7}, {9,19}, {10,41}};
    protected int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private TextView text_today,text_week,text_month,text_year;

private BarChart barChart;
    private ArrayList<IBarData> mDataList = new ArrayList<>();
    private BarData mBarData = new BarData();
    private ArrayList<PointF> mPointArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view);
        initData();
        findViewById();
        onClick();
    }
    private void initData() {
        for (int i = 0; i < 20; i++) {
            mPointArrayList.add(new PointF(points[i][0], points[i][1]));
        }
        mBarData.setValue(mPointArrayList);
        mBarData.setColor(Color.CYAN);
        mBarData.setPaintWidth(pxTodp(5));
        mBarData.setTextSize(pxTodp(10));

        mDataList.add(mBarData);
    }
    private void findViewById() {
        barChart= (BarChart) findViewById(R.id.barChart);
        barChart.setDataList(mDataList);
        barChart.setXAxisUnit("X单位");
        barChart.setYAxisUnit("Y单位");
        text_today= (TextView) findViewById(R.id.text_today);
        text_week= (TextView) findViewById(R.id.text_week);
        text_month= (TextView) findViewById(R.id.text_month);
        text_year= (TextView) findViewById(R.id.text_year);
    }

    private void onClick() {

    }
    protected float pxTodp(float value){
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float valueDP= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,metrics);
        return valueDP;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_today:

                break;
            case R.id.text_week:

                break;
            case R.id.text_month:

                break;
            case R.id.text_year:

                break;
        }
    }
}
