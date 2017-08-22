package com.blog.service;

import com.blog.model.Blogger;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 15:29
 * @see:
 * @since:
 */
public interface BloggerService {

    /**
     * 查询博主信息
     * @return
     */
    public Blogger find();

    /**
     * 通过用户名查询用户
     * @param userName
     * @return
     */
    public Blogger getByUserName(String userName);

    /**
     * 更新博主信息
     * @param blogger
     * @return
     */
    public Integer update(Blogger blogger);
}
