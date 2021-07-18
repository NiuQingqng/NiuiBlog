package ltd.niui.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

    private Integer articleId;
    private Integer articleUserId;
    private Integer articleCategoryId;
    private String articleTitle;
    private String articleContent;
    private Integer articleViewCount;
    private Integer articleCommentCount;
    private Integer articleLikeCount;
    private boolean articleIsComment;
    private Integer articleStatus;
    private Integer articleOrder;
    private Date articleUpdateTime;
    private Date articleCreateTime;
    private String articleSummary;
    private String articleThumbnail;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleUserId() {
        return articleUserId;
    }

    public void setArticleUserId(Integer articleUserId) {
        this.articleUserId = articleUserId;
    }

    public Integer getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(Integer articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticleViewCount() {
        return articleViewCount;
    }

    public void setArticleViewCount(Integer articleViewCount) {
        this.articleViewCount = articleViewCount;
    }

    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    public boolean isArticleIsComment() {
        return articleIsComment;
    }

    public void setArticleIsComment(boolean articleIsComment) {
        this.articleIsComment = articleIsComment;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleOrder() {
        return articleOrder;
    }

    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleThumbnail() {
        return articleThumbnail;
    }

    public void setArticleThumbnail(String articleThumbnail) {
        this.articleThumbnail = articleThumbnail;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleUserId=" + articleUserId +
                ", articleCategoryId=" + articleCategoryId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleViewCount=" + articleViewCount +
                ", articleCommentCount=" + articleCommentCount +
                ", articleLikeCount=" + articleLikeCount +
                ", articleIsComment=" + articleIsComment +
                ", articleStatus=" + articleStatus +
                ", articleOrder=" + articleOrder +
                ", articleUpdateTime=" + articleUpdateTime +
                ", articleCreateTime=" + articleCreateTime +
                ", articleSummary='" + articleSummary + '\'' +
                ", articleThumbnail='" + articleThumbnail + '\'' +
                '}';
    }
}
