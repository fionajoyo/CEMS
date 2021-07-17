package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluateDishUser extends JMenub{
    public EvaluateDishUser() {
        JFrame frame = new JFrame("显示用户");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        JLabel label1=new JLabel("菜品评价");
        JLabel label2=new JLabel("用户昵称:");
        JTextField textField1=new JTextField(20);
        JLabel label3=new JLabel("菜品ID:");
        JTextField textField2=new JTextField(20);
        JLabel label4=new JLabel("菜品名:");
        JTextField textField3=new JTextField(20);
        JLabel label5=new JLabel("评价");
        JTextArea textArea=new JTextArea("请输入评价",3,100);
        JButton button1=new JButton("发表");
        JButton button2=new JButton("取消");

        label1.setBounds(200,50,450,70);
        label1.setFont(new Font("宋体",Font.BOLD,40));

        label2.setBounds(50, 150, 100, 65);
        label2.setFont(new Font("宋体",Font.BOLD,20));

        textField1.setBounds(150, 150, 450, 65);
        textField1.setFont(new Font("宋体",Font.BOLD,20));
        textField1.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        label3.setBounds(50,220 , 100, 65);
        label3.setFont(new Font("宋体",Font.BOLD,20));

        textField2.setBounds(150, 220, 450, 65);
        textField2.setFont(new Font("宋体",Font.BOLD,20));
        textField2.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        label4.setBounds(50,290,100,65);
        label4.setFont(new Font("宋体",Font.BOLD,14));

        textField3.setBounds(150,290,450,65);
        textField3.setFont(new Font("宋体",Font.BOLD,20));
        textField3.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        label5.setBounds(50,360,100,65);
        label5.setFont(new Font("宋体",Font.BOLD,20));

        textArea.setBounds(150,360,450,200);
        textArea.setFont(new Font("宋体",Font.BOLD,20));
        textArea.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        button1.setBounds(150,590,150,65);
        button1.setFont(new Font("宋体",Font.BOLD,30));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button1){
                    JOptionPane.showMessageDialog(
                            frame,
                            "发表成功",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    frame.dispose();
                    new UserMenu();

                }
            }
        });

        button2.setBounds(350,590,150,65);
        button2.setFont(new Font("宋体",Font.BOLD,30));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button2){
                    frame.dispose();
                    new UserMenu();

                }
            }
        });

        panel.add(label1);
        panel.add(label2);
        panel.add(textField1);
        panel.add(label3);
        panel.add(textField2);
        panel.add(label4);
        panel.add(textField3);
        panel.add(label5);
        panel.add(textArea);
        panel.add(button1);
        panel.add(button2);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EvaluateDishUser();
    }
}
