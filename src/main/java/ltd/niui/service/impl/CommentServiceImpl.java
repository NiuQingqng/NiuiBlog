package ltd.niui.service.impl;

import ltd.niui.dao.ICommentDao;
import ltd.niui.entity.Comment;
import ltd.niui.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：Niuniu
 * @date ：2021/7/18 17:26
 * @description：TODO
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentDao commentDao;

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = commentDao.findAll();
        return comments;
    }

    @Override
    public Comment findCommentById(Integer id) {
        Comment comment = commentDao.findCommentById(id);
        return comment;
    }

    @Override
    public int saveComment(Comment comment) {
        comment.setCommentCreateTime(new Date());
        return commentDao.saveComment(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        if(commentDao.findCommentById(comment.getCommentId())!=null){
            commentDao.updateComment(comment);
        }else {

        }
    }

    @Override
    public int deleteComment(Integer id) {
        if(commentDao.findCommentById(id)!=null){
            return commentDao.deleteComment(id);
        } else {
            return 0;
        }
    }

    @Override
    public List<Comment> findCommentByArticleId(Integer aid) {
        List<Comment> comments = commentDao.findCommentByArticleId(aid);
        return comments;
    }
}
