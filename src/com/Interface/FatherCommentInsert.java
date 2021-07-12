package com.Interface;

import com.BaseClass.Comment;

/**
 * @Author=fionajoyo
 * @Date 2021/7/12 15:59
 * @Version 1.0
 */
public interface FatherCommentInsert {
    /**
     * 评价菜品（父评论）
     * @param cContent :评论内容
     * @param uId :评论者的用户uId
     * @param dId :评论菜品dId*/
    public Comment fatherCommentInsert(String dId,String uId,String cContent);
}
