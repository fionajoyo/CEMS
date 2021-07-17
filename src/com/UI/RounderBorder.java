package com.UI;

import javax.swing.border.Border;
import java.awt.*;

/**
 * @Author=fionajoyo
 * @Date 2021/7/14 14:05
 * @Version 1.0
 */
class RoundBorder implements Border {
    private Color color;
    private int arcH = 30;
    private int arcW = 45;
    public RoundBorder(Color color) {// 有参数的构造方法
        this.color = color;
    }

    public RoundBorder() {// 无参构造方法
        this.color = Color.BLACK;
        // 如果实例化时，没有传值
        // 默认是黑色边框
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(10, 10, 10, 10);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    // 实现Border（父类）方法
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        //        g.setColor(color);
        //        g.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, arcH, arcW);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, arcH, arcW);
        g2d.dispose();
    }
}
