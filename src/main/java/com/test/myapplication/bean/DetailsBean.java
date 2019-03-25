package com.test.myapplication.bean;

/**
 * Created by apple on 2017/3/20.
 */

public class DetailsBean {
    private String equipment_id;
    private String battery_type;
    private String nomial_voltage;
    private String state;
    private String charging_times;

    public String getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(String equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getBattery_type() {
        return battery_type;
    }

    public void setBattery_type(String battery_type) {
        this.battery_type = battery_type;
    }

    public String getNomial_voltage() {
        return nomial_voltage;
    }

    public void setNomial_voltage(String nomial_voltage) {
        this.nomial_voltage = nomial_voltage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCharging_times() {
        return charging_times;
    }

    public void setCharging_times(String charging_times) {
        this.charging_times = charging_times;
    }
}
