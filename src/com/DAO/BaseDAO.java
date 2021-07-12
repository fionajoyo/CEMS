package com.DAO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class BaseDAO {
    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;
    static {
        init();//静态代码块
    }

    //静态读入文件方法
    public static void init(){//静态方法实例化对象
        Properties params=new Properties();
        String configFile="database.properties";//打开文件
        //读入流赋值
        InputStream is=BaseDAO.class.getClassLoader().getResourceAsStream(configFile);//读入流
        try {
            params.load(is);//读入文件由流交给类
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        driver=params.getProperty("driver");
        url=params.getProperty("url");
        username=params.getProperty("username");
        password=params.getProperty("password");
        System.out.println("资源文件读入...");
    }

    //连接方法
    public Connection getConn() throws ClassNotFoundException, SQLException{
        Connection conn=null;
        try {
            Class.forName(driver);//载入驱动
            conn=DriverManager.getConnection(url,username,password);//建立连接
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("连接建立...");
        return conn;
    }

    //关闭方法
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //增删改方法
    // 输入preparedSQL(经过处理清单类处理过的SQL语句） param（命令参数）
    public int executeSQL(String preparedSql,Object[] param){
        Connection conn=null;
        PreparedStatement pstmt=null;//完全准备清单类，能避免sql注入
        int num=0;//受影响的行数
        try {
            conn=getConn();//每次传输任务新建一个链接
            pstmt=conn.prepareStatement(preparedSql);//获取连接的参数
            if(param!=null){
                for (int i=0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);//i是0开始，但从1开始替换站位符
                }
            }
            num=pstmt.executeUpdate();//提交，并得到处理影响的行数
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {//始终执行的代码块
            this.closeAll(conn,pstmt,null);
        }
        return num;
    }

    //查询方法
    /*public Object[] query(String preparedSql,Object[] param){
        Object[] oj;
        Connection conn=null;
        PreparedStatement pstmt=null;//完全准备清单类，能避免sql注入
        ResultSet rs=null;
        try {
            conn=getConn();//建立连接
            pstmt=conn.prepareStatement(preparedSql);
            if(param!=null){//若参数非空，传参
                for (int i=0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);//i是0开始，但从1开始替换站位符
                }
            }

            rs=pstmt.executeQuery();//提交，并将结果返回至ResultSet类中
            for(int i=0;!rs.next();i++)
            {
                oj[i]=rs.getString()
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {

            this.closeAll(conn,pstmt,null);
        }

    }
*/
/**
 * @param preparedSql
 * @param param
 * @param column :表的列的数量
 * @return 返回一个String型的链表*/
    public ArrayList<String> query(String preparedSql,Object[] param,int column){
        Connection conn=null;
        PreparedStatement pstmt=null;//完全准备清单类，能避免sql注入
        ResultSet rs=null;
        ArrayList<String> obj =new ArrayList<String>();
        try {
            conn=getConn();//建立连接
            pstmt=conn.prepareStatement(preparedSql);
            if(param!=null){//若参数非空，传参
                for (int i=0;i<param.length;i++){
                    pstmt.setObject(i+1,param[i]);//i是0开始，但从1开始替换站位符
                }
            }
            rs=pstmt.executeQuery();//提交，并将结果返回至ResultSet类中
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            try {
                int i=0;
                while (rs.next()){
                    for (int j=i*column;j<column;j++){
                        obj.add(rs.getString(j+1));
                    }
                    i++;
                }
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
            this.closeAll(conn,pstmt,rs);
        }
        return obj;
    }

    public static void main(String[] args) {//测试
        BaseDAO B=new BaseDAO();
        try {
            B.closeAll(B.getConn(),null,null);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
