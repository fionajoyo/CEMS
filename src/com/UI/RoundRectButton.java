package com.UI;

import com.DAO.DishDAO;
import com.Interface.DishSystem;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author=fionajoyo
 * @Date 2021/7/14 14:14
 * @Version 3.0
 */
public class RoundRectButton extends JButton {

    public String iconURLHead="http://124.71.236.232:8888/down/ABM9pM78AZsG?fname=/";
    String ss=null;
    URL url=null;

    public RoundRectButton(String s)
    {
        super(s);
        ss=s;
        String filename=".\\image\\"+s;
        setText(null);
        setMargin(new Insets(0,0,0,0));//去除文字与按钮的边沿
        setBorder(null);//圆角矩形边界
        setOpaque(false);
        setContentAreaFilled(false);//取消原先画矩形的设置
        //setBorderPainted(false);//会导致按钮没有明显边界
        setFocusPainted(false);//去除文字周围的虚线框
            ImageIcon ic=new ImageIcon(filename);
            if(ic.getIconWidth()==-1)
            {
                try {
                    url = new URL("http://124.71.236.232:8888/down/ABM9pM78AZsG?fname=/"+s);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                DishSystem dd=new DishDAO();
                dd.download(iconURLHead+s,s, ".\\image\\");
                ic=new ImageIcon(url);
            }


            /*setForeground(Color.WHITE);
            setBackground(new Color(155,22,61));*/
            setBounds(50,300,100,100);
            Image img = ic.getImage();
            Image newimg = img.getScaledInstance(getWidth(),getHeight(),java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(newimg);
            setIcon(icon);
            setOpaque(false);
            setBackground(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray);//按下后按钮变成灰色
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,10,10);//填充圆角矩形边界
        // 这个调用会画一个标签和焦点矩形。
        super.paintComponent(g);
    }

    public void reset(int x,int y,int width,int height)
    {
        setText(null);
        setMargin(new Insets(0,0,0,0));//去除文字与按钮的边沿
        setBorder(null);//圆角矩形边界
        setOpaque(false);
        setContentAreaFilled(false);//取消原先画矩形的设置
        //setBorderPainted(false);//会导致按钮没有明显边界
        setFocusPainted(false);//去除文字周围的虚线框
        ImageIcon ic=new ImageIcon(".\\image\\"+ss);
        setBounds(x,y,width,height);
        Image img = ic.getImage();
        Image newimg = img.getScaledInstance(getWidth(),getHeight(),java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);
        setIcon(icon);
        setOpaque(false);
        setBackground(null);
    }

}
