package com.junior.common.dis;

/**
 * @author wangyiwen
 * @version 1.0 Created in 2019-10-21 10:37
 */
public enum SystemTypeEnum {
    USER(0, "用户商城端系统"),
    MERCHANT(1, "商家端"),
    SYSTEM(2, "平台端");

    private int val;
    private String des;

    SystemTypeEnum(int value, String des) {
        this.val = value;
        this.des = des;
    }

    public int val() {
        return val;
    }

    public String des() {
        return des;
    }
}
