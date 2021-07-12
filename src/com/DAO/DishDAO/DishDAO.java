package com.DAO.DishDAO;

import com.BaseClass.Dish;
import com.DAO.BaseDAO;
import com.Interface.DishSystem;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 9:52
 * @Version 1.0
 */
public class DishDAO extends BaseDAO implements DishSystem {
     public BaseDAO bs=new BaseDAO();



    @Override
    public Dish DishReadin(String dId)
    {
        PreparedStatement pstmt=null;//完全准备清单类，能避免sql注入
        Dish dish = null;
        ResultSet rs=null;
        Connection conn=null;
        String SQL=null;
        try {
            System.out.println(dId);
            conn= bs.getConn();
            SQL="select * from dishtable where d_id=?";
            Object[] param={dId};
            pstmt=conn.prepareStatement(SQL);
            if(param!=null){//若参数非空，传参
                for (int i=0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);//i是0开始，但从1开始替换站位符
                }
            }
            rs=pstmt.executeQuery();//提交，并将结果返回至ResultSet类中
            while(true) {
                try {
                    if (!rs.next()) {
                        break;
                    }
                } catch (SQLException var15) {
                    var15.printStackTrace();
                }
                dish=new Dish(rs);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn,pstmt, rs);
        }
        return dish;
    };

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
                String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
                String Name=filename.substring(0,filename.lastIndexOf("."));
                // 新的图片文件名 = 编号 +"."图片扩展名
                String newFileName =Name + extensionName;
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



}
