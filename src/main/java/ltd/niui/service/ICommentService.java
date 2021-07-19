package ltd.niui.service;

import ltd.niui.entity.Comment;

import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:23
 * @description：TODO
 */
public interface ICommentService {
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
