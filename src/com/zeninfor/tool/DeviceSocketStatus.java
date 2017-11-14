package com.zeninfor.tool;

/**
 * Created by WY on 2017/10/23.
 */
public enum DeviceSocketStatus {

    FREE(1),    // 空闲
    CHARGING(2),// 充电中
    FAULT(3);   //故障


    private final int value;

    DeviceSocketStatus(int value) {
        this.value = value;
    }

    public static DeviceSocketStatus valueOf(int value) {
        for (DeviceSocketStatus r : values()) {
            if (r.value == value) {
                return r;
            }
        }
        throw new IllegalArgumentException("invalid Device Socket Status: " + value);
    }

    public int value() {
        return value;
    }
}
