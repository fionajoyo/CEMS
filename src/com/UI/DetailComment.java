package com.UI;

import com.BaseClass.Comment;
import com.BaseClass.Dish;
import com.DAO.CommentDAO;
import com.DAO.DishDAO;
import com.DAO.UserDAO;
import com.Interface.CommentSystem;
import com.Interface.DishSystem;
import com.Interface.UserManage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author: GuanXinyu
 * @time: 2021/7/16 8:19
 */
public class DetailComment extends JMenub{
    private final Dish dish;
    private Comment fatherComment;
    private Comment[] comment;
    private final DishSystem dishSystem=new DishDAO();
    private final UserManage userManage= new UserDAO();
    private final CommentSystem commentSystem=new CommentDAO();
    private JPanel[] commentPanel;//评论框
    private JLabel NowLabel;//评论详情
    private JTextArea[] commentContain;//评论内容
    private JLabel[] DownLabel=new JLabel[5];//点踩
    private JLabel[] UpLabel=new JLabel[5];//点赞
    private JLabel[] userLabel=new JLabel[5];//评论详情
    public  int page=1;//评论页数
    private final JFrame frame=new JFrame("菜品信息");
    private final JPanel panel=new JPanel();
    private JPanel fatherPanel=new JPanel();
    private JTextArea fatherText=null;
    private JLabel[] fatherLabel=new JLabel[3];//依次为点踩，点赞，详情
    private DishInfoUser mainMenu=null;


    public DetailComment(Dish dish, Comment fatherComment, DishInfoUser dishInfoUser){
        this.dish=dish;
        this.fatherComment=fatherComment;
        this.mainMenu=dishInfoUser;
        getFatherComment(fatherComment.getcId());

        frame.setSize(1280,720);//大小
        frame.setLocationRelativeTo(null);//在屏幕中居中显示
        frame.setLayout(null);//边框布局
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 设置X号后关闭

        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(201,175,138));
        panel.setPreferredSize(new Dimension(1280,1580));

        //菜名
        JLabel title = new JLabel(dish.getdShop() + " " + dish.getdName());
        title.setBounds(100, 20, 450, 70);
        title.setFont(new Font("楷体", Font.BOLD, 40));


        //生成评论框
        newComment();
        newFatherComment();

        //我要评价！
        RoundRectButton commentButton=new RoundRectButton("15.png");
        commentButton.reset(520,540,300,95);
        commentButton.addActionListener(e -> {
            if(e.getSource()==commentButton){
                new NewComment(dish,mainMenu,this,0,fatherComment.getcId());
                flashComment();
            }
        });

        //这里是下一页按钮
        RoundRectButton nextButton=new RoundRectButton("13.png");
        nextButton.reset(800,1480,100,50);
        nextButton.addActionListener(e -> {
            if(e.getSource()==nextButton){
                if(page*5<comment.length){
                    page++;
                }
                if(page==comment.length/5+1&&page!=1){
                    for(int j=5*page-comment.length;j>=comment.length%5;j--){
                        commentContain[j].setText("");
                        UpLabel[j].setText("");
                        DownLabel[j].setText("");
                        userLabel[j].setText("");
                    }
                }
                flashComment();
            }
        });

        //这里是上一页按钮
        RoundRectButton lastButton=new RoundRectButton("14.png");
        lastButton.reset(400,1480,100,50);
        lastButton.addActionListener(e -> {
            if(e.getSource()==lastButton){
                if(page>1){
                    page--;
                }
                flashComment();
            }
        });

        panel.add(title);
        panel.add(createuserMenu());
        panel.add(createabountMenu());
        panel.add(nextButton);
        panel.add(lastButton);
        panel.add(commentButton);

        JScrollPane scrollPane = new JScrollPane(
                panel,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );//滚动布局
        scrollPane.getVerticalScrollBar().setUnitIncrement(24);//加速
        frame.setContentPane(scrollPane);
        frame.setJMenuBar(new JMenub());
        frame.setVisible(true);
    }

    public void flashFatherComment(){
        fatherLabel[0].setText(""+fatherComment.getcDown());
        fatherLabel[1].setText(""+fatherComment.getcUp());
    }

    public void getFatherComment(String fatherId){
        ArrayList<Comment> comments=commentSystem.fatherToSonComment(fatherId);//获取评论
        comment=new Comment[comments.size()];
        for (int i=0;i<comments.size();i++){
            comment[i]=comments.get(i);
        }
    }

    public void flashComment(){
        getFatherComment(fatherComment.getcId());
        for(int i=0;i<5;i++) {
            if(i+5*(page-1)<comment.length){
                commentContain[i].setText(comment[5*(page-1)+i].getcContent());//得到评论内容
                UpLabel[i].setText(""+comment[5*(page-1)+i].getcUp());
                DownLabel[i].setText(""+comment[5*(page-1)+i].getcDown());
                userLabel[i].setText("来自用户--"+comment[i].getuId()+" 时间："+comment[5*(page-1)+i].getcTiming());
            }
        }
        NowLabel.setText("第"+page+"页");
    }

    public void newFatherComment(){
        RoundRectButton r=null;
        JLabel temp=null;

        fatherPanel.setLayout(null);
        fatherPanel.setBounds(190,300,900,125);
        //panel.setBackground(Color.getHSBColor();
        fatherText= new JTextArea(fatherComment.getcContent());//得到评论内容
        fatherText.setBounds(0,0,900,100);
        fatherText.setLineWrap(true);//自动换行
        fatherText.setFont(new Font("楷体",Font.BOLD,20));
        fatherText.setEditable(false);


        //三个按钮生成
        r=new RoundRectButton("4.png");//点踩
        r.reset(850,75,25,25);
        r.addActionListener(e -> {
            commentSystem.getDown(fatherComment.getcId());
            fatherComment.setcDown(fatherComment.getcDown()+1);
            flashFatherComment();
            mainMenu.flashComment();
        });
        fatherPanel.add(r);
        r=new RoundRectButton("5.png");//点赞
        r.reset(825,75,25,25);
        r.addActionListener(e -> {
            commentSystem.getUp(fatherComment.getcId());
            fatherComment.setcUp(fatherComment.getcUp()+1);
            flashFatherComment();
            mainMenu.flashComment();
        });
        fatherPanel.add(r);


        //三个按钮生成

        //点踩
        fatherLabel[0]=new JLabel(""+fatherComment.getcDown());
        fatherLabel[0].setBounds(855,100,25,25);
        fatherLabel[0].setFont(new Font("黑体",Font.BOLD,15));
        fatherPanel.add(fatherLabel[0]);

        //点赞
        fatherLabel[1]=new JLabel(""+fatherComment.getcUp());
        fatherLabel[1].setBounds(830,100,25,25);
        fatherLabel[1].setFont(new Font("黑体",Font.BOLD,15));
        fatherPanel.add(fatherLabel[1]);

        //用户详情
        fatherLabel[2]=new JLabel("来自用户--"+userManage.CommentToUser(fatherComment.getcId())+" 时间："+fatherComment.getcTiming());
        fatherLabel[2].setBounds(10,100,500,25);
        fatherLabel[2].setFont(new Font("楷体",Font.BOLD,15));
        fatherPanel.add(fatherLabel[2]);
        fatherPanel.add(fatherText);
        panel.add(fatherPanel);
    }

    public void newComment(){
        //评价
        commentContain=new JTextArea[5];
        commentPanel =new JPanel[5];
        RoundRectButton r;
        for(int i=0;i<5;i++){
            commentPanel[i]=new JPanel();
            commentPanel[i].setLayout(null);
            commentPanel[i].setBounds(190,700+i*150,900,125);
            //panel.setBackground(Color.getHSBColor();
            commentContain[i]= new JTextArea(/*comment[i].getcContent()*/"");//得到评论内容
            commentContain[i].setBounds(0,0,900,100);
            commentContain[i].setLineWrap(true);//自动换行
            commentContain[i].setFont(new Font("楷体",Font.BOLD,20));
            commentContain[i].setEditable(false);

            //三个按钮生成
            r=new RoundRectButton("4.png");//点踩
            r.reset(850,75,25,25);
            int finalI = i;//临时变量
            r.addActionListener(e -> {
                commentSystem.getDown(comment[5*(page-1)+finalI].getcId());
                comment[5*(page-1)+finalI].setcDown(comment[5*(page-1)+finalI].getcDown()+1);
                DownLabel[finalI].setText(""+comment[5*(page-1)+finalI].getcDown());
            });
            commentPanel[i].add(r);
            r=new RoundRectButton("5.png");//点赞
            r.reset(825,75,25,25);
            r.addActionListener(e -> {
                commentSystem.getUp(comment[5*(page-1)+finalI].getcId());
                comment[5*(page-1)+finalI].setcUp(comment[5*(page-1)+finalI].getcUp()+1);
                UpLabel[finalI].setText(""+comment[5*(page-1)+finalI].getcUp());
            });
            commentPanel[i].add(r);
            r=new RoundRectButton("6.png");//跳转评论详情
            r.reset(875,75,25,25);
            r.addActionListener(e -> {
                //跳转评论详情界面

            });
            commentPanel[i].add(r);
            commentPanel[i].add(commentContain[i]);
            //三个按钮生成

            //点踩
            DownLabel[i]=new JLabel(""/*comment[i].getcDown()*/);
            DownLabel[i].setBounds(855,100,25,25);
            DownLabel[i].setFont(new Font("黑体",Font.BOLD,15));
            commentPanel[i].add(DownLabel[i]);

            //点赞
            UpLabel[i]=new JLabel(""/*comment[i].getcUp()*/);
            UpLabel[i].setBounds(830,100,25,25);
            UpLabel[i].setFont(new Font("黑体",Font.BOLD,15));
            commentPanel[i].add(UpLabel[i]);

            //用户详情
            userLabel[i]=new JLabel(/*"来自用户--"+userManage.CommentToUser(comment[i].getcId())+" 时间："+comment[5*(page-1)+i].getcTiming()*/);
            userLabel[i].setBounds(10,100,500,25);
            userLabel[i].setFont(new Font("楷体",Font.BOLD,15));
            commentPanel[i].add(userLabel[i]);

            panel.add(commentPanel[i]);
        }
        //页面详情
        NowLabel=new JLabel("第"+page+"页");
        NowLabel.setBounds(600,1490,200,30);
        NowLabel.setFont(new Font("楷体",Font.BOLD,30));
        panel.add(NowLabel);
        //评价
        flashComment();
    }

    public static void main(String[] args) {
        DishDAO dishDAO=new DishDAO();
        CommentSystem commentSystem=new CommentDAO();
        //detailComment detailComment=new detailComment(dishDAO.DishReadin("01001"),null);
    }
}
