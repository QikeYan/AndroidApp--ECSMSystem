package com.test.myapplication.bean;

/**
 * Created by apple on 2017/3/7.
 */

public class StationBean {
    private String number;
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StationBean{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
