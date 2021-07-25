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
 * @description：处理文章的相关请求
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
    /**
     * @description:
     * @param
     * @return java.util.List<ltd.niui.entity.Article> 全部文章，不包括用户信息和评论
     */
    public List<Article> finAll(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Article> articles = articleService.findAll();
        return articles;
    }

    @ResponseBody
    @RequestMapping("findonedetail")
    /**
     * @description:
     * @param articleId 文章id
     * @param response
     * @return ltd.niui.dto.ArticleDetail  返回文章信息，包括用户信息和评论
     */
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
    /**
     * @description: 保存文章
     * @param article 文章的信息
     * @param response
     * @return int  返回保存结果，是数据库返回的影响行数 1成功 0失败
     */
    public int saveArticle(Article article,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int i = articleService.saveArticle(article);
        return i;
    }

    @ResponseBody
    @RequestMapping("updatearticle")
    /**
     * @description: 修改文章信息
     * @param article 文章的信息
     * @param response
     * @return int 返回修改结果，是数据库返回的影响行数 1成功 0失败
     */
    public int updateArticle(Article article,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int i = articleService.updateArticle(article);
        return i;
    }

    @ResponseBody
    @RequestMapping("delarticle")
    /*
    * 删除文章，通过文章id
    * 返回结果 1成功 0失败
    * */
    public int delArticle(int articleId,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int i = articleService.deleteArticle(articleId);
        return i;
    }
}
