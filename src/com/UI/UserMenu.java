package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class UserMenu extends JMenub{
    public UserMenu(){
        JFrame frame = new JFrame("用户界面");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        JLabel label=new JLabel("欢迎进入食堂菜品评价系统");
        JButton button=new JButton("查询菜品");
        JButton button1=new JButton("评价菜品");

        label.setBounds(25,50,600,100);
        label.setFont(new Font("宋体",Font.BOLD,40));

        button.setBounds(50,400,200,100);
        button.setFont(new Font("宋体",Font.BOLD,30));
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    frame.dispose();
                    new ShowDishUser();
                }
            }
        });

        button1.setBounds(400,400,200,100);
        button1.setFont(new Font("宋体",Font.BOLD,30));
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button1){
                    frame.dispose();
                    new EvaluateDishUser();
                }
            }
        });
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        panel.add(label);
        panel.add(button);
        panel.add(button1);
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new UserMenu();
    }
}
