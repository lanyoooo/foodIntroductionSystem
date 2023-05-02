package com.lanyo.foodintroductionsystem.mapper;

import com.lanyo.foodintroductionsystem.pojo.like;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LikeMapper {

    void addLike(like like);

    void deleteLike(int like_id);

    void updateLike(like like);

    like selectLike(int like_id);

    List<like> selectAllLike();

    like queryIfLike(int like_user_id , int like_article_id);

}
