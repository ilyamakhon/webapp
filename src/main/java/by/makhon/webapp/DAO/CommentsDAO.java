package by.makhon.webapp.dao;

import java.util.List;

public interface CommentsDAO<Comments> {
    void addComent(Comments comments);
    Comments getCommentByID(Long commentID);
    List<Comments> getAllComments();
    void updateComment(Comments comments);
    void deleteComments(Long commentID);
    void deleteAllComments();
}
