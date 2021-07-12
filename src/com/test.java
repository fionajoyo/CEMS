package com;

import com.BaseClass.Dish;
import com.DAO.BaseDAO;
import com.DAO.DishDAO.DishDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 11:32
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) throws Exception {
        DishDAO ds = new DishDAO();
        Dish dish = ds.DishReadin("01001");
        ds.download(dish.getImageURL(),dish.getdId()+".jpg", "./Image/DishImage");


    }}
