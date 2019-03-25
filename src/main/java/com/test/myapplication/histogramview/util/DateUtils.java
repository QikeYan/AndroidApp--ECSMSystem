package com.test.myapplication.histogramview.util;

import java.util.Calendar;

/**
 * Created by Salmon on 2016/6/21 0021.
 */
public class DateUtils {

    /**
     * calendar转字符串
     *
     * @param calendar
     * @return 格式如："2016-5-25 00:00:00"的字符串
     */
    public static String calendarToString(Calendar calendar) {
        String s = calendar.get(Calendar.YEAR) + "-" +
                (calendar.get(Calendar.MONTH) + 1) + "-" +
                calendar.get(Calendar.DAY_OF_MONTH) + " 00:00:00";
        return s;
    }

    /**
     * 整形转换星期
     *
     * @param index
     * @return
     */
    public static String intToWeek(int index) {
        String result = "";
        switch (index) {
            case 1:
//                result = "一";
                result = "Mon";
                break;
            case 2:
//                result = "二";
                result = "Tue";
                break;
            case 3:
//                result = "三";
                result = "Wed";
                break;
            case 4:
//                result = "四";
                result = "Thu";
                break;
            case 5:
//                result = "五";
                result = "Fri";
                break;
            case 6:
//                result = "六";
                result = "Sat";
                break;
            case 7:
//                result = "日";
                result = "Sun";
                break;
        }
        return result;
    }
}
