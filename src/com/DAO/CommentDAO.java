package com.DAO;

import com.BaseClass.Comment;
import com.DAO.BaseDAO;
import com.Interface.CommentSystem;


import javax.swing.plaf.SliderUI;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommentDAO extends BaseDAO implements CommentSystem {

    @Override
    public Comment commentInsert(String father_cId,String uId,String cContent){
        String dId=father_cId.substring(0, 5);
        String s=father_cId.substring(0, 7);
        String cId=null;
        int son_count=0;
        Object[] paramss={father_cId};
        ArrayList<String> as=query("select c_soncount from comtable where c_id=?",paramss,1);
        son_count=Integer.parseInt(as.get(0))+1;

        if(son_count<10)
        {
            cId=s+"0"+son_count;
        }
        else {cId=s+son_count;}
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String cTiming=formatter.format(date);
        Comment c=new Comment(cId,uId,dId,0,0,cContent,cTiming,-1);
        String SQL="insert into comtable values(?,?,?,?,?,?,?,?)";
        Object[] param={cId,uId,dId,(int)0,(int)0,cContent,cTiming,(int)-1};
        executeSQL(SQL,param);
        String sql="update comtable set c_soncount=? where c_id=?";
        Object[] params={son_count,father_cId};
        executeSQL(sql,params);

        return c;

    }

    @Override
    public Comment fatherCommentInsert(String dId,String uId,String cContent) {
        String sql = "select distinct c_id from comtable where c_id like '%00'";
        String cId=null ;
        //Object[] param = {"'%00'"};
        ArrayList<String> as = query(sql, null, 1);
        int fatherCount = as.size() + 1;  //找到父评论的数量
        if (fatherCount < 10) {
            cId = dId + "0" + fatherCount + "00";
        } else {
            cId = dId + fatherCount + "00";
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String cTiming=formatter.format(date);

        Comment c=new Comment(cId,uId,dId,0,0,cContent,cTiming,0);
        String SQL="insert into comtable values(?,?,?,?,?,?,?,?)";
        Object[] params={cId,uId,dId,(int)0,(int)0,cContent,cTiming,(int)0};
        executeSQL(SQL,params);
        return  c;
    }

    @Override
    public boolean deleteComment(String cId, String uId) {

        String sql1="select  usertable.u_id  from usertable join comtable on usertable.u_id=comtable.u_id where c_id=? ";
        String sql2="delete from comtable where c_id=?";
        String sql3="select u_pms from usertable where u_id=?";
        Object[] param={cId};
        Object[] params={uId};
        ArrayList<String>  as=query(sql1,param,1);
        ArrayList<String>  as1=query(sql3,params,1);
        if(as.get(0).equals(uId))
        {
            System.out.println("自己删除评论");
            executeSQL(sql2,param);
            return true;
        }
        else if(as.size()>0&&as1.get(0).equals("1"))
        {
            System.out.println("管理员删除评论");
            executeSQL(sql2,param);
            return true;
        }
        System.out.println("删除失败");
        return false;

    }

    @Override
    public boolean getUp(String cId) {
        String sql="select c_up from comtable where c_id=?";
        Object[] param={cId};
        ArrayList<String> as =query(sql,param,1);
        int cUp=Integer.parseInt(as.get(0))+1;
        sql="update comtable set c_up=? where c_id=?";
        Object[] params={cUp,cId};
        executeSQL(sql,params);
        return true;



    }

    @Override
    public boolean getDown(String cId) {
        String sql="select c_down from comtable where c_id=?";
        Object[] param={cId};
        ArrayList<String> as =query(sql,param,1);
        int cDown=Integer.parseInt(as.get(0))+1;
        sql="update comtable set c_down=? where c_id=?";
        Object[] params={cDown,cId};
        executeSQL(sql,params);
        return true;

    }

    @Override
    public ArrayList<Comment> DishToComment(String dId)
    {
        ArrayList<Comment> as=new ArrayList<>();
        String  sql="select * from comtable where d_id=?";
        Object[] param={dId};
        ArrayList<String> al=query(sql,param,8);
        for(int i=0;i<al.size()/8;i++)
        {
            as.add(new Comment(al.get(0+i*8),(al.get(1+i*8)),(al.get(2+i*8)),Integer.parseInt (al.get(3+i*8)),Integer.parseInt (al.get(4+i*8)),(al.get(5+i*8)),(al.get(6+i*8)),Integer.parseInt (al.get(7+i*8))));
        }
        return as;
    }

    public static void main(String[] args) {
        CommentDAO commentDAO=new CommentDAO();
        commentDAO.DishToComment("01001");
    }
}