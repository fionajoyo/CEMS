package com.Interface;
/**
 * @Author=Anchor
 * @Date 2021/7/12 15:59
 * @Version 1.0
 */
public interface LoginAndRegister {
    /**
     * 登录方法
     * @param uId:用户id
     * @param uPassword:用户密码
     * @return int:uPms用户权限等级，返回-1登录失败，0普通用户，1管理员用户*/
    public int login(String uId,String uPassword);
    /**
     * 注册方法
     * @param uId:用户id
     * @param uName:用户名
     * @param uPassword:用户密码
     * @param uQuestion:设置安全问题
     * @param uAnswer:设置安全回答
     * @param key:密匙，设置后可以成为管理员 114514:普通管理员，0452:超级管理员
     * @return boolean:返回登录成功或失败的布尔值*/
    public boolean register(String uId,String uName,String uPassword,String uQuestion,String uAnswer,int key);
    /**
     * 查询用户安全问题
     * @param uId:用户id
     * @return String:返回安全问题*/
    public String question(String uId);
    /**
     *回答正确安全问题和重置密码
     * @param uId 用户id
     * @param uPassword 用户密码
     * @return boolean:修改密码成功否*/
    public boolean resetPassword(String uAnswer,String uId,String uPassword);
}
