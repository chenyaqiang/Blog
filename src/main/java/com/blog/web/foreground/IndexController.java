package com.blog.web.foreground;

import com.blog.model.Blog;
import com.blog.model.PageBean;
import com.blog.service.BlogService;
import com.blog.utils.PageUtil;
import com.blog.utils.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wb
 * @data: 2017/8/22 15:45
 * @see:
 * @since:
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "page", required = false) String page,
                              @RequestParam(value = "typeId", required = false) String typeId,
                              @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
                              HttpServletRequest request) throws Exception {
        ModelAndView mav=new ModelAndView();
        if (StringUtil.isEmpty(page)) {
            page = "1";
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
        //
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("typeId", typeId);
        map.put("releaseDateStr", releaseDateStr);
        List<Blog> blogList = blogService.list(map);
        for (Blog blog : blogList) {
            List<String> imagesList = blog.getImagesList();
            String blogInfo = blog.getContent();
            Document doc = Jsoup.parse(blogInfo);
            Elements jpgs = doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
            for (int i = 0; i < jpgs.size(); i++) {
                Element jpg = jpgs.get(i);
                imagesList.add(jpg.toString());
                if (i == 2) {
                    break;
                }
            }
        }

        mav.addObject("blogList", blogList);
        StringBuffer param=new StringBuffer(); // 查询参数
        if(StringUtil.isNotEmpty(typeId)){
            param.append("typeId="+typeId+"&");
        }
        if(StringUtil.isNotEmpty(releaseDateStr)){
            param.append("releaseDateStr="+releaseDateStr+"&");
        }

        mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(map), Integer.parseInt(page), 10, param.toString()));
        mav.addObject("mainPage", "foreground/blog/list.jsp");
        mav.addObject("pageTitle","Java开源博客系统");
        mav.setViewName("mainTemp");
        return mav;
    }
}
