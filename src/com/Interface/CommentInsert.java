package com.Interface;

import com.BaseClass.Comment;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 14:41
 * @Version 1.0
 */
public interface CommentInsert {
    /**
     * 对评论进行回复
     * @param father_cId :父评论的cId
     * @param uId  :发表评论的用户uId
     * @param cContent  :发表内容
     * @return  返回Comment实体*/
    public Comment commentInsert(String father_cId,String uId,String cContent);
    
}
