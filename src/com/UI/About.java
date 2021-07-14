package com.UI;

import javax.swing.*;
import java.awt.*;

public class About {
    public About() {
        JFrame frame = new JFrame("关于");
        JPanel panel = new JPanel();
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201, 175, 138));
    }
}
