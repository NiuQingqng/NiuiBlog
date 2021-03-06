package ltd.niui.dao;

import ltd.niui.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentDao {
    //查找所有
    List<Comment> findAll();
    //根据id查找
    Comment findCommentById(Integer id);
    //保存
    int saveComment(Comment comment);
    //修改
    int updateComment(Comment comment);
    //删除
    int deleteComment(Integer id);
    //根据id查找
    List<Comment> findCommentByArticleId(Integer aid);
}
