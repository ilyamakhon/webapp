package by.makhon.webapp.converter;

import by.makhon.webapp.bean.Comments;
import by.makhon.webapp.dto.CommentsDTO;

import java.util.ArrayList;
import java.util.List;

public class CommentsConverter {
    public CommentsDTO convertToDTO(Comments comments) {

        CommentsDTO commentsDTO = new CommentsDTO();

        commentsDTO.setCommentID(comments.getCommentID());
        commentsDTO.setCommentContent(comments.getCommentContent());
        commentsDTO.setUserID(comments.getUserID());

        return commentsDTO;
    }

    public List<CommentsDTO> convertAllToDTO(List<Comments> commentsList) {
        List<CommentsDTO> commentsDTOList = new ArrayList<>();
        for(Comments i: commentsList) {
            commentsDTOList.add(this.convertToDTO(i));
        }
        return commentsDTOList;
    }
}
