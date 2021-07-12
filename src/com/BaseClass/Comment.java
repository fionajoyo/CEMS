package com.BaseClass;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 9:39
 * @Version 1.0
 */
public class Comment {

    private String cId;
    private String uId;
    private String dId;
    private int cUp;
    private int cDown;
    private String cContent;
    private String cTiming;




    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public int getcUp() {
        return cUp;
    }

    public void setcUp(int cUp) {
        this.cUp = cUp;
    }

    public int getcDown() {
        return cDown;
    }

    public void setcDown(int cDown) {
        this.cDown = cDown;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public String getcTiming() {
        return cTiming;
    }

    public void setcTiming(String cTiming) {
        this.cTiming = cTiming;
    }
}
