package ltd.niui.test;

import ltd.niui.entity.Article;
import ltd.niui.entity.Comment;
import ltd.niui.entity.User;
import ltd.niui.service.IArticleService;
import ltd.niui.service.ICommentService;
import ltd.niui.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:36
 * @description：TODO
 */
public class ServiceTest {

    private IArticleService articleService;
    private ICommentService commentService;
    private IUserService userService;
    ApplicationContext ac;

    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        articleService = (IArticleService) ac.getBean("articleService");
        commentService = ac.getBean("commentService",ICommentService.class);
        userService = ac.getBean("userService",IUserService.class);
    }

    @Test
    public void articleServiceTest() {
        List<Article> articles = articleService.findAll();
        for (Article article : articles){
            System.out.println(article);
        }
    }

    @Test
    public void articleServiceTestSave() {
        Article articl = new Article();
        articl.setArticleUserId(10001);
        articl.setArticleCategoryId(101);
        articl.setArticleTitle("第八篇");
        articl.setArticleContent("第八篇第八篇第八篇第八篇第八篇第八篇");
        articleService.saveArticle(articl);
    }
    @Test
    public void articleServiceTestUpdate() {
        Article articl = new Article();
        articl.setArticleId(100018);
        articl.setArticleTitle("第六篇");
        articl.setArticleContent("第六篇第六篇第六篇第六篇第六篇");
        articleService.updateArticle(articl);
        articleServiceTest();
    }

    @Test
    public void commentServiceTestSave() {
        Comment comment = new Comment();
        comment.setCommentArticleId(100001);
        comment.setCommentUserId(10002);
        comment.setCommentContent("haha");
        commentService.saveComment(comment);
    }

    @Test
    public void userServiceTestSave() {
        User user =new User();
        user.setUserName("zhangsan");
        user.setUserPassword("123a");
        user.setUserNickname("张三");
        userService.saveUser(user);
    }
}
