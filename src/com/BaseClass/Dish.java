package com.BaseClass;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 9:39
 * @Version 1.0
 */
public class Dish {
    private String dId;
    private String dName;
    private String dLocation;
    private String dShop;
    private int dUp;
    private int dDown;
    private String imageURL;

    public Dish(ResultSet rs) throws SQLException {
        dId=rs.getString(1);

        dName=rs.getString(2);

        dLocation=rs.getString(3);

        dShop=rs.getString(4);
        dUp=rs.getInt(5);
        dDown=rs.getInt(6);
        imageURL=rs.getString(7);
        System.out.println("dish初始化");

    }



    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdLocation() {
        return dLocation;
    }

    public void setdLocation(String dLocation) {
        this.dLocation = dLocation;
    }

    public String getdShop() {
        return dShop;
    }

    public void setdShop(String dShop) {
        this.dShop = dShop;
    }

    public int getdUp() {
        return dUp;
    }

    public void setdUp(int dUp) {
        this.dUp = dUp;
    }

    public int getdDown() {
        return dDown;
    }

    public void setdDown(int dDown) {
        this.dDown = dDown;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
