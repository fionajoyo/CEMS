package com;

import com.BaseClass.Dish;
import com.DAO.BaseDAO;
import com.DAO.DishDAO.DishDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 11:32
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        DishDAO ds=new DishDAO();
        Dish dish=ds.DishReadin("01001");


    }
}
