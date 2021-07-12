package com.Interface;

import com.BaseClass.Dish;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 11:32
 * @Version 1.0
 */

public  interface DishSystem {
    /**
     * @param urlString :dish的图片url链接，dish.getImageURL()
     * @param filename  :存放图片名,dish.getdId()+".jpg"
     * @param savePath  :存放图片目录，使用./Image/DishImage*/
    public void download(String urlString, String filename, String savePath);

    public Dish DishReadin(String dId);
}
