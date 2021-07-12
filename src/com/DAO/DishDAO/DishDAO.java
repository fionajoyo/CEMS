package com.DAO.DishDAO;

import com.BaseClass.Dish;
import com.DAO.BaseDAO;
import com.Interface.DishReadIn;

import java.io.IOException;
import java.security.PublicKey;
import java.sql.*;
import java.util.Date;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 9:52
 * @Version 1.0
 */
public class DishDAO extends BaseDAO implements DishReadIn {
     public BaseDAO bs=new BaseDAO();



    @Override
    public Dish DishReadin(String dId)
    {
        PreparedStatement pstmt=null;//完全准备清单类，能避免sql注入
        Dish dish = null;
        ResultSet rs=null;
        Connection conn=null;
        String SQL=null;
        try {
            System.out.println(dId);
            conn= bs.getConn();
            SQL="select * from dishtable where d_id=?";
            Object[] param={dId};
            pstmt=conn.prepareStatement(SQL);
            if(param!=null){//若参数非空，传参
                for (int i=0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);//i是0开始，但从1开始替换站位符
                }
            }
            rs=pstmt.executeQuery();//提交，并将结果返回至ResultSet类中
            while(true) {
                try {
                    if (!rs.next()) {
                        break;
                    }
                } catch (SQLException var15) {
                    var15.printStackTrace();
                }
                dish=new Dish(rs);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,pstmt, rs);
        }
        return dish;
    };


}
