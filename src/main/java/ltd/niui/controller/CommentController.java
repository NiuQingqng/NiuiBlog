package ltd.niui.controller;

import ltd.niui.entity.Article;
import ltd.niui.entity.Comment;
import ltd.niui.service.IArticleService;
import ltd.niui.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ：Niuniu
 * @date ：2021/7/21 20:14
 * @description：处理评论的相关请求
 */
@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IArticleService articleService;
    @ResponseBody
    @RequestMapping("sendcomment")
    /**
     * @description: 保存评论，并且更改对应文章的评论数
     * @param comment
     * @param response
     * @return int 返回结果 1成功 0失败
     */
    public int sendComment(Comment comment, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int i = commentService.saveComment(comment);
        //评论数改变
        Article article = new Article();
        article.setArticleId(comment.getCommentArticleId());
        article.setArticleCommentCount(commentService.findCommentByArticleId(article.getArticleId()).size());
        articleService.updateArticle(article);
        return i;
    }
    @ResponseBody
    @RequestMapping("delcomment")
    /**
     * @description: 删除评论，并且更改对应文章的评论数
     * @param commentId
     * @param response
     * @return int 返回结果 1成功 0失败
     */
    public int delComment(int commentId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Article article = new Article();
        //需要在删除之前通过评论找文章id，要不就找不到了
        article.setArticleId(commentService.findCommentById(commentId).getCommentArticleId());
        int i = commentService.deleteComment(commentId);
        //评论数改变
        article.setArticleCommentCount(commentService.findCommentByArticleId(article.getArticleId()).size());
        articleService.updateArticle(article);
        return i;
    }
}
