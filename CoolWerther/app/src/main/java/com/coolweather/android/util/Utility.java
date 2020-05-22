package com.coolweather.android.util;

import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    //解析省级数据函数；
    public static boolean handleProvinceRequponse(String requponse) {
        if (!TextUtils.isEmpty(requponse)) {
            try {
                JSONArray jsonArray = new JSONArray(requponse);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    Province province = new Province();
                    String name = jsonObject.getString("name");
                    int id = jsonObject.getInt("id");
                    province.setId(id);
                    province.setProvinceName(name);
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //解析市级数据解析；
    public static boolean handleCityRequponse(String requponse, int provinceCode) {
        try {
            JSONArray jsonArray = new JSONArray(requponse);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCity = (JSONObject) jsonArray.get(i);
                City city = new City();
                city.setCityCode(jsonObjectCity.getInt("cityCode"));
                city.setCityName(jsonObjectCity.getString("cityName"));
                city.setId(jsonObjectCity.getInt("id"));
                city.setProvinceCode(provinceCode);
                city.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    //解析县级数据；
    public static boolean handleCountyRequponse(String requponse, int cityCode) {
        try {
            JSONArray jsonArray = new JSONArray(requponse);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCounty = (JSONObject) jsonArray.get(i);
                County county = new County();
                county.setCityId(cityCode);
                county.setId(jsonObjectCounty.getInt("id"));
                county.setWeatherId(jsonObjectCounty.getString("weather_id"));
                county.setCounty(jsonObjectCounty.getString("name"));
                county.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
