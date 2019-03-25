package com.test.myapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.test.myapplication.bean.ConsumptionBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/3/10.
 */

public class ConsumptionHelper {
    private MyDbHelper myDbHelper;

    public ConsumptionHelper(Context context) {
        myDbHelper = new MyDbHelper(context);
    }

    public List<ConsumptionBean> selectConsumption() {
        List<ConsumptionBean> consumptionBeanList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from t_consumption", new String[]{});
        while (cursor.moveToNext()) {
            ConsumptionBean bean = new ConsumptionBean();
            bean.setHour0(cursor.getString(cursor.getColumnIndex("hour0")));
            bean.setHour1(cursor.getString(cursor.getColumnIndex("hour1")));
            bean.setHour2(cursor.getString(cursor.getColumnIndex("hour2")));
            bean.setHour3(cursor.getString(cursor.getColumnIndex("hour3")));
            bean.setHour4(cursor.getString(cursor.getColumnIndex("hour4")));
            bean.setHour5(cursor.getString(cursor.getColumnIndex("hour5")));
            bean.setHour6(cursor.getString(cursor.getColumnIndex("hour6")));
            bean.setHour7(cursor.getString(cursor.getColumnIndex("hour7")));
            bean.setHour8(cursor.getString(cursor.getColumnIndex("hour8")));
            bean.setHour9(cursor.getString(cursor.getColumnIndex("hour9")));
            bean.setHour10(cursor.getString(cursor.getColumnIndex("hour10")));
            bean.setHour11(cursor.getString(cursor.getColumnIndex("hour11")));
            bean.setHour12(cursor.getString(cursor.getColumnIndex("hour12")));
            bean.setHour13(cursor.getString(cursor.getColumnIndex("hour13")));
            bean.setHour14(cursor.getString(cursor.getColumnIndex("hour14")));
            bean.setHour15(cursor.getString(cursor.getColumnIndex("hour15")));
            bean.setHour16(cursor.getString(cursor.getColumnIndex("hour16")));
            bean.setHour17(cursor.getString(cursor.getColumnIndex("hour17")));
            bean.setHour18(cursor.getString(cursor.getColumnIndex("hour18")));
            bean.setHour19(cursor.getString(cursor.getColumnIndex("hour19")));
            bean.setHour20(cursor.getString(cursor.getColumnIndex("hour20")));
            bean.setHour21(cursor.getString(cursor.getColumnIndex("hour21")));
            bean.setHour22(cursor.getString(cursor.getColumnIndex("hour22")));
            bean.setHour23(cursor.getString(cursor.getColumnIndex("hour23")));
            bean.setMon(cursor.getString(cursor.getColumnIndex("mon")));
            bean.setTue(cursor.getString(cursor.getColumnIndex("tue")));
            bean.setWed(cursor.getString(cursor.getColumnIndex("wed")));
            bean.setThu(cursor.getString(cursor.getColumnIndex("thu")));
            bean.setFri(cursor.getString(cursor.getColumnIndex("fri")));
            bean.setSat(cursor.getString(cursor.getColumnIndex("sat")));
            bean.setSun(cursor.getString(cursor.getColumnIndex("sun")));
            bean.setDay1(cursor.getString(cursor.getColumnIndex("day1")));
            bean.setDay2(cursor.getString(cursor.getColumnIndex("day2")));
            bean.setDay3(cursor.getString(cursor.getColumnIndex("day3")));
            bean.setDay4(cursor.getString(cursor.getColumnIndex("day4")));
            bean.setDay5(cursor.getString(cursor.getColumnIndex("day5")));
            bean.setDay6(cursor.getString(cursor.getColumnIndex("day6")));
            bean.setDay7(cursor.getString(cursor.getColumnIndex("day7")));
            bean.setDay8(cursor.getString(cursor.getColumnIndex("day8")));
            bean.setDay9(cursor.getString(cursor.getColumnIndex("day9")));
            bean.setDay10(cursor.getString(cursor.getColumnIndex("day10")));
            bean.setDay11(cursor.getString(cursor.getColumnIndex("day11")));
            bean.setDay12(cursor.getString(cursor.getColumnIndex("day12")));
            bean.setDay13(cursor.getString(cursor.getColumnIndex("day13")));
            bean.setDay14(cursor.getString(cursor.getColumnIndex("day14")));
            bean.setDay15(cursor.getString(cursor.getColumnIndex("day15")));
            bean.setDay16(cursor.getString(cursor.getColumnIndex("day16")));
            bean.setDay17(cursor.getString(cursor.getColumnIndex("day17")));
            bean.setDay18(cursor.getString(cursor.getColumnIndex("day18")));
            bean.setDay19(cursor.getString(cursor.getColumnIndex("day19")));
            bean.setDay20(cursor.getString(cursor.getColumnIndex("day20")));
            bean.setDay21(cursor.getString(cursor.getColumnIndex("day21")));
            bean.setDay22(cursor.getString(cursor.getColumnIndex("day22")));
            bean.setDay23(cursor.getString(cursor.getColumnIndex("day23")));
            bean.setDay24(cursor.getString(cursor.getColumnIndex("day24")));
            bean.setDay25(cursor.getString(cursor.getColumnIndex("day25")));
            bean.setDay26(cursor.getString(cursor.getColumnIndex("day26")));
            bean.setDay27(cursor.getString(cursor.getColumnIndex("day27")));
            bean.setDay28(cursor.getString(cursor.getColumnIndex("day28")));
            bean.setDay29(cursor.getString(cursor.getColumnIndex("day29")));
            bean.setDay30(cursor.getString(cursor.getColumnIndex("day30")));
            bean.setDay31(cursor.getString(cursor.getColumnIndex("day31")));
            consumptionBeanList.add(bean);
        }
        cursor.close();
        sqLiteDatabase.close();
        return consumptionBeanList;
    }
}
