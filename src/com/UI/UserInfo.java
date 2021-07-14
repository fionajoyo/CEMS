package com.UI;

import com.BaseClass.User;
import com.DAO.BaseDAO;
import com.DAO.UserDAO;
import com.Interface.UserManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.border.Border;

import java.util.Map;

public class UserInfo extends JMenub {
    public UserInfo()  {
        URL url= null;
        try {
            url = new URL("http://124.71.236.232:8888/down/ABM9pM78AZsG?fname=/2.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        assert url != null;
        ImageIcon ic=new ImageIcon(url);
        UserManage m=new UserDAO();
        JFrame frame = new JFrame("用户信息");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        JLabel label1=new JLabel("用户信息");
        JLabel userLabel = new JLabel("用户名:");           // 创建UserJLabel
        //JTextField userText = new JTextField();           // 获取登录名
        JLabel userText=new JLabel(m.showUserInformation().getuName());     //获取昵称
        JLabel passLabel = new JLabel("账  号:");       // 创建PassJLabel
        JLabel passText =new JLabel(m.showUserInformation().getuId());
        //JPasswordField passText = new JPasswordField(20); //密码框隐藏
        JLabel evaLabel=new JLabel("历史评价:");
        JTextArea evaText=new JTextArea(3,20);
        JLabel label=new JLabel("用户权限:");
        JLabel textField=new JLabel(m.showUserInformation().getuPms()>0?"管理员":"普通用户");

        RoundRectButton button2=new RoundRectButton("1.png");
        button2.reset(190,590,255,36);

        //button2.setBorder(new RoundBorder(Color.RED));
       // button2.setOpaque(false);


        label1.setBounds(240,50,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));

        userLabel.setBounds(50, 150, 100, 65);
        userLabel.setFont(new Font("宋体",Font.BOLD,27));

        userText.setBounds(150, 150, 450, 65);
        userText.setFont(new Font("宋体",Font.BOLD,27));
        //userText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        passLabel.setBounds(50,220 , 100, 65);
        passLabel.setFont(new Font("宋体",Font.BOLD,27));

        passText.setBounds(150, 220, 450, 65);
        passText.setFont(new Font("宋体",Font.BOLD,27));
        //passText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        evaLabel.setBounds(50,290,100,65);
        evaLabel.setFont(new Font("宋体",Font.BOLD,14));

        evaText.setBounds(150,290,450,65);
        evaText.setFont(new Font("宋体",Font.BOLD,20));

        label.setBounds(50,360-70,200,65);
        label.setFont(new Font("宋体",Font.BOLD,27));

        textField.setBounds(150+50,360-70,100,65);
        textField.setFont(new Font("宋体",Font.BOLD,25));




        //button2.setFont(new Font("宋体",Font.BOLD,30));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    String[] a={"用户","管理员"};
                    if(m.showUserInformation().getuPms()==0) {
                        frame.dispose();
                        //new UserMenu();
                    }
                    else if(m.showUserInformation().getuPms()==1){
                        frame.dispose();
                        //new ManagerMenu();
                    }
                }
            }
        });

        panel.add(label1);
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passLabel);
        panel.add(passText);
        //panel.add(evaLabel);
        //panel.add(evaText);
        panel.add(label);
        panel.add(textField);
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
