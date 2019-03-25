package com.test.myapplication.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.test.myapplication.R;
import com.test.myapplication.bean.ConsumptionBean;
import com.test.myapplication.custom.histogramview.util.DateUtils;
import com.test.myapplication.custom.histogramview.util.StepConvertUtil;
import com.test.myapplication.custom.histogramview.views.HistogramView;
import com.test.myapplication.dao.ConsumptionDao;
import com.test.myapplication.util.ConsumptionDateUtil;
import com.test.myapplication.util.NetCallBack;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.test.myapplication.util.ConsumptionDateUtil.getDateTOArrayString;


public class OverViewActivity1 extends Activity {

    private RadioGroup mRadioGroup;
    private HistogramView mHistogram;
    private TextView mTextDate, mTextStep, mTextDistance, mTextCalories, text_name;
    private RadioButton mRadioButtonWeek, mRadioButtonMonth;
    private Toast mToast;
    private HistogramView.HistogramEntity[] mData;
    private ImageView img_back;
    private Intent intent;
    private String name = "";
  //  private ConsumptionHelper consumptionHelper;
    private ConsumptionBean consumptionBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view1);

        ConsumptionDao consumptionDao=new ConsumptionDao();
        consumptionDao.getConsumption(this, "1", new NetCallBack() {
            @Override
            public void onSuccess(String mssage) {
                consumptionBeen= JSONObject.parseObject(mssage, ConsumptionBean.class);
                mHistogram.post(new Runnable() {
                    @Override
                    public void run() {
                        ((RadioButton) findViewById(R.id.radio_week_button)).setChecked(true);
                    }
                });
            }

            @Override
            public void onFail(String strMsg) {

            }
        });

//        consumptionHelper = new ConsumptionHelper(this);
//        consumptionBeen = consumptionHelper.selectConsumption();
//        Log.d("aaa", "q+++++++++++++++" + consumptionBeen.toString());
        mHistogram = (HistogramView) findViewById(R.id.histogram);
        mRadioGroup = (RadioGroup) findViewById(R.id.time_radio_group);
        mTextDate = (TextView) findViewById(R.id.text_date);
        mTextStep = (TextView) findViewById(R.id.text_step);
        text_name = (TextView) findViewById(R.id.text_name);
        mTextDistance = (TextView) findViewById(R.id.text_distance);
        mTextCalories = (TextView) findViewById(R.id.text_calories);
        mRadioButtonWeek = ((RadioButton) findViewById(R.id.radio_week_button));
        mRadioButtonMonth = ((RadioButton) findViewById(R.id.radio_month_button));
        img_back = (ImageView) findViewById(R.id.img_back);
        intent = getIntent();
        name = intent.getStringExtra("name");
        text_name.setText(name);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mRadioButtonMonth.setClickable(false);
                mRadioButtonWeek.setClickable(false);
                switch (checkedId) {
                    case R.id.radio_today_button:
                        if (consumptionBeen!=null)
                        mHistogram.setData(mData = genRandomTodayData());
                        break;
                    case R.id.radio_week_button:
                        if (consumptionBeen!=null)
                        mHistogram.setData(mData = genRandomWeekData());
                        break;
                    case R.id.radio_month_button:
                        if (consumptionBeen!=null)
                        mHistogram.setData(mData = genRandomMonthData());
                        break;
                    case R.id.radio_year_button:
//                        if (consumptionBeen!=null)
//                        mHistogram.setData(mData = genRandomYearData());
                        break;
                }
            }
        });

        mHistogram.setSelectListener(new HistogramView.OnSelectListener() {
            @Override
            public void onSelected(int index) {
                showDetail(mData[index]);
            }
        });

        mHistogram.setAnimationListener(new HistogramView.AnimationListener() {
            @Override
            public void onAnimationDone() {
                mRadioButtonMonth.setClickable(true);
                mRadioButtonWeek.setClickable(true);
                mHistogram.setCheck(mData.length - 1);
            }
        });


    }

    private void showDetail(HistogramView.HistogramEntity data) {
        mTextDate.setText(data.time);
        mTextStep.setText(String.valueOf(data.count) + " kw");
        mTextDistance.setText(StepConvertUtil.stepToDistance(StepConvertUtil.MALE,
                StepConvertUtil.DEFAULT_TALL, data.count) + "");
        mTextCalories.setText(StepConvertUtil.stepToCalories(StepConvertUtil.DEFAULT_TALL,
                StepConvertUtil.DEFAULT_WEIGHT, data.count) + "");
    }

    private void showToast(String s) {
        if (mToast == null) {
            mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(s);
        mToast.show();
    }

    private HistogramView.HistogramEntity[] genRandomTodayData() {
        String[] hours = hourToDay();
        HistogramView.HistogramEntity[] result = new HistogramView.HistogramEntity[24];
        String[] hours_=ConsumptionDateUtil.getDateTOArrayString(consumptionBeen,1);
        for (int i = 0; i < result.length; i++) {

            //int num = (int) (3000 + 2000 * Math.random());
            HistogramView.HistogramEntity e = new HistogramView.HistogramEntity(
                    hours[i], Integer.parseInt(hours_[i]));
            result[i] = e;
        }
        return result;
    }

    private HistogramView.HistogramEntity[] genRandomWeekData() {
        String[] days = daysToWeek();
        HistogramView.HistogramEntity[] result = new HistogramView.HistogramEntity[7];
        String[] week=getDateTOArrayString(consumptionBeen,2);
        for (int i = 0; i < result.length; i++) {

            //int num = (int) (3000 + 2000 * Math.random());
            HistogramView.HistogramEntity e = new HistogramView.HistogramEntity(
                    days[i], Integer.parseInt(week[i]));
            result[i] = e;
        }
        return result;
    }

    private HistogramView.HistogramEntity[] genRandomMonthData() {
        String[] days = daysToDate(31);
        HistogramView.HistogramEntity[] result = new HistogramView.HistogramEntity[31];

        String[] day =getDateTOArrayString(consumptionBeen,3);
        for (int i = 0; i < result.length; i++) {
            //int num = (int) (2000 + 3000 * Math.random());
            HistogramView.HistogramEntity e = new HistogramView.HistogramEntity(
                    String.valueOf(days[i]), Integer.parseInt(day[i]));
            result[i] = e;
        }
        return result;
    }

    private HistogramView.HistogramEntity[] genRandomYearData() {
        String[] days = daysToWeek();
        HistogramView.HistogramEntity[] result = new HistogramView.HistogramEntity[7];
        for (int i = 0; i < result.length; i++) {

            int num = (int) (3000 + 2000 * Math.random());
            HistogramView.HistogramEntity e = new HistogramView.HistogramEntity(
                    days[i], num);
            result[i] = e;
        }
        return result;
    }

    /**
     * 根据天数倒退生成日期
     *
     * @param days 最近多少天
     * @return
     */
    private String[] daysToDate(int days) {
        if (days < 0) {
            return new String[0];
        }
        String[] dates = new String[days];
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, -days);
        for (int i = 0; i < days; i++) {
            calendar.add(Calendar.DATE, 1);
//            dates[i] = (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.DATE);
            dates[i] = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1);
        }
        return dates;
    }

    /**
     * 获取小时
     *
     * @return
     */
    private String[] hourToDay() {
        String[] dates = new String[24];
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                dates[i] = "0" + i + ":00";
            } else {
                dates[i] = i + ":00";
            }
        }
        return dates;
    }

    /**
     * 最近一星期
     *
     * @return
     */
    private String[] daysToWeek() {
        String[] dates = new String[7];
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, -8);
        for (int i = 0; i < 7; i++) {
            calendar.add(Calendar.DATE, 1);
            dates[i] = DateUtils.intToWeek(calendar.get(Calendar.DAY_OF_WEEK));
            Log.d("aaa", "i+++++++" + dates[i]);
        }

        return dates;
    }
}
