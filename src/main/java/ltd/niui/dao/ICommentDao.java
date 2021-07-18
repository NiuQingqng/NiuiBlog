package ltd.niui.dao;

import ltd.niui.entity.Comment;

import java.util.List;

public interface ICommentDao {
    //查找所有
    List<Comment> findAll();
    //根据id查找
    Comment findCommentById(Integer id);
    //保存
    void saveComment(Comment comment);
    //修改
    void updateComment(Comment comment);
    //删除
    void deleteComment(Integer id);
    //根据id查找
    List<Comment> findCommentByArticleId(Integer aid);
}
