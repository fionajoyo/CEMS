package com.Interface;
import com.BaseClass.Dish;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public  interface DishSystem {
    /**
     * 图片传输(该方法不用显式调用）
     * @param urlString :dish的图片url链接，dish.getImageURL()
     * @param filename  :存放图片名,dish.getdId()+".jpg"
     * @param savePath  :存放图片目录，使用./Image/DishImage*/
    public void download(String urlString, String filename, String savePath);

    /**
     * 查询菜品
     * 点击图片，输入id，返回菜品类
     * @param dId 菜品id
     * @return Dish:返回整个菜品所有信息*/
    public Dish DishReadin(String dId);

    /**
     * 删除菜品
     * @param dId 菜品id
     * @return boolean:删除成功与否*/
    public boolean deleteDish(String dId);

    /**
     * 菜品红榜
     * 返回前5名最受欢迎的菜品
     * @return Dish[5] 返回五个菜品类数组 */
    public Dish[] redDish();

    /**
     * 菜品黑榜
     * 返回前5名最受欢迎的菜品
     * @return Dish[5] 返回五个菜品类数组 */
    public Dish[] blackDish();

    /**
     * 川菜
     * @return 返回菜品数组*/
    public Dish[] CHUANDish();

    /**
     * 徽菜
     * @return 返回菜品数组*/
    public Dish[] WEIDish();

    /**
     * 东北菜
     * @return 返回菜品数组*/
    public Dish[] DONGBEIDish();

    /**
     * 湘菜
     * @return 返回菜品数组*/
    public Dish[] XIANGDish();

    /**读取图片
     * @return ImageIcon图片类*/
    public ImageIcon readImage(Dish dish);
}
