package com.UI;

import com.BaseClass.Comment;
import com.BaseClass.Dish;
import com.DAO.CommentDAO;
import com.DAO.DishDAO;
import com.Interface.CommentSystem;
import com.Interface.DishSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

/**
 * @Author=fionajoyo
 * @Date 2021/7/15 10:58
 * @Version 1.0
 */
public class DishClassify {

    private Dish dish;

    private final DishSystem dishSystem=new DishDAO();
    //private final CommentSystem commentSystem=new CommentDAO();
    public  int page=1;//评论页数
    JFrame frame=new JFrame("菜品分类");
    JPanel panel=new JPanel();
public DishClassify() {
    RoundRectButton buttonChuan = new RoundRectButton("18.png");
    RoundRectButton buttonHui = new RoundRectButton("19.png");
    RoundRectButton buttonDongbei = new RoundRectButton("20.png");
    RoundRectButton buttonXiang = new RoundRectButton("21.png");
    frame.setSize(1280,720);//大小
    frame.setLocationRelativeTo(null);//在屏幕中居中显示
    frame.setLayout(null);//边框布局
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    panel.setLayout(null);
    panel.setBackground(Color.getHSBColor(201,175,138));
    panel.setBounds(0,0,1280,720);

    buttonChuan.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {


                                          LoadingPanel glasspane =new LoadingPanel();

                                          glasspane.setBounds(325-100, 360-100, frame.getWidth(), frame.getHeight());
                                          frame.add(glasspane);
                                          frame.setGlassPane(glasspane);
                                          glasspane.setText("Loading data, Please wait ...");
                                          glasspane.start();//开始动画加载效果
                                          //Thread t=glasspane.animation;
                                          java.util.Timer tt=new java.util.Timer();
                                          TimerTask ts=new TimerTask() {
                                              @Override
                                              public void run() {
                                                  new DishClass(1);  //new类一定要放上面
                                                  glasspane.stop();
                                                 //frame.setVisible(false);


                                              }
                                          };
                                          tt.schedule(ts,1000);

                                      }
                                  });
    buttonHui.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            LoadingPanel glasspane =new LoadingPanel();

            glasspane.setBounds(325-100, 360-100, frame.getWidth(), frame.getHeight());
            frame.add(glasspane);
            frame.setGlassPane(glasspane);
            glasspane.setText("Loading data, Please wait ...");
            glasspane.start();//开始动画加载效果
            //Thread t=glasspane.animation;
            java.util.Timer tt=new java.util.Timer();
            TimerTask ts=new TimerTask() {
                @Override
                public void run() {
                    new DishClass(2);  //new类一定要放上面
                    glasspane.stop();
                    //frame.setVisible(false);


                }
            };
            tt.schedule(ts,1000);

        }


    });

    buttonXiang.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            LoadingPanel glasspane =new LoadingPanel();

            glasspane.setBounds(325-100, 360-100, frame.getWidth(), frame.getHeight());
            frame.add(glasspane);
            frame.setGlassPane(glasspane);
            glasspane.setText("Loading data, Please wait ...");
            glasspane.start();//开始动画加载效果
            //Thread t=glasspane.animation;
            java.util.Timer tt=new java.util.Timer();
            TimerTask ts=new TimerTask() {
                @Override
                public void run() {
                    new DishClass(3);  //new类一定要放上面
                    glasspane.stop();
                    //frame.setVisible(false);


                }
            };
            tt.schedule(ts,1000);


        }
    });

    buttonDongbei.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            LoadingPanel glasspane =new LoadingPanel();

            glasspane.setBounds(325-100, 360-100, frame.getWidth(), frame.getHeight());
            frame.add(glasspane);
            frame.setGlassPane(glasspane);
            glasspane.setText("Loading data, Please wait ...");
            glasspane.start();//开始动画加载效果
            //Thread t=glasspane.animation;
            java.util.Timer tt=new java.util.Timer();
            TimerTask ts=new TimerTask() {
                @Override
                public void run() {
                    new DishClass(4);  //new类一定要放上面
                    glasspane.stop();
                    //frame.setVisible(false);


                }
            };
            tt.schedule(ts,1000);

        }

    });
    RoundRectButton FenLeiButton=new RoundRectButton("22.png");
    FenLeiButton.reset(560,170,151,361);

    buttonChuan.reset(70,0,400,300);
    buttonHui.reset(800,0,400,300);
    buttonDongbei.reset(800,350,400,300);
    buttonXiang.reset(70,350,400,300);
   //frame.setJMenuBar(new JMenub());
    panel.add(FenLeiButton);
    panel.add(buttonChuan);
    panel.add(buttonDongbei);
    panel.add(buttonHui);
    panel.add(buttonXiang);

    frame.add(panel);
    frame.setJMenuBar(new JMenub());

    frame.setVisible(true);


}

    public static void main(String[] args) {
        new DishClassify();
    }
}
