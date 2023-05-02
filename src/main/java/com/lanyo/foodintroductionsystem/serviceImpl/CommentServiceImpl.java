package com.lanyo.foodintroductionsystem.serviceImpl;

import com.lanyo.foodintroductionsystem.dao.CommentDao;
import com.lanyo.foodintroductionsystem.pojo.comment;
import com.lanyo.foodintroductionsystem.servcie.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public void addComment(comment comment) {
        commentDao.addComment(comment);
    }

    @Override
    public void deleteComment(int comment_id) {
        commentDao.deleteComment(comment_id);
    }

    @Override
    public void updateComment(comment comment) {
        commentDao.updateComment(comment);
    }

    @Override
    public comment selectComment(int comment_id) {
        return commentDao.selectComment(comment_id);
    }

    @Override
    public List<comment> selectAllComments() {
        return commentDao.selectAllComments();
    }

    @Override
    public List<comment> queryCommentsByEssay(int comment_article_id) {
        return commentDao.queryCommentsByEssay(comment_article_id);
    }
}
