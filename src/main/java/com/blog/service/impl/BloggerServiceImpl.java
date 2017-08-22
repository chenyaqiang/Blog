package com.blog.service.impl;

import com.blog.dao.BloggerDao;
import com.blog.model.Blogger;
import com.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 15:29
 * @see:
 * @since:
 */
@Service
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerDao bloggerDao;

    @Override
    public Blogger find() {
        return bloggerDao.find();
    }

    @Override
    public Blogger getByUserName(String userName) {
        return bloggerDao.getByUserName(userName);
    }

    @Override
    public Integer update(Blogger blogger) {
        return bloggerDao.update(blogger);
    }
}
