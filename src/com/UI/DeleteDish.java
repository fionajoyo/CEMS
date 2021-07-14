package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDish extends JMenub{
    public DeleteDish(){
        JFrame frame=new JFrame("删除菜品");
        JPanel panel=new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));

        JLabel label1=new JLabel("删除菜品");
        label1.setBounds(200,50,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));

        JLabel label2=new JLabel("id");
        label2.setBounds(50,150,100,65);
        label2.setFont(new Font("宋体",Font.BOLD,20));

        JTextField text1=new JTextField(100);
        text1.setBounds(150,150,450,65);
        text1.setFont(new Font("宋体",Font.BOLD,20));

        JLabel label3=new JLabel("菜品名");
        label3.setBounds(50,220,100,65);
        label3.setFont(new Font("宋体",Font.BOLD,20));

        JTextField text2=new JTextField(100);
        text2.setBounds(150,220,450,65);
        text2.setFont(new Font("宋体",Font.BOLD,20));


        JButton button2=new JButton("删除");
        button2.setBounds(150,590,150,65);
        button2.setFont(new Font("宋体",Font.BOLD,30));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
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

        JButton button3=new JButton("取 消");
        button3.setBounds(350,590,150,65);
        button3.setFont(new Font("宋体",Font.BOLD,30));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button3){
                    frame.dispose();
                    new ManagerMenu();
                }
            }
        });


        panel.add(label1);
        panel.add(label2);
        panel.add(text1);
        panel.add(label3);
        panel.add(text2);
        panel.add(button2);
        panel.add(button3);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new DeleteDish();
    }
}
