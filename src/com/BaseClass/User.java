package com.BaseClass;

import com.DAO.BaseDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 9:11
 * @Version 1.0
 */
public class User {
    private String uId;
    private String uName;
    private String uMail;
    private int uPms;
    private String passWord;
    private String uQuestion;
    private String uAnswer;

    public void getFromSQL()
    {
        BaseDAO bs=new BaseDAO();
        try {
            Connection conn=bs.getConn();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public int getuPms() {
        return uPms;
    }

    public void setuPms(int uPms) {
        this.uPms = uPms;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getuQuestion() {
        return uQuestion;
    }

    public void setuQuestion(String uQuestion) {
        this.uQuestion = uQuestion;
    }

    public String getuAnswer() {
        return uAnswer;
    }

    public void setuAnswer(String uAnswer) {
        this.uAnswer = uAnswer;
    }
}
