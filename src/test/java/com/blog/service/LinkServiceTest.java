package com.blog.service;

import com.blog.config.config;
import com.blog.model.Link;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 14:51
 * @see:
 * @since:
 */
public class LinkServiceTest extends config {

    @Autowired
    private LinkService linkService;

    @Test
    public void listTest(){
        Map<String,Object> map = new HashMap();
        map.put("start",1);
        map.put("size",10);

        List<Link> linkList = linkService.list(map);
        System.out.println(linkList);
    }
}
