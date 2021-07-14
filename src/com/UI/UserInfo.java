package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfo extends JMenub{
    public UserInfo() {
        JFrame frame = new JFrame("用户信息");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        JLabel label1=new JLabel("用户信息");
        JLabel userLabel = new JLabel("用户名:");           // 创建UserJLabel
        JTextField userText = new JTextField();           // 获取登录名
        JLabel passLabel = new JLabel("密 码:");       // 创建PassJLabel
        JPasswordField passText = new JPasswordField(20); //密码框隐藏
        JLabel evaLabel=new JLabel("历史评价:");
        JTextArea evaText=new JTextArea(3,20);
        JButton button2=new JButton("关闭");

        label1.setBounds(200,50,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));

        userLabel.setBounds(50, 150, 100, 65);
        userLabel.setFont(new Font("宋体",Font.BOLD,20));

        userText.setBounds(150, 150, 450, 65);
        userText.setFont(new Font("宋体",Font.BOLD,20));
        userText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        passLabel.setBounds(50,220 , 100, 65);
        passLabel.setFont(new Font("宋体",Font.BOLD,20));

        passText.setBounds(150, 220, 450, 65);
        passText.setFont(new Font("宋体",Font.BOLD,20));
        passText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        evaLabel.setBounds(50,290,100,65);
        evaLabel.setFont(new Font("宋体",Font.BOLD,14));

        evaText.setBounds(150,290,450,65);
        evaText.setFont(new Font("宋体",Font.BOLD,20));


        button2.setBounds(250,600,150,65);
        button2.setFont(new Font("宋体",Font.BOLD,30));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    frame.dispose();
                    new ManagerMenu();
                }
            }
        });

        panel.add(label1);
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(evaLabel);
        panel.add(evaText);
        panel.add(button2);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);

    }
    public static void main(String[]args){
        new Adduser();
    }
}
