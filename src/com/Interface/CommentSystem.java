package com.Interface;

import com.BaseClass.Comment;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 14:41
 * @Version 1.0
 */
public interface CommentSystem {
    /**
     * 对评论进行回复
     * @param father_cId :父评论的cId
     * @param uId  :发表评论的用户uId
     * @param cContent  :发表内容
     * @return  返回Comment实体*/
    public Comment commentInsert(String father_cId,String uId,String cContent);

    /**
     * 评价菜品（父评论）
     * @param cContent :评论内容
     * @param uId :评论者的用户uId
     * @param dId :评论菜品dId*/
    public Comment fatherCommentInsert(String dId,String uId,String cContent);


    /**
     * 普通用户或管理员对评论进行删除
     * @param uId :user id
     * @param cId  :评论的id
     * @return true or false*/
    public boolean deleteComment(String cId,String uId);

    /**
     * 评论点赞
     * @param cId :要点赞的评论id
     * */
    public boolean getUp(String cId);

    /**
     * 评论点踩
     * @param cId :要踩的评论id*/
    public boolean getDown(String cId);




    
}
