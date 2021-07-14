package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DishInfoMan extends JMenub{
    public DishInfoMan(){
        JFrame frame=new JFrame("菜品信息");
        JPanel panel=new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));

        JLabel label1=new JLabel("菜品信息");
        label1.setBounds(200,50,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));

        JLabel label2=new JLabel("菜品id");
        label2.setBounds(50,150,100,65);
        label2.setFont(new Font("宋体",Font.BOLD,20));

        JTextField text1=new JTextField(100);
        text1.setBounds(150,150,450,65);
        text1.setFont(new Font("宋体",Font.BOLD,20));

        JLabel label3=new JLabel("菜品名");
        label3.setBounds(50,220,100,65);
        label3.setFont(new Font("宋体",Font.BOLD,20));

        JTextField text2=new JTextField(100);
        text2.setBounds(150,220,450,65);
        text2.setFont(new Font("宋体",Font.BOLD,20));

        JLabel label4=new JLabel("所处区域");
        label4.setBounds(50,290,100,65);
        label4.setFont(new Font("宋体",Font.BOLD,20));

        JTextField text3=new JTextField(100);
        text3.setBounds(150,290,450,65);
        text3.setFont(new Font("宋体",Font.BOLD,20));

        JLabel label5=new JLabel("菜品描述");
        label5.setBounds(50,360,100,65);
        label5.setFont(new Font("宋体",Font.BOLD,20));

        JTextArea text4=new JTextArea("请输入内容",3,100);
        text4.setLineWrap(true);
        text4.setBounds(150,360,450,65);
        text4.setFont(new Font("宋体",Font.BOLD,20));

        JLabel label6=new JLabel("菜品图片");
        label6.setBounds(50,430,100,65);
        label6.setFont(new Font("宋体",Font.BOLD,20));

        JButton button1=new JButton("浏 览");
        button1.setBounds(150,437,100,50);
        button1.setFont(new Font("宋体",Font.BOLD,20));

        JLabel label7=new JLabel("历史评价");
        label7.setBounds(50,500,100,65);
        label7.setFont(new Font("宋体",Font.BOLD,20));

        JTextArea text5=new JTextArea(3,100);
        text5.setBounds(150,500,450,80);
        text5.setFont(new Font("宋体",Font.BOLD,20));


        JButton button3=new JButton("取 消");
        button3.setBounds(250,590,150,65);
        button3.setFont(new Font("宋体",Font.BOLD,30));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button3){
                    frame.dispose();
                    new ManagerMenu();
                }
            }
        });


        panel.add(label1);
        panel.add(label2);
        panel.add(text1);
        panel.add(label3);
        panel.add(text2);
        panel.add(label4);
        panel.add(text3);
        panel.add(label5);
        panel.add(text4);
        panel.add(label6);
        panel.add(button1);
        panel.add(label7);
        panel.add(text5);
        panel.add(button3);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new DishInfoMan();
    }
}
