package com.lanyo.foodintroductionsystem.servcie;

import com.lanyo.foodintroductionsystem.pojo.publish;

import java.util.List;

public interface PublishService {

    void addPublish(publish publish);

    void deletePublish(int pub_id);

    void updatePublish(publish publish);

    publish selectPublish(int pub_id);

    List<publish> selectAllPublish();

    int queryAuthorIdByEssayId(int pub_id);

    void deletePubByEssayId(int pub_article_id);
}
