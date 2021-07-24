package ltd.niui.controller;

import ltd.niui.dto.ArticleDetail;
import ltd.niui.dto.UserDetail;
import ltd.niui.entity.Article;
import ltd.niui.entity.Comment;
import ltd.niui.entity.User;
import ltd.niui.service.IArticleService;
import ltd.niui.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/21 10:04
 * @description：TODO
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IArticleService articleService;

    @ResponseBody
    @RequestMapping("findonedetail")
    public UserDetail findOneDetail(int userId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user = userService.findUserById(userId);
        List<Article> articles = articleService.findArticleByUserId(userId);
        UserDetail userDetail = new UserDetail();
        userDetail.setUser(user);
        userDetail.setArticles(articles);
        return userDetail;
    }
    @ResponseBody
    @RequestMapping("login")
    public User login(User u, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        User user = userService.findUserByUsernameAndPassword(u);
        user.setUserPassword("");
        return user;
    }
}
