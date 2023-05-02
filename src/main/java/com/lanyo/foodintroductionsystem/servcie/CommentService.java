package com.lanyo.foodintroductionsystem.servcie;

import com.lanyo.foodintroductionsystem.pojo.comment;

import java.util.List;

public interface CommentService {

    void addComment(comment comment);

    void deleteComment(int comment_id);

    void updateComment(comment comment);

    comment selectComment(int comment_id);

    List<comment> selectAllComments();

    List<comment> queryCommentsByEssay(int comment_article_id);
}
