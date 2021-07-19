package ltd.niui.test;

import ltd.niui.dao.IArticleDao;
import ltd.niui.dao.ICategoryDao;
import ltd.niui.dao.ICommentDao;
import ltd.niui.dao.IUserDao;
import ltd.niui.entity.Article;
import ltd.niui.entity.Category;
import ltd.niui.entity.Comment;
import ltd.niui.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 10:32
 * @description：TODO
 */
public class DaoTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IArticleDao articleDao;
    private IUserDao userDao;
    private ICategoryDao categoryDao;
    private ICommentDao commentDao;

    @Before
    public void init() throws Exception{
        //1、读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3、使用工厂生产SqlSession对象
        session = factory.openSession();
        //4、使用SqlSession创建Dao接口的代理对象
        articleDao = session.getMapper(IArticleDao.class);
        userDao = session.getMapper(IUserDao.class);
        categoryDao = session.getMapper(ICategoryDao.class);
        commentDao = session.getMapper(ICommentDao.class);
    }

    @After
    public void destroy()throws Exception{
        //提交事务
        session.commit();
        //6、释放资源
        session.close();
        in.close();
    }

    @Test
    public void articleDaoTestFind(){
        List<Article> articles = articleDao.findAll();
        for (Article article : articles){
            System.out.println(article);
        }
    }
    @Test
    public void articleDaoTestSave(){
        Article articl = new Article();
        articl.setArticleUserId(10001);
        articl.setArticleCategoryId(101);
        articl.setArticleTitle("第五篇");
        articl.setArticleContent("第五篇第五篇第五篇第五篇第五篇第五篇第五篇");
        int i = articleDao.saveArticle(articl);
        System.out.println("=================="+i);
    }
    @Test
    public void articleDaoTestUpdate(){
        Article articl = new Article();
        articl.setArticleId(100011);
        articl.setArticleTitle("第san篇");
        articl.setArticleContent("篇第三篇第三篇第三篇第三篇第三篇");
        int i = articleDao.updateArticle(articl);
        System.out.println("=================="+i);
    }
    @Test
    public void articleDaoTestDelete(){
        articleDao.deleteArticle(100006);
    }

    /*
    * UserDao测试
    * */
    @Test
    public void userDaoTestFind(){
        List<User> Users = userDao.findAll();
        for (User user : Users){
            System.out.println(user);
        }
    }

    @Test
    public void userDaoTestSave(){
        User user =new User();
        user.setUserName("zhangsana");
        user.setUserPassword("123a");
        user.setUserNickname("张三");
        userDao.saveUser(user);
    }
    @Test
    public void userDaoTestUpdate(){
        User user =new User();
        user.setUserId(10003);
        user.setUserName("zhangsan");
        user.setUserPassword("123654a");
        user.setUserNickname("张三");
        userDao.updateUser(user);
    }
    @Test
    public void userDaoTestDelete(){
        userDao.deleteUser(10003);
    }

    /*
     * Category测试
     * */
    @Test
    public void categoryTestFind(){
        List<Category> categories = categoryDao.findAll();
        for (Category category : categories){
            System.out.println(category);
        }
    }

    @Test
    public void categoryDaoTestSave(){
        Category category = new Category();
        category.setCategoryName("分类2");
        category.setCategoryDescription("ffff1");
        categoryDao.saveCategory(category);
    }
    @Test
    public void categoryDaoTestUpdate(){
        Category category = new Category();
        category.setCategoryId(101);
        category.setCategoryName("分类");
        category.setCategoryDescription("ffff1");
        categoryDao.updateCategory(category);
    }
    @Test
    public void categoryDaoTestDelete(){
        categoryDao.deleteCategory(102);
    }

    /*
     * comment测试
     * */
    @Test
    public void commentTestFind(){
//        List<Comment> comments = commentDao.findAll();
//        Comment comment = commentDao.findCommentById(100001);
        List<Comment> comments = commentDao.findCommentByArticleId(100001);
        for (Comment comment : comments){
            System.out.println(comment);
        }
//        System.out.println(comment);
    }

    @Test
    public void commentDaoTestSave(){
        Comment comment = new Comment();
        comment.setCommentArticleId(100001);
        comment.setCommentUserId(10002);
        comment.setCommentContent("haha");

        commentDao.saveComment(comment);
    }
    @Test
    public void commentDaoTestUpdate(){
        Comment comment = new Comment();
        comment.setCommentId(100002);
        comment.setCommentArticleId(100001);
        comment.setCommentUserId(10002);
        comment.setCommentContent("heehehe");
        commentDao.updateComment(comment);
    }
    @Test
    public void commentDaoTestDelete(){
        commentDao.deleteComment(100002);
    }
}
