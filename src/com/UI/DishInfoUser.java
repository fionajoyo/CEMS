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
import java.util.ArrayList;

public class DishInfoUser extends JMenub{
    private Dish dish;
    private Comment[] comment=new Comment[5];
    public static int page=0;//评论页数

    public DishInfoUser(String dishId){
        //---
        DishSystem dishSystem=new DishDAO();
        this.dish=dishSystem.DishReadin(dishId);
        System.out.println(dish.getdName());
        CommentSystem commentSystem=new CommentDAO();
        ArrayList<Comment> comments=commentSystem.DishToComment(dishId);
        for (int i=0;i<5;i++){
            comment[i]=comments.get(i);
        }
        //---

        JFrame frame=new JFrame("菜品信息");
        JPanel panel=new JPanel();
        frame.setSize(1280,720);//大小
        frame.setLocationRelativeTo(null);//在屏幕中居中显示
        frame.setLayout(null);//边框布局
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置X号后关闭

        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        panel.setPreferredSize(new Dimension(1280,1580));

        JLabel dishInformation=new JLabel("菜品信息");
        dishInformation.setBounds(200,100,450,70);
        dishInformation.setFont(new Font("黑体",Font.BOLD,60));

        JLabel dishName=new JLabel("菜 品 名:");
        dishName.setBounds(100,200,200,65);
        dishName.setFont(new Font("黑体",Font.BOLD,40));
        JLabel DishId= new JLabel(dish.getdName());
        DishId.setBounds(300,200,450,65);
        DishId.setFont(new Font("黑体",Font.BOLD,40));

        JLabel shopNameLabel=new JLabel("店    名:");
        shopNameLabel.setBounds(100,320,200,65);
        shopNameLabel.setFont(new Font("黑体",Font.BOLD,40));
        JLabel shopName=new JLabel(dish.getdShop());
        shopName.setBounds(300,320,450,65);
        shopName.setFont(new Font("黑体",Font.BOLD,40));

        JLabel locationLabel=new JLabel("所处区域:");
        locationLabel.setBounds(100,440,200,65);
        locationLabel.setFont(new Font("黑体",Font.BOLD,40));
        JLabel location=new JLabel(dish.getdLocation());
        location.setBounds(300,440,450,65);
        location.setFont(new Font("黑体",Font.BOLD,40));

        //改变中
        JLabel pictureLabel=new JLabel();//菜品图片
        pictureLabel.setIcon(dishSystem.readImage(dish));
        pictureLabel.setBounds(630,80,600,450);

        //评价
        JPanel tempPanel=null;
        JLabel tempLabel=null;
        JTextArea temp=null;
        RoundRectButton r=null;
        for(int i=0;i<5;i++){
            tempPanel=new JPanel();
            tempPanel.setLayout(null);
            tempPanel.setBounds(190,700+i*150,900,100);
            //panel.setBackground(Color.getHSBColor();
            temp= new JTextArea(comment[i].getcContent());//得到评论内容
            temp.setBounds(0,0,900,100);
            temp.setLineWrap(true);//自动换行
            temp.setFont(new Font("楷体",Font.BOLD,20));

            //三个按钮生成
            r=new RoundRectButton("4.png");//点踩
            r.reset(850,75,25,25);
            int finalI = i;//临时变量
            r.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    commentSystem.getDown(comment[finalI].getcId());
                }
            });
            tempPanel.add(r);
            r=new RoundRectButton("5.png");//点赞
            r.reset(825,75,25,25);
            r.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    commentSystem.getUp(comment[finalI].getcId());
                }
            });
            tempPanel.add(r);
            r=new RoundRectButton("6.png");//跳转评论详情
            r.reset(875,75,25,25);
            r.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //跳转评论详情界面
                }
            });
            tempPanel.add(r);
            tempPanel.add(temp);
            //三个按钮生成


            tempLabel=new JLabel();
            tempLabel.setBounds(20,75,200,25);

            panel.add(tempPanel);
        }
        //评价

        //这里修改为返回图标
        RoundRectButton returnButton=new RoundRectButton("7.png");
        returnButton.reset(20,10,250,40);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==returnButton){
                    frame.dispose();
                    new ManagerMenu();
                }
            }
        });

        //-------------
        panel.add(dishInformation);
        panel.add(dishName);
        panel.add(DishId);
        panel.add(shopNameLabel);
        panel.add(shopName);
        panel.add(locationLabel);
        panel.add(location);
        panel.add(pictureLabel);
        panel.add(returnButton);
        panel.add(createuserMenu());
        panel.add(createabountMenu());

        JScrollPane scrollPane = new JScrollPane(
                panel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );//滚动布局
        scrollPane.getVerticalScrollBar().setUnitIncrement(24);//加速

        frame.setContentPane(scrollPane);
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        DishInfoUser dishInfoUser=new DishInfoUser("01001");

    }
}
