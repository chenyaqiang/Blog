package com.blog.service.impl;

import com.blog.model.Blog;
import com.blog.model.BlogType;
import com.blog.model.Blogger;
import com.blog.model.Link;
import com.blog.service.BlogService;
import com.blog.service.BlogTypeService;
import com.blog.service.BloggerService;
import com.blog.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @description:初始化组件
 * 把博主信息 根据博客类别分类信息 根据日期归档分类信息 存放到application中，用以提供页面请求性能
 * @author: wb
 * @data: 2017/8/22 14:33
 * @see:
 * @since:
 */

@Component
public class InitComponent implements ServletContextListener, ApplicationContextAware {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        BloggerService bloggerService = applicationContext.getBean(BloggerService.class);
        Blogger blogger = bloggerService.find(); // 查询博主信息
        blogger.setPassword(null);
        application.setAttribute("blogger", blogger);

        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
        List<BlogType> blogTypeCountList = blogTypeService.countList(); // 查询博客类别以及博客的数量
        application.setAttribute("blogTypeCountList", blogTypeCountList);

        BlogService blogService = (BlogService) applicationContext.getBean(BlogService.class);
        List<Blog> blogCountList = blogService.countList(); // 根据日期分组查询博客
        application.setAttribute("blogCountList", blogCountList);

        LinkService linkService = (LinkService) applicationContext.getBean(LinkService.class);
        List<Link> linkList = linkService.list(null); // 查询所有的友情链接信息
        application.setAttribute("linkList", linkList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // TODO Auto-generated method stub
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        this.applicationContext = applicationContext;
    }

    private static ApplicationContext applicationContext;
}
