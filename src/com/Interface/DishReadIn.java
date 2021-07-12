package com.Interface;

import com.BaseClass.Dish;

import java.lang.reflect.Parameter;

public interface DishReadIn {
   /**
    * @param dId:点击按钮，传入菜品的dId
    * @return Dish:返回Dish类型
    * */
   public Dish DishReadin(String dId);

}
