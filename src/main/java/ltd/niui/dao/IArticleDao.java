package ltd.niui.dao;

import ltd.niui.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleDao {
    //查找所有
    List<Article> findAll();
    //根据id查找
    /**/
    Article findArticleById(Integer id);
    //保存
    int saveArticle(Article article);
    //修改
    int updateArticle(Article article);
    //删除
    int deleteArticle(Integer id);
    //根据文章标题，模糊查找文章
    List<Article> findArticleByTitle(String title);
    //根据用户id查找,查找用户发表过的文章
    List<Article> findArticleByUserId(Integer uid);
    //根据分类id查找，查找分类下所有文章
    List<Article> findArticleByCategoryId(Integer cid);
}
