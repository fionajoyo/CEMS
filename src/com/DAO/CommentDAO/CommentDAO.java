package com.DAO.CommentDAO;

import com.BaseClass.Comment;
import com.DAO.BaseDAO;
import com.Interface.CommentSystem;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 9:52
 * @Version 1.0
 */
public class CommentDAO extends BaseDAO implements CommentSystem {

    @Override
    public Comment commentInsert(String father_cId,String uId,String cContent)
    {
       String dId=father_cId.substring(0, 5);
       String s=father_cId.substring(0, 7);
       String cId=null;
       int son_count=0;
       Object[] paramss={father_cId};
        ArrayList<String> as=query("select c_soncount from comtable where c_id=?",paramss,8);
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
        ArrayList<String> as = query(sql, null, 8);
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
    public void deleteComment(String cId, String uId) {

        String sql="select  u_id,u_pms  from usertable join comtable on usertable.u_id=comtable.u_id where c_id=? ";


    }


}

