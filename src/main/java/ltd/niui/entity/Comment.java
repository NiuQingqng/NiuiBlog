package ltd.niui.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer commentId;
    private Integer commentUserId;
    private Integer commentArticleId;
    private Integer commentPid;
    private String commentContent;
    private Date commentCreateTime;
    private Integer commentLikeCount;
    private User user;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public Integer getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(Integer commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentUserId=" + commentUserId +
                ", commentArticleId=" + commentArticleId +
                ", commentPid=" + commentPid +
                ", commentContent='" + commentContent + '\'' +
                ", commentCreateTime=" + commentCreateTime +
                ", commentLikeCount=" + commentLikeCount +
                ", user=" + user +
                '}';
    }
}
