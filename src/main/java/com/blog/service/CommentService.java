package com.blog.service;

import com.blog.model.Comment;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 15:23
 * @see:
 * @since:
 */
public interface CommentService {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    int add(Comment comment);

    /**
     * 修改评论
     * @param comment
     * @return
     */
    int update(Comment comment);

    /**
     * 查找用户评论信息
     * @param map
     * @return
     */
    List<Comment> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    Long getTotal(Map<String,Object> map);

    /**
     * 删除评论信息
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
