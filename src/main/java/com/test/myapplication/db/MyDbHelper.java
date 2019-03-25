package com.test.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by apple on 2017/3/10.
 */

public class MyDbHelper extends SQLiteOpenHelper {


    public MyDbHelper(Context context) {
        super(context, "system.db", null, 1);
    }

    private static MyDbHelper mInstance;

    public synchronized static MyDbHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyDbHelper(context);
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.beginTransaction();//开始事务
        try {
            String sql1 = " CREATE TABLE t_consumption ( "
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + " hour0 VARCHAR ,"
                    + " hour1 VARCHAR ,"
                    + " hour2 VARCHAR ,"
                    + " hour3 VARCHAR ,"
                    + " hour4 VARCHAR ,"
                    + " hour5 VARCHAR ,"
                    + " hour6 VARCHAR ,"
                    + " hour7 VARCHAR ,"
                    + " hour8 VARCHAR ,"
                    + " hour9 VARCHAR ,"
                    + " hour10 VARCHAR ,"
                    + " hour11 VARCHAR ,"
                    + " hour12 VARCHAR ,"
                    + " hour13 VARCHAR ,"
                    + " hour14 VARCHAR ,"
                    + " hour15 VARCHAR ,"
                    + " hour16 VARCHAR ,"
                    + " hour17 VARCHAR ,"
                    + " hour18 VARCHAR ,"
                    + " hour19 VARCHAR ,"
                    + " hour20 VARCHAR ,"
                    + " hour21 VARCHAR ,"
                    + " hour22 VARCHAR ,"
                    + " hour23 VARCHAR ,"
                    + " mon VARCHAR ,"
                    + " tue VARCHAR ,"
                    + " wed VARCHAR , "
                    + " thu VARCHAR ,"
                    + " fri VARCHAR ,"
                    + " sat VARCHAR ,"
                    + " sun VARCHAR ,"
                    + " day1 VARCHAR ,"
                    + " day2 VARCHAR ,"
                    + " day3 VARCHAR ,"
                    + " day4 VARCHAR ,"
                    + " day5 VARCHAR ,"
                    + " day6 VARCHAR ,"
                    + " day7 VARCHAR ,"
                    + " day8 VARCHAR ,"
                    + " day9 VARCHAR ,"
                    + " day10 VARCHAR ,"
                    + " day11 VARCHAR ,"
                    + " day12 VARCHAR ,"
                    + " day13 VARCHAR ,"
                    + " day14 VARCHAR ,"
                    + " day15 VARCHAR ,"
                    + " day16 VARCHAR ,"
                    + " day17 VARCHAR ,"
                    + " day18 VARCHAR ,"
                    + " day19 VARCHAR ,"
                    + " day20 VARCHAR ,"
                    + " day21 VARCHAR ,"
                    + " day22 VARCHAR ,"
                    + " day23 VARCHAR ,"
                    + " day24 VARCHAR ,"
                    + " day25 VARCHAR ,"
                    + " day26 VARCHAR ,"
                    + " day27 VARCHAR ,"
                    + " day28 VARCHAR ,"
                    + " day29 VARCHAR ,"
                    + " day30 VARCHAR ,"
                    + " day31 VARCHAR ) ";
            sqLiteDatabase.execSQL(sql1);
            String sqlSum = "insert into t_consumption(" +
                    "hour0,hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8,hour9,hour10,hour11,hour12,hour13,hour14,hour15,hour16,hour17,hour18,hour19,hour20,hour21,hour22,hour23," +
                    "mon,tue,wed,thu,fri,sat,sun," +
                    "day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24,day25,day26,day27,day28,day29,day30,day31) " +
                    "values ('3040','2000','1100','1000','900','2000','2500','3000','3680','4708','5020','4321','5324','6345','4653','7343','6745','6532','5324','3524','3456','3423','2431'," +
                    "'10200','13400','21000','31240','10034','25670','23140'," +
                    "'34210','10200','13400','21000','31240','20034','25670','23140','44200','34710','60200','53400','31000','31740','41034','53670','43140','34900','34210','32200','53400','28700','31240','20334','25670','33140','34270','44210','40200','23400','51000','21000')";
            sqLiteDatabase.execSQL(sqlSum);
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();//由事务的标志决定是提交事务，还是回滚事务
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
