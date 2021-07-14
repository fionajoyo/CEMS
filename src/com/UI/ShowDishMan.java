package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShowDishMan extends JMenub{
    public ShowDishMan() {
        JFrame frame = new JFrame("显示菜品");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        String[] b = {"1", "2"};    //连接数据库
        JList a = new JList(b);
        a.setBackground(Color.getHSBColor(201,175,138));
        a.setBounds(0,0,634,712);
        JButton button = new JButton("返回主菜单");
        button.setBounds(200, 500, 250, 100);
        button.setFont(new Font("宋体", Font.BOLD, 40));
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    frame.dispose();
                    new ManagerMenu();
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

}
