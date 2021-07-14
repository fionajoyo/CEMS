package com;

import com.DAO.CommentDAO;
import com.DAO.UserDAO;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 11:32
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) throws Exception {
       /* DishDAO ds = new DishDAO();
        Dish dish = ds.DishReadin("01001");
        Object[] param={new String("01001")};
       ArrayList<String> arrayList= ds.query("select * from dishtable where d_id=?",param,7);
        System.out.println(arrayList.get(6));
        ds.download(dish.getImageURL(),dish.getdId()+".jpg", "./Image/DishImage");*/
        //UserDAO ud=new UserDAO();
        //System.out.println(ud.CommentToUser("010010102"));

        CommentDAO cd=new CommentDAO();
        //cd.DishToComment("01001");
        cd.getDown("010010105");


    }}
