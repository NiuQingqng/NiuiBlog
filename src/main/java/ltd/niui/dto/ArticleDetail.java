package ltd.niui.dto;

import ltd.niui.entity.Article;
import ltd.niui.entity.Comment;
import ltd.niui.entity.User;

import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/20 15:36
 * @description：TODO
 */
public class ArticleDetail {
    private Article article;
    private ltd.niui.entity.User User;
    private List<Comment> comments;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public ltd.niui.entity.User getUser() {
        return User;
    }

    public void setUser(ltd.niui.entity.User user) {
        User = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
