

/**
 * @Author=Anchor
 * @Date 2021/7/12 9:52
 * @Version 1.0
 */
package com.DAO.UserDAO;

import com.DAO.BaseDAO;
import com.Interface.LoginAndRegister;

import java.util.ArrayList;

public class UserDAO extends BaseDAO implements LoginAndRegister {


    @Override
    public int login(String uId, String uPassword) {
        int pms = -1;
        String sql = "select * from usertable where u_id=? and u_password=?";
        Object[] param = {uId, uPassword};
        ArrayList<String> obj = query(sql, param,6);
        pms = Integer.parseInt(obj.get(2));//这里失败默认返回-1吧
        return pms;//返回权限等级
    }

    @Override
    public boolean register(String uId, String uName, String uPassword,String uQuestion,String uAnswer, int key) {
        String sql1 = "select u_id from usertable where u_id=?";
        Object[] param1 = {uId};
        ArrayList<String> obj = query(sql1, param1, 1);
        if (obj.size()!=0)
            return false;
        String sql2 = "insert into usertable values(?,?,?,?,?,?)";
        int temp=0;
        if(key==114514){
            temp=1;
        }else if(key==5402){
            temp=2;
        }
        Object[] param2={uId,uName,temp,uPassword,uQuestion,uAnswer};
        executeSQL(sql2,param2);
        return true;
    }

    @Override
    public String question(String uId) {
        String sql="select u_question from usertable where u_id=?";
        Object[] param={uId};
        ArrayList<String> obj=query(sql,param,1);
        if(obj.size()==0){
            return null;
        }
        return obj.get(0);
    }

    @Override
    public boolean resetPassword(String uAnswer,String uId,String uPassword) {
        String sql1="select u_answer from usertable where u_id=?";
        Object[] param1={uId};
        ArrayList<String> obj=query(sql1,param1,1);
        if(!obj.get(0).equals(uAnswer))
            return false;
        String sql2="update usertable set u_password = ?  where u_id=?";
        Object[] param2={uPassword,uId};
        return executeSQL(sql2, param2) == 1;
    }


    public static void main(String[] args) {//test
        LoginAndRegister L=new UserDAO();
        System.out.println("成功否："+L.register("岩皇","杨y","wssb","我是啥比","yy",114514));
    }
}

