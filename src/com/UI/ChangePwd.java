package com.UI;

import com.DAO.UserDAO;
import com.Interface.LoginAndRegister;
import com.Interface.UserManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePwd extends JMenub{
    public ChangePwd(){
        UserDAO userDAO=new UserDAO();
        UserManage userManage=userDAO;
        LoginAndRegister loginAndRegister=userDAO;

        JFrame frame = new JFrame("重置密码");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        JLabel label1=new JLabel("重置密码");
        JLabel userLabel = new JLabel("用户名: ");// 创建UserJLabel
        JLabel userInformation=new JLabel(userManage.showUserInformation().getuName());
        //JTextField userText = new JTextField();           // 获取登录名
        JLabel passLabel = new JLabel("新密码:");       // 创建PassJLabel
        JPasswordField passText = new JPasswordField(20); //密码框隐藏
        JLabel passLabel1=new JLabel("再次输入:");
        JPasswordField passText1=new JPasswordField(20);
        JLabel question=new JLabel("安全问题:");
        JLabel questionInformation=new JLabel(userManage.showUserInformation().getuQuestion());//新增
        //JTextField questionText=new JTextField(100);
        JLabel answer=new JLabel("回答:");
        JTextField answerText=new JTextField("请输入",100);
        JLabel label=new JLabel("用户权限:");
        //JTextField textField=new JTextField(10);
        JLabel authorityInformation=new JLabel(userManage.showUserInformation().getuPms()>0?"管理员":"普通用户");//新增
        JButton button1=new JButton("确定");
        JButton button2=new JButton("取消");

        label1.setBounds(200,50,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));

        userLabel.setBounds(50, 150, 100, 65);
        userLabel.setFont(new Font("宋体",Font.BOLD,20));

        userInformation.setBounds(150, 150, 450, 65);
        userInformation.setFont(new Font("宋体",Font.BOLD,20));
        //userText.setBounds(150, 150, 450, 65);
        //userText.setFont(new Font("宋体",Font.BOLD,20));
        //userText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        passLabel.setBounds(50,360 , 100, 65);
        passLabel.setFont(new Font("宋体",Font.BOLD,20));

        passText.setBounds(150, 360, 450, 65);
        passText.setFont(new Font("宋体",Font.BOLD,20));
        passText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        passLabel1.setBounds(50,430,100,65);
        passLabel1.setFont(new Font("宋体",Font.BOLD,20));

        passText1.setBounds(150,430,450,65);
        passText1.setFont(new Font("宋体",Font.BOLD,20));

        question.setBounds(50,220,100,65);
        question.setFont(new Font("宋体",Font.BOLD,20));

        //questionText.setBounds(150,220,450,65);
        //questionText.setFont(new Font("宋体",Font.BOLD,20));
        questionInformation.setBounds(150,220,450,65);
        questionInformation.setFont(new Font("宋体",Font.BOLD,20));

        answer.setBounds(50,290,100,65);
        answer.setFont(new Font("宋体",Font.BOLD,20));

        answerText.setBounds(150,290,450,65);
        answerText.setFont(new Font("宋体",Font.BOLD,20));
        //-----接口引入

        //-----

        label.setBounds(50,500,100,65);
        label.setFont(new Font("宋体",Font.BOLD,20));

        //textField.setBounds(150,500,100,65);
        //textField.setFont(new Font("宋体",Font.BOLD,20));
        authorityInformation.setBounds(150,500,100,65);
        authorityInformation.setFont(new Font("宋体",Font.BOLD,20));

        button1.setBounds(150,590,150,65);
        button1.setFont(new Font("宋体",Font.BOLD,30));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button1){
                    if(userManage.showUserInformation().getuAnswer().equals(answerText.getText())){
                        if(String.valueOf(passText.getPassword()).equals(String.valueOf(passText1.getPassword()))){
                            loginAndRegister.resetPassword(answerText.getText(),userManage.showUserInformation().getuId(), String.valueOf(passText.getPassword()));
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "重置成功",
                                    "系统通知",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                        else {
                            JOptionPane.showMessageDialog(
                                    frame,
                                    "重置失败！两次输入的密码不一致！",
                                    "系统通知",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(
                                frame,
                                "重置失败！安全问题回答错误！",
                                "系统通知",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                    if(userManage.showUserInformation().getuPms()==0) {
                        frame.dispose();
                        new UserMenu();
                    }
                    else if(userManage.showUserInformation().getuPms()>0){
                        frame.dispose();
                        new ManagerMenu();
                    }
                }
            }
        });

        button2.setBounds(350,590,150,65);
        button2.setFont(new Font("宋体",Font.BOLD,30));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    if(userManage.showUserInformation().getuPms()==0) {
                        frame.dispose();
                        new UserMenu();
                    }
                    else if(userManage.showUserInformation().getuPms()>0){
                        frame.dispose();
                        new ManagerMenu();
                    }
                }
            }
        });

        panel.add(label1);
        panel.add(userLabel);
        //panel.add(userText);
        panel.add(userInformation);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(passLabel1);
        panel.add(passText1);
        panel.add(question);
        panel.add(questionInformation);
        //panel.add(questionText);
        panel.add(answer);
        panel.add(answerText);
        panel.add(label);
        //panel.add(textField);
        panel.add(authorityInformation);
        panel.add(button1);
        panel.add(button2);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);


    }
    public static void main(String[]args){
        new ChangePwd();
    }
}
