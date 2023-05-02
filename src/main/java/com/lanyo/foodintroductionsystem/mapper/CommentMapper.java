package com.lanyo.foodintroductionsystem.mapper;

import com.lanyo.foodintroductionsystem.pojo.comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    void addComment(comment comment);

    void deleteComment(int comment_id);

    void updateComment(comment comment);

    comment selectComment(int comment_id);

    List<comment> selectAllComments();

    List<comment> queryCommentsByEssay(int comment_article_id);
}
