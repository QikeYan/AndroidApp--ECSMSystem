package com.test.myapplication.custom.histogramview.util;

import java.util.Calendar;

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

                result = "Mon";
                break;
            case 2:

                result = "Tue";
                break;
            case 3:

                result = "Wed";
                break;
            case 4:

                result = "Thu";
                break;
            case 5:

                result = "Fri";
                break;
            case 6:

                result = "Sat";
                break;
            case 7:

                result = "Sun";
                break;
        }
        return result;
    }
}
