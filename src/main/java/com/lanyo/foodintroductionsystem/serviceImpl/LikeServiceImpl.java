package com.lanyo.foodintroductionsystem.serviceImpl;

import com.lanyo.foodintroductionsystem.dao.LikeDao;
import com.lanyo.foodintroductionsystem.pojo.like;
import com.lanyo.foodintroductionsystem.servcie.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeDao likeDao;

    @Override
    public void addLike(like like) {
        likeDao.addLike(like);
    }

    @Override
    public void deleteLike(int like_id) {
        likeDao.deleteLike(like_id);
    }

    @Override
    public void updateLike(like like) {
        likeDao.updateLike(like);
    }

    @Override
    public like selectLike(int like_id) {
        return likeDao.selectLike(like_id);
    }

    @Override
    public List<like> selectAllLike() {
        return likeDao.selectAllLike();
    }

    @Override
    public like queryIfLike(int like_user_id, int like_article_id) {
        return likeDao.queryIfLike(like_user_id , like_article_id);
    }
}
