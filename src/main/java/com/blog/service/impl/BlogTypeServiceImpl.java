package com.blog.service.impl;

import com.blog.dao.BlogTypeDao;
import com.blog.model.BlogType;
import com.blog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 15:02
 * @see:
 * @since:
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeDao blogTypeDao;

    @Override
    public List<BlogType> countList() {
        return blogTypeDao.countList();
    }

    @Override
    public BlogType findById(Integer id) {
        return blogTypeDao.findById(id);
    }

    @Override
    public List<BlogType> list(Map<String, Object> map) {
        return blogTypeDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return blogTypeDao.getTotal(map);
    }

    @Override
    public Integer add(BlogType blogType) {
        return blogTypeDao.add(blogType);
    }

    @Override
    public Integer update(BlogType blogType) {
        return blogTypeDao.update(blogType);
    }

    @Override
    public Integer delete(Integer id) {
        return blogTypeDao.delete(id);
    }
}
