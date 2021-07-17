package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class ShowDishUser extends JMenub{
    public ShowDishUser() {
        //该方法已被Anchor完全重写
        JFrame frame = new JFrame("显示菜品");
        JPanel panel = new JPanel();
        frame.setSize(960, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        String[] b = new String[]{"1", "2","3","4","5","6","7"};    //连接数据库

        /**
         * 这里加入四大菜系*/


        JList a = new JList(b);
        a.setBackground(Color.getHSBColor(201,175,138));
        a.setBounds(0,0,634,712);
        JButton button = new JButton("返回主菜单");
        button.setBounds(355, 500, 250, 100);
        button.setFont(new Font("宋体", Font.BOLD, 40));

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    frame.dispose();
                    new UserMenu();
                }
            }
        });
        panel.add(button);
        panel.add(a);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ShowDishUser showDishUser=new ShowDishUser();
    }
}
