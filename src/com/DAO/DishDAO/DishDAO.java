package com.DAO.DishDAO;

import com.BaseClass.Dish;
import com.DAO.BaseDAO;
import com.Interface.DishReadIn;

import java.io.IOException;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 9:52
 * @Version 1.0
 */
public class DishDAO extends BaseDAO implements DishReadIn {
     public BaseDAO bs=new BaseDAO();
    @Override
    public void DishReadin(String dId)
    {
        try {
            Connection conn= bs.getConn();
            String presSQL="select * from ";

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    };


}
