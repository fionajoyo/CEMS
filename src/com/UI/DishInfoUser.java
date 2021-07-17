package com.UI;

import com.BaseClass.Comment;
import com.BaseClass.Dish;
import com.DAO.CommentDAO;
import com.DAO.DishDAO;
import com.DAO.UserDAO;
import com.Interface.CommentSystem;
import com.Interface.DishSystem;
import com.Interface.UserManage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DishInfoUser extends JMenub{
    private RoundRectButton lastButton=new RoundRectButton("14.png") ;
    private RoundRectButton nextButton = new RoundRectButton("13.png") ;
    private final Dish dish;
    private Comment[] comment;
    private final DishSystem dishSystem=new DishDAO();
    private UserManage userManage= new UserDAO();
    private final CommentSystem commentSystem=new CommentDAO();
    private JPanel[] commentPanel;//评论框
    private JLabel NowLabel;//评论详情
    private JTextArea[] commentContain;//评论内容
    private JLabel[] DownLabel=new JLabel[5];//点踩
    private JLabel[] UpLabel=new JLabel[5];//点赞框
    private JLabel[] userLabel=new JLabel[5];//评论详情

    public  int page=1;//评论页数
    JFrame frame=new JFrame("菜品信息");
    JPanel panel=new JPanel();

    public DishInfoUser(String dishId) {
        //---
        this.dish = dishSystem.DishReadin(dishId);//获取当前菜品
        System.out.println(dish.getdName());
        getComment(dishId);
        //---

        frame.setSize(1280, 720);//大小
        frame.setLocationRelativeTo(null);//在屏幕中居中显示
        frame.setLayout(null);//边框布局
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 设置X号后关闭

        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201, 175, 138));
        panel.setPreferredSize(new Dimension(1280, 1580));

        JLabel dishInformation = new JLabel("菜品信息");
        dishInformation.setBounds(200, 80, 450, 70);
        dishInformation.setFont(new Font("黑体", Font.BOLD, 60));

        JLabel dishName = new JLabel("菜 品 名:");
        dishName.setBounds(100, 180, 200, 65);
        dishName.setFont(new Font("黑体", Font.BOLD, 40));
        JLabel DishId = new JLabel(dish.getdName());
        DishId.setBounds(300, 180, 450, 65);
        DishId.setFont(new Font("黑体", Font.BOLD, 40));

        JLabel shopNameLabel = new JLabel("店    名:");
        shopNameLabel.setBounds(100, 300, 200, 65);
        shopNameLabel.setFont(new Font("黑体", Font.BOLD, 40));
        JLabel shopName = new JLabel(dish.getdShop());
        shopName.setBounds(300, 300, 450, 65);
        shopName.setFont(new Font("黑体", Font.BOLD, 40));

        JLabel locationLabel = new JLabel("所处区域:");
        locationLabel.setBounds(100, 420, 200, 65);
        locationLabel.setFont(new Font("黑体", Font.BOLD, 40));
        JLabel location = new JLabel(dish.getdLocation());
        location.setBounds(300, 420, 450, 65);
        location.setFont(new Font("黑体", Font.BOLD, 40));

        //改变中
        JLabel pictureLabel = new JLabel();//菜品图片
        pictureLabel.setIcon(dishSystem.readImage(dish));
        pictureLabel.setBounds(630, 60, 600, 450);

        //
        //评论
        newComment();
        //

        //我要评价！
        RoundRectButton commentButton = new RoundRectButton("15.png");
        commentButton.reset(520, 540, 300, 95);
        commentButton.addActionListener(e -> {
            if (e.getSource() == commentButton) {
                new NewComment(dish, this, null, 0, null);
            }
        });


        //这里修改为返回图标
        RoundRectButton returnButton = new RoundRectButton("7.png");
        returnButton.reset(20, 10, 50, 50);
        returnButton.addActionListener(e -> {
            if (e.getSource() == returnButton) {
                frame.dispose();
                new ManagerMenu();
            }
        });

        //这里是下一页按钮

        nextButton.reset(800,1480,100,50);
        nextButton.addActionListener(e -> {
            if(e.getSource()==nextButton){
                if(page*5<comment.length){
                    page++;
                }
                if(page==comment.length/5+1){
                    for(int j=5*page-comment.length;j>=comment.length%5;j--){
                        commentContain[j].setText("");
                        UpLabel[j].setText("");
                        DownLabel[j].setText("");
                        userLabel[j].setText("");
                    }
                }
                flashComment();
            }
        });

        //这里是上一页按钮
        lastButton.reset(400,1480,100,50);

        lastButton.addActionListener(e -> {
            if(e.getSource()==lastButton){
                if(page>1){
                    page--;
                }
                flashComment();
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
        panel.add(commentButton);
        panel.add(returnButton);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        panel.add(nextButton);
        panel.add(lastButton);

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

    public void flashComment(){
        if(page==1)
        {
            lastButton.setVisible(false);

        }
        else {lastButton.setVisible(true);}

        if(page*5>=comment.length)
        {
            nextButton.setVisible(false);
        }
        else {nextButton.setVisible(true);}
        for(int i=0;i<5;i++) {
            if(i+5*(page-1)<comment.length){
                commentContain[i].setText(comment[5*(page-1)+i].getcContent());//得到评论内容
                UpLabel[i].setText(""+comment[5*(page-1)+i].getcUp());
                DownLabel[i].setText(""+comment[5*(page-1)+i].getcDown());
                userLabel[i].setText("来自用户--"+comment[i].getuId()+" 时间："+comment[5*(page-1)+i].getcTiming());
            }
        }
        NowLabel.setText("第"+page+"页");
    }


    public void getComment(String dishId){
        ArrayList<Comment> comments=commentSystem.DishToComment(dishId);//获取评论
        comment=new Comment[comments.size()];
        for (int i=0;i<comments.size();i++){
            comment[i]=comments.get(i);
        }
    }

    public void newComment(){
        //评价
        commentContain=new JTextArea[5];
        commentPanel =new JPanel[5];
        RoundRectButton r;
        for(int i=0;i<5;i++){
            commentPanel[i]=new JPanel();
            commentPanel[i].setLayout(null);
            commentPanel[i].setBounds(190,700+i*150,900,125);
            //panel.setBackground(Color.getHSBColor();
            commentContain[i]= new JTextArea(/*comment[i].getcContent()*/"");//得到评论内容
            commentContain[i].setBounds(0,0,900,100);
            commentContain[i].setLineWrap(true);//自动换行
            commentContain[i].setFont(new Font("楷体",Font.BOLD,20));
            commentContain[i].setEditable(false);

            //三个按钮生成
            r=new RoundRectButton("4.png");//点踩
            r.reset(850,75,25,25);
            int finalI = i;//临时变量
            r.addActionListener(e -> {
                commentSystem.getDown(comment[5*(page-1)+finalI].getcId());
                comment[5*(page-1)+finalI].setcDown(comment[5*(page-1)+finalI].getcDown()+1);
                DownLabel[finalI].setText(""+comment[5*(page-1)+finalI].getcDown());
            });
            commentPanel[i].add(r);
            r=new RoundRectButton("5.png");//点赞
            r.reset(825,75,25,25);
            r.addActionListener(e -> {
                commentSystem.getUp(comment[5*(page-1)+finalI].getcId());
                comment[5*(page-1)+finalI].setcUp(comment[5*(page-1)+finalI].getcUp()+1);
                UpLabel[finalI].setText(""+comment[5*(page-1)+finalI].getcUp());
            });
            commentPanel[i].add(r);
            r=new RoundRectButton("6.png");//跳转评论详情
            r.reset(875,75,25,25);
            r.addActionListener(e -> {
                //跳转评论详情界面
                new DetailComment(dish,comment[5*(page-1)+finalI],this);
            });
            commentPanel[i].add(r);
            commentPanel[i].add(commentContain[i]);
            //三个按钮生成

            //点踩
            DownLabel[i]=new JLabel(""/*comment[i].getcDown()*/);
            DownLabel[i].setBounds(855,100,25,25);
            DownLabel[i].setFont(new Font("黑体",Font.BOLD,15));
            commentPanel[i].add(DownLabel[i]);

            //点赞
            UpLabel[i]=new JLabel(""/*comment[i].getcUp()*/);
            UpLabel[i].setBounds(830,100,25,25);
            UpLabel[i].setFont(new Font("黑体",Font.BOLD,15));
            commentPanel[i].add(UpLabel[i]);

            //用户详情
            userLabel[i]=new JLabel(/*"来自用户--"+userManage.CommentToUser(comment[i].getcId())+" 时间："+comment[5*(page-1)+i].getcTiming()*/);
            userLabel[i].setBounds(10,100,500,25);
            userLabel[i].setFont(new Font("楷体",Font.BOLD,15));
            commentPanel[i].add(userLabel[i]);

            panel.add(commentPanel[i]);
        }
        //页面详情
        NowLabel=new JLabel("第"+page+"页");
        NowLabel.setBounds(600,1490,200,30);
        NowLabel.setFont(new Font("楷体",Font.BOLD,30));
        panel.add(NowLabel);
        //评价
        flashComment();
    }

    public static void main(String[] args) {
        new DishInfoUser("01002");
    }
}
