package com.blog.service.impl;

import com.blog.dao.CommentDao;
import com.blog.model.Comment;
import com.blog.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 15:24
 * @see:
 * @since:
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public int add(Comment comment) {
        return commentDao.add(comment);
    }

    @Override
    public int update(Comment comment) {
        return commentDao.update(comment);
    }

    @Override
    public List<Comment> list(Map<String, Object> map) {
        return commentDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return commentDao.getTotal(map);
    }

    @Override
    public Integer delete(Integer id) {
        return commentDao.delete(id);
    }
}
