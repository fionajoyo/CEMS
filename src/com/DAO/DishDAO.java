package com.DAO;

import com.BaseClass.Dish;
import com.Interface.DishSystem;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class DishDAO extends BaseDAO implements DishSystem {
    //位于服务器的统一资源定位符
    public String urlHead="http://124.71.236.232:8888/down/iyCulXppgeF9?fname=/";
    @Override
    public Dish DishReadin(String dId){
        String sql="select * from dishtable where d_id=?";
        Object[] param={dId};
        ArrayList<String> obj=query(sql,param,7);
        return new Dish(obj.get(0),obj.get(1),obj.get(2),obj.get(3),Integer.parseInt(obj.get(4)),Integer.parseInt(obj.get(5)), obj.get(6));
    }

    @Override
    public boolean deleteDish(String dId) {
        String sql="delete from dishtable where d_id=?";
        Object[] param={dId};
        return executeSQL(sql,param)>=1;
    }

    @Override
    public Dish[] redDish() {
        Dish[] dishes=new Dish[5];
        String sql="select * from (select * from dishtable order by d_up) where ROWNUM <=5";
        ArrayList<String> obj=query(sql,null,7);
        for (int i=0;i<5;i++){
            dishes[i]=new Dish(obj.get(i*6),obj.get(i*6+1),obj.get(i*6+2),obj.get(i*6+3),Integer.parseInt(obj.get(i*6+4)),Integer.parseInt(obj.get(i*6+5)),obj.get(i*6+6));
        }
        return dishes;
    }

    @Override
    public Dish[] blackDish() {
        Dish[] dishes=new Dish[5];
        String sql="select * from (select * from dishtable order by d_down) where ROWNUM <=5";
        ArrayList<String> obj=query(sql,null,7);
        for (int i=0;i<5;i++){
            dishes[i]=new Dish(obj.get(i*6),obj.get(i*6+1),obj.get(i*6+2),obj.get(i*6+3),Integer.parseInt(obj.get(i*6+4)),Integer.parseInt(obj.get(i*6+5)),obj.get(i*6+6));
        }
        return dishes;
    }

    @Override
    public Dish[] CHUANDish() {
        String sql = "select * from dishtable where d_id like '01___'";
        ArrayList<String> obj = query(sql, null,7);
        Dish[] dishes=new Dish[obj.size()/7];
        for (int i=0;i<dishes.length;i=i+6){
            dishes[i/6]=new Dish(obj.get(i),obj.get(i+1),obj.get(i+2),obj.get(i+3),Integer.parseInt(obj.get(i+4)),Integer.parseInt(obj.get(i+5)),obj.get(i+6));
        }
        return dishes;
    }

    @Override
    public Dish[] WEIDish() {
        String sql = "select * from dishtable where d_id like '02___'";
        ArrayList<String> obj = query(sql, null,7);
        Dish[] dishes=new Dish[obj.size()/7];
        for (int i=0;i<dishes.length;i=i+6){
            dishes[i/6]=new Dish(obj.get(i),obj.get(i+1),obj.get(i+2),obj.get(i+3),Integer.parseInt(obj.get(i+4)),Integer.parseInt(obj.get(i+5)),obj.get(i+6));
        }
        return dishes;
    }

    @Override
    public Dish[] DONGBEIDish() {
        String sql = "select * from dishtable where d_id like '03___'";
        ArrayList<String> obj = query(sql, null,7);
        Dish[] dishes=new Dish[obj.size()/7];
        for (int i=0;i<dishes.length;i=i+6){
            dishes[i/6]=new Dish(obj.get(i),obj.get(i+1),obj.get(i+2),obj.get(i+3),Integer.parseInt(obj.get(i+4)),Integer.parseInt(obj.get(i+5)),obj.get(i+6));
        }
        return dishes;
    }

    @Override
    public Dish[] XIANGDish() {
        String sql = "select * from dishtable where d_id like '04___'";
        ArrayList<String> obj = query(sql, null,7);
        Dish[] dishes=new Dish[obj.size()/7];
        for (int i=0;i<dishes.length;i=i+6){
            dishes[i/6]=new Dish(obj.get(i),obj.get(i+1),obj.get(i+2),obj.get(i+3),Integer.parseInt(obj.get(i+4)),Integer.parseInt(obj.get(i+5)),obj.get(i+6));
        }
        return dishes;
    }

    @Override
    public ImageIcon readImage(Dish dish) {
        String dishPath = ".\\image\\" + dish.getdId() + ".jpg";
        ImageIcon image = null;
        image = new ImageIcon(dishPath);
        if(image.getIconWidth()==-1){
            //如果缺失则再下载一次
            download(urlHead + dish.getdId() + ".jpg", dish.getdId() + ".jpg", "./image");
            URL url= null;
            try {
                url = new URL(urlHead+dish.getdId()+".jpg");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            image = new ImageIcon(url);
        }
        return image;
    }


    @Override
    public void download(String urlString, String filename, String savePath){
        // 构造URL
        URL url = null;
        try {
            url = new URL(urlString);
            URLConnection con = null;
            try {
                con = url.openConnection();
                //设置请求超时为5s
                con.setConnectTimeout(5 * 1000);
                // 输入流
                InputStream is = con.getInputStream();

                // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                int len;
                // 输出的文件流
                File sf = new File(savePath);
                if (!sf.exists()) {
                    sf.mkdirs();
                }
                //String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
                //String Name=filename.substring(0,filename.lastIndexOf("."));
                // 新的图片文件名 = 编号 +"."图片扩展名
                //String newFileName =Name + extensionName;
                OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
                // 开始读取
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                // 完毕，关闭所有链接
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // 打开连接
    }


    public static void main(String[] args) {
        DishDAO d=new DishDAO();
        ImageIcon i= d.readImage(d.DishReadin("01001"));
        System.out.println("查询图片已完成!");
    }
}
