package ltd.niui.service.impl;

import ltd.niui.dao.IArticleDao;
import ltd.niui.entity.Article;
import ltd.niui.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:25
 * @description：TODO
 */
@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    IArticleDao articleDao;

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleDao.findAll();
        return articles;
    }

    @Override
    public Article findArticleById(Integer id) {
        Article article = articleDao.findArticleById(id);
        return article;
    }

    @Override
    public void saveArticle(Article article) {
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        articleDao.saveArticle(article);
    }

    /*
    * 根据id判断，文章存在才可以修改
    * */
    @Override
    public void updateArticle(Article article) {
        if(articleDao.findArticleById(article.getArticleId())!=null){
            article.setArticleUpdateTime(new Date());
            articleDao.updateArticle(article);
        }else {

        }

    }
    /*
     * 根据id判断，文章存在才执行删除
     * */
    @Override
    public void deleteArticle(Integer id) {
        if(articleDao.findArticleById(id)==null){
            //需先删除评论

            articleDao.deleteArticle(id);
        }else {

        }
    }

    @Override
    public List<Article> findArticleByTitle(String title) {
        List<Article> articles = articleDao.findArticleByTitle("%"+title+"%");
        return articles;
    }

    @Override
    public List<Article> findArticleByUserId(Integer uid) {
        List<Article> articles = articleDao.findArticleByUserId(uid);
        return articles;
    }

    @Override
    public List<Article> findArticleByCategoryId(Integer cid) {
        List<Article> articles = articleDao.findArticleByCategoryId(cid);
        return articles;
    }
}
