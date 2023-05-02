package com.lanyo.foodintroductionsystem.mapper;

import com.lanyo.foodintroductionsystem.pojo.publish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PublishMapper {

    void addPublish(publish publish);

    void deletePublish(int pub_id);

    void updatePublish(publish publish);

    publish selectPublish(int pub_id);

    List<publish> selectAllPublish();

    int queryAuthorIdByEssayId(int pub_id);

    void deletePubByEssayId(int pub_article_id);
}
