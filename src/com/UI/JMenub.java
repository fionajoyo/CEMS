package com.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
public class JMenub extends JMenuBar{
    public JMenub(){
        add(createuserMenu());    //添加“文件”菜单
        add(createabountMenu());    //添加“编辑”菜单
        setVisible(true);
    }
    public JMenu createuserMenu(){
        JMenu menu=new JMenu("用户");
        JMenuItem item=new JMenuItem("个人信息(N)",KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserInfo();
            }
        });
        menu.add(item);
        item=new JMenuItem("重置密码(M)",KeyEvent.VK_M);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChangePwd();
            }
        });
        menu.add(item);
        item=new JMenuItem("退出登录(O)",KeyEvent.VK_O);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });
        menu.add(item);
        return menu;
    }
    public JMenu createabountMenu(){
        JMenu menu=new JMenu("关于");
        JMenuItem item=new JMenuItem("信息(N)",KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new About();
            }
        });
        menu.add(item);
        return menu;
    }

}
