package com.lanyo.foodintroductionsystem.dao;

import com.lanyo.foodintroductionsystem.mapper.LikeMapper;
import com.lanyo.foodintroductionsystem.pojo.like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LikeDao {

    @Autowired
    private LikeMapper likeMapper;

    public void addLike(like like) {
        likeMapper.addLike(like);
    }

    public void deleteLike(int like_id) {
        likeMapper.deleteLike(like_id);
    }

    public void updateLike(like like) {
        likeMapper.updateLike(like);
    }

    public like selectLike(int like_id) {
        return likeMapper.selectLike(like_id);
    }

    public List<like> selectAllLike() {
        return likeMapper.selectAllLike();
    }

    public like queryIfLike(int like_user_id , int like_article_id) {
        return likeMapper.queryIfLike(like_user_id , like_article_id);
    }
}
