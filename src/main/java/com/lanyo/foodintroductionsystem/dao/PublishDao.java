package com.lanyo.foodintroductionsystem.dao;

import com.lanyo.foodintroductionsystem.mapper.PublishMapper;
import com.lanyo.foodintroductionsystem.pojo.publish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PublishDao {

    @Autowired
    private PublishMapper publishMapper;

    public void addPublish(publish publish) {
        publishMapper.addPublish(publish);
    }

    public void deletePublish(int pub_id) {
        publishMapper.deletePublish(pub_id);
    }

    public void updatePublish(publish publish) {
        publishMapper.updatePublish(publish);
    }

    public publish selectPublish(int pub_id) {
        return publishMapper.selectPublish(pub_id);
    }

    public List<publish> selectAllPublish() {
        return publishMapper.selectAllPublish();
    }

    public int queryAuthorIdByEssayId(int pub_id) {
        return publishMapper.queryAuthorIdByEssayId(pub_id);
    }

    public void deletePubByEssayId(int pub_article_id) {
        publishMapper.deletePubByEssayId(pub_article_id);
    }
}
