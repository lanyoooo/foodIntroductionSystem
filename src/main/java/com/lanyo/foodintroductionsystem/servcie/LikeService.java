package com.lanyo.foodintroductionsystem.servcie;

import com.lanyo.foodintroductionsystem.pojo.like;

import java.util.List;

public interface LikeService {

    void addLike(like like);

    void deleteLike(int like_id);

    void updateLike(like like);

    like selectLike(int like_id);

    List<like> selectAllLike();

    like queryIfLike(int like_user_id , int like_article_id);
}
