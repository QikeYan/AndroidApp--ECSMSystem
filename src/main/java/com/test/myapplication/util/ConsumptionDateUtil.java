package com.test.myapplication.util;

import com.test.myapplication.bean.ConsumptionBean;

/**
 * Created by apple on 2017/3/10.
 */

public class ConsumptionDateUtil {
    public static String[] getDateTOArrayString(ConsumptionBean consumptionBean,int tag) {

        switch (tag) {
            case 1:
                String[] hours = new String[24];
                hours[0] = consumptionBean.getHour0();
                hours[1] = consumptionBean.getHour1();
                hours[2] = consumptionBean.getHour2();
                hours[3] = consumptionBean.getHour3();
                hours[4] = consumptionBean.getHour4();
                hours[5] = consumptionBean.getHour5();
                hours[6] = consumptionBean.getHour6();
                hours[7] = consumptionBean.getHour7();
                hours[8] = consumptionBean.getHour8();
                hours[9] = consumptionBean.getHour9();
                hours[10] = consumptionBean.getHour10();
                hours[11] = consumptionBean.getHour11();
                hours[12] = consumptionBean.getHour12();
                hours[13] = consumptionBean.getHour13();
                hours[14] = consumptionBean.getHour14();
                hours[15] = consumptionBean.getHour15();
                hours[16] = consumptionBean.getHour16();
                hours[17] = consumptionBean.getHour17();
                hours[18] = consumptionBean.getHour18();
                hours[19] = consumptionBean.getHour19();
                hours[20] = consumptionBean.getHour20();
                hours[21] = consumptionBean.getHour21();
                hours[22] = consumptionBean.getHour22();
                hours[23] = consumptionBean.getHour23();
                return hours;
            case 2:
                String[] week = new String[7];
                week[0] = consumptionBean.getMon();
                week[1] = consumptionBean.getThu();
                week[2] = consumptionBean.getWed();
                week[3] = consumptionBean.getThu();
                week[4] = consumptionBean.getFri();
                week[5] = consumptionBean.getSat();
                week[6] = consumptionBean.getSun();
                return week;
            case 3:
                String[] day = new String[31];
                day[0] = consumptionBean.getDay1();
                day[1] = consumptionBean.getDay2();
                day[2] = consumptionBean.getDay3();
                day[3] = consumptionBean.getDay4();
                day[4] = consumptionBean.getDay5();
                day[5] = consumptionBean.getDay6();
                day[6] = consumptionBean.getDay7();
                day[7] = consumptionBean.getDay8();
                day[8] = consumptionBean.getDay9();
                day[9] = consumptionBean.getDay10();
                day[10] = consumptionBean.getDay11();
                day[11] = consumptionBean.getDay12();
                day[12] = consumptionBean.getDay13();
                day[13] = consumptionBean.getDay14();
                day[14] = consumptionBean.getDay15();
                day[15] = consumptionBean.getDay16();
                day[16] = consumptionBean.getDay17();
                day[17] = consumptionBean.getDay18();
                day[18] = consumptionBean.getDay19();
                day[19] = consumptionBean.getDay20();
                day[20] = consumptionBean.getDay21();
                day[21] = consumptionBean.getDay22();
                day[22] = consumptionBean.getDay23();
                day[23] = consumptionBean.getDay24();
                day[24] = consumptionBean.getDay25();
                day[25] = consumptionBean.getDay26();
                day[26] = consumptionBean.getDay27();
                day[27] = consumptionBean.getDay28();
                day[28] = consumptionBean.getDay29();
                day[29] = consumptionBean.getDay30();
                day[30] = consumptionBean.getDay31();
                return day;
        }
        return null;
    }
}
