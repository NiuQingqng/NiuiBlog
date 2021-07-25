package ltd.niui.service.impl;

import ltd.niui.dao.IArticleDao;
import ltd.niui.dao.ICommentDao;
import ltd.niui.entity.Article;
import ltd.niui.entity.Comment;
import ltd.niui.service.IArticleService;
import ltd.niui.service.ICommentService;
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
    @Autowired
    ICommentService commentService;

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleDao.findAll();
        return articles;
    }

    @Override
    public Article findArticleById(Integer id) {
        Article article = articleDao.findArticleById(id);
        //浏览数量加一
        Article newArticle = new Article();
        newArticle.setArticleId(article.getArticleId());
        newArticle.setArticleViewCount(article.getArticleViewCount()+1);
        this.updateArticle(newArticle);
        return article;
    }

    @Override
    public int saveArticle(Article article) {
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        //摘要为空的话就截取文章的前100个字作为摘要,如果文章不够100字就设置全文
        if(article.getArticleSummary()==null) {
            if(article.getArticleContent().length() >100) {
                article.setArticleSummary(article.getArticleContent().substring(0, 100));
            }else {
                article.setArticleSummary(article.getArticleContent());
            }
        }
        int i = articleDao.saveArticle(article);
        return i;
    }

    /*
    * 根据id判断，文章存在才可以修改
    * */
    @Override
    public int updateArticle(Article article) {
        if(articleDao.findArticleById(article.getArticleId())!=null){
            //标题或内容或摘要不为空时才算修改，才修改更新时间，避免评论数和浏览数改变导致更新时间出错
            if(article.getArticleTitle()!=null||article.getArticleSummary()!=null||article.getArticleContent()!=null)
                article.setArticleUpdateTime(new Date());
            int i = articleDao.updateArticle(article);
            return i;
        }else {
            return 0;
        }

    }
    /*
     * 根据id判断，文章存在才执行删除
     * */
    @Override
    public int deleteArticle(Integer id) {
        int i = 0;//删除的结果
        if(articleDao.findArticleById(id)!=null){
            //需先删除评论
            boolean delCommentResult = true;
            List<Comment> comments = commentService.findCommentByArticleId(id);
            for (Comment comment : comments){
                if(commentService.deleteComment(comment.getCommentId())<=0) {
                    delCommentResult = false;
                    break;
                }
            }
            //判断删除结果，评论全部删除才能删除文章
            if (delCommentResult){
                i = articleDao.deleteArticle(id);
            }
        } else {

        }
        return i;
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
