package by.makhon.webapp.services;

import by.makhon.webapp.bean.Comments;
import by.makhon.webapp.dao.CommentsDAO;

import java.util.List;

public class CommentsService implements CommentsDAO<Comments> {
    @Override
    public void addComent(Comments comments) {

    }

    @Override
    public Comments getCommentByID(Long commentID) {
        return null;
    }

    @Override
    public List<Comments> getAllComments() {
        return null;
    }

    @Override
    public void updateComment(Comments comments) {

    }

    @Override
    public void deleteComments(Long commentID) {

    }

    @Override
    public void deleteAllComments() {

    }
}
