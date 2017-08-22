package com.blog.dao;

import com.blog.model.Blogger;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 15:27
 * @see:
 * @since:
 */
public interface BloggerDao {

    /**
     * 查询博主信息
     * @return
     */
    Blogger find();

    /**
     * 通过用户名查询用户
     * @param userName
     * @return
     */
    Blogger getByUserName(String userName);

    /**
     * 更新博主信息
     * @param blogger
     * @return
     */
    Integer update(Blogger blogger);
}
