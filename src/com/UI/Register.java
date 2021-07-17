package com.UI;

import com.DAO.UserDAO;
import com.Interface.LoginAndRegister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    public Register() {
        UserDAO ud=new UserDAO();
        JFrame frame = new JFrame("用户注册");
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240,213,175));
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(new Color(201,175,138));

        JTextField idtext=new JTextField();         //获取id
        JLabel idlabel = new JLabel("账号");
        JLabel label1=new JLabel("用户注册");
        JLabel userLabel = new JLabel("昵称:");           // 创建UserJLabel
        JTextField userText = new JTextField();           // 获取登录名
        JLabel passLabel = new JLabel("密 码:");       // 创建PassJLabel
        JPasswordField passText = new JPasswordField(20); //密码框隐藏
        JLabel passLabel1=new JLabel("再次输入密码:");
        JPasswordField passText1=new JPasswordField(20);
        JLabel question=new JLabel("安全问题:");
        JTextField questionText=new JTextField(100);
        JLabel answer=new JLabel("回答");
        JTextField answerText=new JTextField("请输入",100);
        RoundRectButton button1=new RoundRectButton("11.png");
        RoundRectButton button2=new RoundRectButton("12.png");
        RoundRectButton button3=new RoundRectButton("3.png");

        label1.setBounds(250,10,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));
        idlabel.setBounds(50, 150+11-70, 100, 54);
        idlabel.setFont(new Font("宋体",Font.BOLD,20));
        idtext.setBounds(150, 150+11-70, 450, 54);
        idtext.setFont(new Font("宋体",Font.BOLD,20));
        userLabel.setBounds(50, 150+11, 100, 54);
        userLabel.setFont(new Font("宋体",Font.BOLD,20));

        userText.setBounds(150, 150+11, 450, 54);
        userText.setFont(new Font("宋体",Font.BOLD,20));
        userText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        passLabel.setBounds(50,220+11 , 100, 54);
        passLabel.setFont(new Font("宋体",Font.BOLD,20));

        passText.setBounds(150, 220+11, 450, 54);
        passText.setFont(new Font("宋体",Font.BOLD,20));
        passText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        passLabel1.setBounds(50,290+11,100,54);
        passLabel1.setFont(new Font("宋体",Font.BOLD,14));

        passText1.setBounds(150,290+11,450,54);
        passText1.setFont(new Font("宋体",Font.BOLD,20));

        question.setBounds(50,360+11,100,54);
        question.setFont(new Font("宋体",Font.BOLD,20));

        questionText.setBounds(150,360+11,450,54);
        questionText.setFont(new Font("宋体",Font.BOLD,20));

        answer.setBounds(50,430+11,100,54);
        answer.setFont(new Font("宋体",Font.BOLD,20));

        answerText.setBounds(150,430+11,450,54);
        answerText.setFont(new Font("宋体",Font.BOLD,20));

        /*button1.setBounds(0,624,325,50);
        button1.setFont(new Font("宋体",Font.BOLD,30));
        button1.setEnabled(false);*/
        //button1.reset(0,624,325,50);
        button2.reset(325-10-10, 624-50, 340, 100);


        button1.reset(0, 624-30, 360, 80);

        /*button2.setBounds(325,624,325,50);
        button2.setFont(new Font("宋体",Font.BOLD,30));*/
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    frame.dispose();
                    new Login();
                }
            }
        });

       // button3.setBounds(325-125,500,250,65);
        button3.reset(325-125,500,250,35);
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button3){
                    int i=ud.register(idtext.getText(),userText.getText(), String.valueOf(passText.getPassword()), questionText.getText(), answerText.getText(),0);
                    switch (i)
                    {
                        case 1:JOptionPane.showMessageDialog(
                                frame,
                                "注册成功",
                                "消息标题",
                                JOptionPane.INFORMATION_MESSAGE
                        );break;

                        case 0:JOptionPane.showMessageDialog(
                                frame,
                                "注册失败，用户ID不符合要求，请输入3-16位由字母数字组成",
                                "消息标题",
                                JOptionPane.INFORMATION_MESSAGE
                        );break;

                        case -1:
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "用户名重复",
                                    "消息标题",
                                    JOptionPane.INFORMATION_MESSAGE
                            );break;

                        case -2:JOptionPane.showMessageDialog(
                                frame,
                                "注册失败，密码6-20位字母数字组成",
                                "消息标题",
                                JOptionPane.INFORMATION_MESSAGE
                        );break;


                    }
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
        panel.add(idlabel);
        panel.add(idtext);
        frame.setVisible(true);

    }
    public static void main(String[]args){
        new Register();
    }
}
