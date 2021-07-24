package ltd.niui.dto;

import ltd.niui.entity.Article;
import ltd.niui.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/21 10:02
 * @description：TODO
 */
public class UserDetail {
    private User user;
    private List<Article> articles = new ArrayList<Article>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
