package com.blog.service.impl;

import com.blog.dao.LinkDao;
import com.blog.model.Link;
import com.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 14:44
 * @see:
 * @since:
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;

    public int add(Link link) {
        return linkDao.add(link);
    }

    public int update(Link link) {
        return linkDao.update(link);
    }

    public List<Link> list(Map<String, Object> map) {
        return linkDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return linkDao.getTotal(map);
    }

    public Integer delete(Integer id) {
        return linkDao.delete(id);
    }
}
