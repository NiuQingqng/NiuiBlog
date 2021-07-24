package ltd.niui.controller;

import ltd.niui.dao.ICategoryDao;
import ltd.niui.entity.Article;
import ltd.niui.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/22 17:12
 * @description：TODO
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryDao categoryDao;

    @ResponseBody
    @RequestMapping("findall")
    public List<Category> finAll(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Category> categories = categoryDao.findAll();
        return categories;
    }
}
