package com.UI;

import com.BaseClass.Dish;
import com.DAO.CommentDAO;
import com.DAO.DishDAO;
import com.DAO.UserDAO;
import com.Interface.CommentSystem;
import com.Interface.DishSystem;
import com.Interface.UserManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author: GuanXinyu
 * @time: 2021/7/15 20:01
 */
public class NewComment extends JMenub {
    private final DishSystem dishSystem = new DishDAO();
    private UserManage userManage = new UserDAO();
    private final CommentSystem commentSystem = new CommentDAO();

    public NewComment(Dish dish, DishInfoUser dishInfoUser, DetailComment detailComment, int father, String fatherId) {

        JFrame frame = new JFrame("显示用户");
        JPanel panel = new JPanel();
        frame.setSize(1200, 450);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置X号后关闭
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201, 175, 138));

        JLabel picture = new JLabel(dishSystem.readImage(dish));
        picture.setBounds(600, 0, 600, 450);

        JTextArea textArea = new JTextArea("请输入评价", 3, 100);
        RoundRectButton commentButton = new RoundRectButton("14.png");
        RoundRectButton cancelButton = new RoundRectButton("13.png");

        //菜名
        JLabel title = new JLabel(dish.getdShop() + " " + dish.getdName());
        title.setBounds(100, 20, 450, 70);
        title.setFont(new Font("楷体", Font.BOLD, 40));

        textArea.setBounds(50, 100, 500, 200);
        textArea.setFont(new Font("黑体", Font.BOLD, 20));
        textArea.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));

        commentButton.setBounds(400, 320, 50, 50);
        commentButton.setFont(new Font("黑体", Font.BOLD, 30));
        commentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == commentButton) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "发表成功",
                            "消息标题",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    if(father==1){
                        commentSystem.fatherCommentInsert(dish.getdId(), userManage.showUserInformation().getuId(), textArea.getText());
                    }
                    else {
                        commentSystem.CommentInsert(fatherId, userManage.showUserInformation().getuId(), textArea.getText());
                    }
                    if(dishInfoUser!=null){
                        dishInfoUser.getComment(dish.getdId());
                        dishInfoUser.flashComment();
                    }
                    if(detailComment!=null){
                        detailComment.flashComment();
                    }
                    frame.dispose();
                }
            }
        });

        cancelButton.setBounds(150, 320, 50, 50);
        cancelButton.setFont(new Font("黑体", Font.BOLD, 30));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cancelButton) {
                    frame.dispose();
                }
            }
        });

        panel.add(title);
        panel.add(picture);
        panel.add(textArea);
        panel.add(commentButton);
        panel.add(cancelButton);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);
    }

}
