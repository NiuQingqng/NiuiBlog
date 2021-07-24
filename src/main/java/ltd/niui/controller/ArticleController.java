package ltd.niui.controller;

import ltd.niui.dao.ICategoryDao;
import ltd.niui.dao.ICommentDao;
import ltd.niui.dto.ArticleDetail;
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
 * @date ：2021/7/19 11:44
 * @description：TODO
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICommentDao commentDao;

    @ResponseBody
    @RequestMapping("findall")
    public List<Article> finAll(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Article> articles = articleService.findAll();
        return articles;
    }

    @ResponseBody
    @RequestMapping("findonedetail")
    public ArticleDetail findOneDetail(int articleId,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Article article = articleService.findArticleById(articleId);
        User user = userService.findUserById(article.getArticleUserId());
        List<Comment> comments = commentDao.findCommentByArticleId(article.getArticleId());
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setArticle(article);
        articleDetail.setUser(user);
        articleDetail.setComments(comments);
        return articleDetail;
    }

    @ResponseBody
    @RequestMapping("savearticle")
    public int saveArticle(Article article,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(article.getArticleContent());
        int i = articleService.saveArticle(article);
        return i;
    }

    @ResponseBody
    @RequestMapping("updatearticle")
    public int updateArticle(Article article,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int i = articleService.updateArticle(article);
        return i;
    }

    @ResponseBody
    @RequestMapping("delarticle")
    public int delArticle(int articleId,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int i = articleService.deleteArticle(articleId);
        return i;
    }
}
