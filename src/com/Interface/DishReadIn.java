package com.Interface;

import com.BaseClass.Dish;

import java.lang.reflect.Parameter;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 11:32
 * @Version 1.0
 */
public interface DishReadIn {
   /**
    * @param dId:点击按钮，传入菜品的dId
    * @return Dish:返回Dish类型
    * */
   public Dish DishReadin(String dId);

}
