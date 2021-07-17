package com.UI;

import com.BaseClass.Dish;
import com.DAO.DishDAO;
import com.Interface.DishSystem;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author=fionajoyo
 * @Date 2021/7/15 11:36
 * @Version 1.0
 */
public class DishClass extends JMenub {
    private final DishSystem dishSystem=new DishDAO();
    private static int page=1;
    private static int flag=0;
    private static Dish[] d=null ;  //存放Dish数组

    DishClass(int j)
    {
        String name=null;
        Font f=new Font("黑体", Font.BOLD, 40);
        if(flag==0)  //第一次读时从服务器加载菜品
        {
            flag++;
        switch (j)
        {
            case 1:name="川菜";d=dishSystem.CHUANDish();; break;//川菜
            case 2:name="徽菜";d=dishSystem.WEIDish();break; //徽菜
            case 3:name="湘菜";d=dishSystem.XIANGDish();;break;//湘菜
            case 4:name="鲁菜";d=dishSystem.DONGBEIDish();//鲁菜
        }}
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel panel=new JPanel();
        JPanel inpanel=new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        panel.setPreferredSize(new Dimension(1280,1580));

        inpanel.setLayout(null);
        inpanel.setBackground(Color.getHSBColor(201,175,138));
        inpanel.setPreferredSize(new Dimension(1280,1180));

        frame.setSize(1280, 720);
        frame.setSize(1280,720);//大小
        frame.setLocationRelativeTo(null);//在屏幕中居中显示
        frame.setLayout(null);//边框布局
      //  frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 设置X号后关闭

        RoundRectButton nextButton=new RoundRectButton("13.png");
        RoundRectButton lastButton= new RoundRectButton("14.png");
        nextButton.setVisible(false);
        lastButton.setVisible(false);
        JLabel pageText = new JLabel("第"+page+"/"+(d.length/9+1)+"页");
        pageText.setBounds(250+275+20+20,1067 , 200, 80);
        pageText.setFont(f);
        if(page*9<d.length) {
            nextButton.setVisible(true);
            nextButton.reset(800, 1080, 200, 50);
            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(page<d.length/9+1) {
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
                                page++;

                                new DishClass(j);//new类一定要放上面
                                glasspane.stop();
                                frame.dispose();


                                //frame.setVisible(false);


                            }
                        };
                        tt.schedule(ts,1000);

                    }
                    else {System.out.println("error");}
                }
            });
        }
        if(page!=1) {
            lastButton.setVisible(true);
            lastButton.reset(250, 1080, 200, 50);
            lastButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (page!=1) {
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
                                page--;

                                new DishClass(j);//new类一定要放上面
                                frame.dispose();
                                glasspane.stop();

                                //frame.setVisible(false);


                            }
                        };
                        tt.schedule(ts,1000);


                    }
                    else {
                        System.out.println("error");
                    }
                }
            });
        }




        JLabel[] dishName=new JLabel[9];
        RoundRectButton[] dishButtion =new RoundRectButton[9];  //菜品按钮数组
        //RoundRectButton nextPageButton=new RoundRectButton(" ");
        ActionListener listener=new ActionListener() {
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
                        new DishInfoUser(e.getActionCommand());
                        glasspane.stop();
                        frame.dispose();


                    }
                };
                tt.schedule(ts,500);


            }
        };
        for(int i=0;i<9;i++)
        {
            int x=0;
            int y=0;
            x=10+(i%3)*410;
            y=100+(i/3)*350;

            if(i+(page-1)*9<d.length) {
                inpanel.setPreferredSize(new Dimension(1280,1180));
                dishButtion[i] = new RoundRectButton(d[i + (page - 1) * 9].getdId() + ".jpg");
                dishButtion[i].reset(x, y, 400, 250);
                dishButtion[i].setText(d[i + (page - 1) * 9].getdId());
                dishButtion[i].addActionListener(listener);
                dishName[i] = new JLabel(d[i + (page - 1) * 9].getdName());
                dishName[i].setBounds(x + 110, y - 60, 450, 65);
                dishName[i].setFont(f);
                dishName[i].setForeground(Color.blue);

                inpanel.add(dishName[i]);
                inpanel.add(dishButtion[i]);
            }
        }


        



        /*dishButtion[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page++;
                frame.dispose();
                new DishClass(j);
            }
        });*/
        inpanel.add(nextButton);
        inpanel.add(lastButton);
        inpanel.add(pageText);
        JScrollPane scrollPane = new JScrollPane(
                inpanel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );//滚动布局
        scrollPane.getVerticalScrollBar().setUnitIncrement(24);//加速
        frame.setContentPane(scrollPane);
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);



    }

    public static void main(String[] args) {

        new DishClass(1);

    }
}
