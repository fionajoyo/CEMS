package com;

import com.DAO.CommentDAO;

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
        CommentDAO cd=new CommentDAO();
        //cd.commentInsert("010010100","yy","gxysbaaaa");
       // cd.fatherCommentInsert("01001","yy","不太像");
        //cd.deleteComment("010010109","yy");
        cd.getUp("010010108");
        cd.getDown("010010108");


    }}
