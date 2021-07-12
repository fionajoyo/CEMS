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
    private int sonCount;
    public Comment(String cId, String uId, String dId, int cUp, int cDown, String cContent, String cTiming,int sonCount) {
        this.cId = cId;
        this.uId = uId;
        this.dId = dId;
        this.cUp = cUp;
        this.cDown = cDown;
        this.cContent = cContent;
        this.cTiming = cTiming;
        this.sonCount=0; //用于记录父评论的子评论数，子评论不可再被评论(soncount=-1);

    }

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
