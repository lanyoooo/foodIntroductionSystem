package com.lanyo.foodintroductionsystem.dao;

import com.lanyo.foodintroductionsystem.mapper.CommentMapper;
import com.lanyo.foodintroductionsystem.pojo.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDao {

    @Autowired
    private CommentMapper commentMapper;

    public void addComment(comment comment) {
        commentMapper.addComment(comment);
    }

    public void deleteComment(int comment_id) {
        commentMapper.deleteComment(comment_id);
    }

    public void updateComment(comment comment) {
        commentMapper.updateComment(comment);
    }

    public comment selectComment(int comment_id) {
        return commentMapper.selectComment(comment_id);
    }

    public List<comment> selectAllComments() {
        return commentMapper.selectAllComments();
    }

    public List<comment> queryCommentsByEssay(int comment_article_id) {
        return commentMapper.queryCommentsByEssay(comment_article_id);
    }
}
