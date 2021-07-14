package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    public Register() {
        JFrame frame = new JFrame("添加用户");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        JLabel label1=new JLabel("添加用户");
        JLabel userLabel = new JLabel("用户名:");           // 创建UserJLabel
        JTextField userText = new JTextField();           // 获取登录名
        JLabel passLabel = new JLabel("密 码:");       // 创建PassJLabel
        JPasswordField passText = new JPasswordField(20); //密码框隐藏
        JLabel passLabel1=new JLabel("再次输入密码:");
        JPasswordField passText1=new JPasswordField(20);
        JLabel question=new JLabel("安全问题:");
        JTextField questionText=new JTextField(100);
        JLabel answer=new JLabel("回答");
        JTextField answerText=new JTextField("请输入",100);
        JButton button1=new JButton("注册");
        JButton button2=new JButton("登录");
        JButton button3=new JButton("注册");

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

        passLabel1.setBounds(50,290,100,65);
        passLabel1.setFont(new Font("宋体",Font.BOLD,14));

        passText1.setBounds(150,290,450,65);
        passText1.setFont(new Font("宋体",Font.BOLD,20));

        question.setBounds(50,360,100,65);
        question.setFont(new Font("宋体",Font.BOLD,20));

        questionText.setBounds(150,360,450,65);
        questionText.setFont(new Font("宋体",Font.BOLD,20));

        answer.setBounds(50,430,100,65);
        answer.setFont(new Font("宋体",Font.BOLD,20));

        answerText.setBounds(150,430,450,65);
        answerText.setFont(new Font("宋体",Font.BOLD,20));

        button1.setBounds(0,624,325,50);
        button1.setFont(new Font("宋体",Font.BOLD,30));
        button1.setBackground(Color.getHSBColor(201,175,138));
        button1.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(201,175,138), 0, true));
        button1.setEnabled(false);


        button2.setBounds(325,624,325,50);
        button2.setFont(new Font("宋体",Font.BOLD,30));
        button2.setBackground(Color.getHSBColor(230,220,205));
        button2.setBorder(BorderFactory.createLineBorder(Color.RED, 0, true));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    frame.dispose();
                    new Login();
                }
            }
        });

        button3.setBounds(100,500,450,65);
        button3.setBackground(Color.RED);
        button3.setFont(new Font("宋体",Font.BOLD,30));
        button3.setBorder(BorderFactory.createLineBorder(Color.RED, 0, true));
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button3){
                        JOptionPane.showMessageDialog(
                                frame,
                                "注册成功",
                                "消息标题",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                }
            }
        });

        panel.add(label1);
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(passLabel1);
        panel.add(passText1);
        panel.add(question);
        panel.add(questionText);
        panel.add(answer);
        panel.add(answerText);
        panel.add(button1);
        panel.add(button2);
        frame.setVisible(true);

    }
    public static void main(String[]args){
        new Register();
    }
}
