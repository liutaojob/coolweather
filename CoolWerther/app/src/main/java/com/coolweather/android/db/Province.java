package com.coolweather.android.db;

import org.litepal.crud.DataSupport;

public class Province extends DataSupport {

    private String provinceName;
    private int id;
    private int provinceCode;

    public Province(String provinceName, int id, int provinceCode) {
        this.provinceName = provinceName;
        this.id = id;
        this.provinceCode = provinceCode;
    }

    public Province() {
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceName='" + provinceName + '\'' +
                ", id=" + id +
                ", provinceCode=" + provinceCode +
                '}';
    }
}
