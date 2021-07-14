package com.UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ManagerMenu extends JMenub {
    public ManagerMenu(){
        JFrame frame = new JFrame("管理员界面");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        JLabel label=new JLabel("欢迎进入食堂菜品评价系统");
        JButton button=new JButton("查询菜品");
        JButton button1=new JButton("评价菜品");
        JButton button2=new JButton("添加菜品");
        JButton button3=new JButton("删除菜品");
        JButton button4=new JButton("添加用户");
        JButton button5=new JButton("删除用户");
        JButton button6=new JButton("显示用户");

        label.setBounds(25,50,600,100);
        label.setFont(new Font("宋体",Font.BOLD,40));

        button.setBounds(50,200,200,65);
        button.setFont(new Font("宋体",Font.BOLD,30));
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button){
                    frame.dispose();
                    new ShowDishMan();
                }
            }
        });

        button1.setBounds(400,200,200,65);
        button1.setFont(new Font("宋体",Font.BOLD,30));
        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button1){
                    frame.dispose();
                    new EvaluateDishMan();
                }
            }
        });

        button2.setBounds(50,300,200,65);
        button2.setFont(new Font("宋体",Font.BOLD,30));
        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    frame.dispose();
                    new AddDish();
                }
            }
        });

        button3.setBounds(400,300,200,65);
        button3.setFont(new Font("宋体",Font.BOLD,30));
        button3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button3){
                    frame.dispose();
                    new DeleteDish();
                }
            }
        });

        button4.setBounds(50,400,200,65);
        button4.setFont(new Font("宋体",Font.BOLD,30));
        button4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button4){
                    frame.dispose();
                    new Adduser();
                }
            }
        });

        button5.setBounds(400,400,200,65);
        button5.setFont(new Font("宋体",Font.BOLD,30));
        button5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button5){
                    frame.dispose();
                    new Deleteuser();
                }
            }
        });

        button6.setBounds(50,500,200,65);
        button6.setFont(new Font("宋体",Font.BOLD,30));
        button6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button6){
                    frame.dispose();
                    new ShowUser();
                }
            }
        });

        panel.add(createuserMenu());
        panel.add(createabountMenu());
        panel.add(label);
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new ManagerMenu();
    }
}
