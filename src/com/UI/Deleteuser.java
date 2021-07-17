package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deleteuser extends JMenub{
    public Deleteuser() {
        JFrame frame = new JFrame("删除用户");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        JLabel label1=new JLabel("删除用户");
        JLabel userid=new JLabel("id:");
        JTextField useridText = new JTextField(20);
        JLabel userLabel = new JLabel("用户名:");           // 创建UserJLabel
        JTextField userText = new JTextField();           // 获取登录名
        JLabel passLabel = new JLabel("密 码:");       // 创建PassJLabel
        JPasswordField passText = new JPasswordField(20); //密码框隐藏
        JButton button1=new JButton("删除");
        JButton button2=new JButton("取消");

        label1.setBounds(200,50,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));

        userid.setBounds(50,200,100,65);
        userid.setFont(new Font("宋体",Font.BOLD,20));

        useridText.setBounds(150,200,450,65);
        useridText.setFont(new Font("宋体",Font.BOLD,20));
        useridText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        userLabel.setBounds(50, 300, 100, 65);
        userLabel.setFont(new Font("宋体",Font.BOLD,20));

        userText.setBounds(150, 300, 450, 65);
        userText.setFont(new Font("宋体",Font.BOLD,20));
        userText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        passLabel.setBounds(50,400 , 100, 65);
        passLabel.setFont(new Font("宋体",Font.BOLD,20));

        passText.setBounds(150, 400, 450, 65);
        passText.setFont(new Font("宋体",Font.BOLD,20));
        passText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        button1.setBounds(150,600,150,65);
        button1.setFont(new Font("宋体",Font.BOLD,30));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button1){
                    JOptionPane.showMessageDialog(
                            frame,
                            "删除成功",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    frame.dispose();
                    new ManagerMenu();
                }
            }
        });

        button2.setBounds(350,600,150,65);
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
        panel.add(userid);
        panel.add(useridText);
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        panel.add(button1);
        panel.add(button2);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);

    }
    public static void main(String[]args){
        new Deleteuser();
    }

}
