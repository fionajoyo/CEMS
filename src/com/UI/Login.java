package com.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.DAO.UserDAO;
import com.Interface.*;

public class Login extends JFrame {
    private JFrame frame = new JFrame("食堂菜品评价系统");
    private JPanel panel = new JPanel();
    private JLabel userLabel = new JLabel("用户ID:");           // 创建UserJLabel
    private JTextField userText = new JTextField();           // 获取登录名
    private JLabel passLabel = new JLabel("密  码:");       // 创建PassJLabel
    private JPasswordField passText = new JPasswordField(20); //密码框隐藏


    private RoundRectButton loginButton = new RoundRectButton("10.png");       // 创建登录按钮
    private RoundRectButton registerButton = new RoundRectButton("9.png"); // 创建注册按钮

    private RoundRectButton loginb=new RoundRectButton("2.png");
    private RoundRectButton findpassWord=new RoundRectButton("8.png");
    private JPanel panel1;
    private JLabel label=new JLabel("权  限:");
    //private JTextField authorityText=new JTextField();
    private JComboBox cmb=new JComboBox();


    public Login() {

        panel.setBackground(new Color(201,175,138));
        //设置窗体的位置及大小
        frame.setSize(650, 720);
        frame.setLocationRelativeTo(null);                     //在屏幕中居中显示
        frame.add(panel);                                      // 添加面板
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  // 设置X号后关闭
        placeComponents(panel);                                //往窗体里放其他控件
        frame.setVisible(true);                                //设置窗体可见
    }
    private void placeComponents(JPanel panel) {
        //-------------接口引入
        UserDAO userDAO=new UserDAO();
        LoginAndRegister loginAndRegister=userDAO;
        UserManage userManage=userDAO;
        //-------------接口引入

        panel.setLayout(null);  //设置布局为 null
        //panel.setBackground(Color.getHSBColor(201,175,138));

        // 创建 UserJLabel
        userLabel.setBounds(50, 200, 100, 65);
        userLabel.setFont(new Font("宋体",Font.BOLD,20));
        //userLabel.setBorder(new RoundBorder());
        panel.add(userLabel);
        // 创建文本域用于用户输入
        userText.setBounds(150, 200, 400, 65);
       // userText.setBackground(null);
        userText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
       // userText.setBorder(new RoundBorder());
        userText.setText("gxy");
        userText.setFont(new Font("黑体",Font.BOLD,20));

        panel.add(userText);

        // 创建PassJLabel
        passLabel.setBounds(50,300 , 100, 65);
        passLabel.setFont(new Font("宋体",Font.BOLD,20));
        panel.add(passLabel);
        // 密码输入框 隐藏
        passText.setBounds(150, 300, 400, 65);
        passText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
        passText.setText("gxy123456");
        panel.add(passText);
        //创建权限
        label.setBounds(50,400 , 100, 65);
        label.setFont(new Font("宋体",Font.BOLD,20));
        panel.add(label);
        /*authorityText.setBounds(150, 340, 450, 65);
        authorityText.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
        panel.add(authorityText);*/
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("用户");
        cmb.addItem("管理员");
        cmb.setBounds(150, 400, 400, 65);
        cmb.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
        cmb.setFont(new Font("黑体",Font.BOLD,20));
        panel.add(cmb);
        // 创建登录按钮
        /*loginb.setBounds(50,500,250,65);
        loginb.setBackground(Color.RED);
        loginb.setFont(new Font("宋体",Font.BOLD,30));
        loginb.setBorder(BorderFactory.createLineBorder(Color.RED, 0, true));
        panel.add(loginb);*/
        loginb.reset(110,520,200,40);
        panel.add(loginb);

        loginb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==loginb){
                    String[] name={"管理员","用户"};
                    //-------------接口引入
                    int authority = loginAndRegister.login(userText.getText(), String.valueOf(passText.getPassword()));
                    //-------------接口引入
                    if(/*name[0].equals(cmb.getSelectedItem())*/authority>0&&userText.getText()!=null&&passText.getText()!=null){

                        LoadingPanel glasspane =new LoadingPanel();

                        glasspane.setBounds(325-100, 360-100, 650, 720);
                        frame.add(glasspane);
                        frame.setGlassPane(glasspane);
                        glasspane.setText("Loading data, Please wait ...");
                        glasspane.start();//开始动画加载效果
                        //Thread t=glasspane.animation;
                        Timer tt=new Timer();
                        TimerTask ts=new TimerTask() {
                            @Override
                            public void run() {
                                Timer tf=new Timer();
                                TimerTask tts=new TimerTask() {
                                    @Override
                                    public void run() {
                                        new DishClassify();
                                        glasspane.stop();
                                        frame.dispose();
                                        JOptionPane.showMessageDialog(
                                                frame,
                                                "欢迎回来,"+userManage.showUserInformation().getuName()+"管理员",
                                                "登录成功",
                                                JOptionPane.INFORMATION_MESSAGE
                                        );
                                    }
                                };
                                tf.schedule(tts,1000);

                            }
                        };
                        tt.schedule(ts,1000);


                        /*new ManagerMenu();
                        JOptionPane.showMessageDialog(
                                frame,
                                "欢迎回来,"+userManage.showUserInformation().getuName()+"管理员",
                                "登录成功",
                                JOptionPane.INFORMATION_MESSAGE
                        );*/
                    }
                    else if(/*name[1].equals(cmb.getSelectedItem())*/authority==0&&userText.getText()!=null&&passText.getText()!=null){
                        LoadingPanel glasspane =new LoadingPanel();

                        glasspane.setBounds(325-100, 360-100, 650, 720);
                        frame.add(glasspane);
                        frame.setGlassPane(glasspane);
                        glasspane.setText("Loading data, Please wait ...");
                        glasspane.start();//开始动画加载效果
                        //Thread t=glasspane.animation;
                        Timer tt=new Timer();
                        TimerTask ts=new TimerTask() {
                            @Override
                            public void run() {

                                Timer tf=new Timer();
                                TimerTask tts=new TimerTask() {
                                    @Override
                                    public void run() {
                                        new UserMenu();
                                        glasspane.stop();
                                        frame.dispose();
                                        JOptionPane.showMessageDialog(
                                                frame,
                                                "欢迎回来,"+userManage.showUserInformation().getuName()+"用户",
                                                "消息标题",
                                                JOptionPane.INFORMATION_MESSAGE
                                        );

                                    }
                                };
                                tf.schedule(tts,1000);

                            }
                        };
                        tt.schedule(ts,1000);
                        //frame.dispose();
                    }
                    else{

                        JOptionPane.showMessageDialog(
                                frame,
                                "用户名或密码错误",
                                "消息标题",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });
        //创建忘记密码按钮
        //loginb.reset(110,520,200,40);
        findpassWord.reset(350,520,200,40);
        panel.add(findpassWord);
        findpassWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==findpassWord){
                    frame.dispose();
                    new FindpassWord();
                }
            }
        });
        // 创建登录按钮
        loginButton.reset(325-10-10, 624-30, 360, 80);
        //loginButton.setFont(new Font("宋体",Font.BOLD,30));
        //loginButton.setBackground(Color.getHSBColor(201,175,138));
        //loginButton.setBorder(BorderFactory.createLineBorder(Color.getHSBColor(201,175,138), 0, true));

        //.setEnabled(false);

        //创建注册按钮
        registerButton.reset(0, 624-50, 340, 100);
        //registerButton.setFont(new Font("宋体",Font.BOLD,30));
        //registerButton.setBackground(Color.getHSBColor(230,220,205));
        //registerButton.setBorder(BorderFactory.createLineBorder(Color.RED, 0, true));


        panel.add(registerButton);
        panel.add(loginButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==registerButton){
                    frame.dispose();
                    new Register();
                }
            }
        });
    }


    public static void main(String[] args) {
        new Login();
    }
}