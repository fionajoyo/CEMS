package com.Interface;

import com.BaseClass.User;

/**
 * @Author=Anchor
 * @Date 2021/7/12 11:32
 * @Version 1.0
 */

public interface UserManage {
    /**
     * 展示当前登录的用户信息
     * 该方法所有用户可以调用
     * @return User:返回用户类*/
    public User showUserInformation();

    /**
     * 展示所有普通管理员
     * 该方法只有超级管理员可以调用
     * @return User[]:返回普通管理员数组*/
    public User[] showNormalManager();

    /**
     * 展示普通用户
     * 该方法管理员可以调用
     * @return User[]:返回普通用户数组*/
    public User[] showNormalUser();

    /**
     * 删除用户
     * @param user 被删用户
     * @return boolean:删除成功与否*/
    public boolean deleteUser(User user);

    /**
     * 改变用户权限
     * @param user 需要改变权限的用户
     * @param uPms 赋予的权限
     * @return boolean:更改成功与否*/
    public boolean changePermission(User user,int uPms);

    /**评论ID返回用户信息
     * @param cId
     * @return 返回用户name*/
    public String CommentToUser(String cId);
}
