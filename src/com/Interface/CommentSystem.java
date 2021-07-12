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

    public void deleteComment(String cId,String uId);




    
}
