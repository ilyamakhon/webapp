package by.makhon.webapp.bean;

import java.util.Objects;

public class Comments {
    private Long commentID;
    private String commentContent;
    private Long userID;

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(commentID, comments.commentID) &&
                Objects.equals(commentContent, comments.commentContent) &&
                Objects.equals(userID, comments.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentID, commentContent, userID);
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentID=" + commentID +
                ", commentContent='" + commentContent + '\'' +
                ", userID=" + userID +
                '}';
    }
}
