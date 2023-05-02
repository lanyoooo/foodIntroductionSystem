package com.lanyo.foodintroductionsystem.serviceImpl;

import com.lanyo.foodintroductionsystem.dao.PublishDao;
import com.lanyo.foodintroductionsystem.pojo.publish;
import com.lanyo.foodintroductionsystem.servcie.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pubSer")
public class PublishServiceImpl implements PublishService {

    @Autowired
    PublishDao publishDao;

    @Override
    public void addPublish(publish publish) {
        publishDao.addPublish(publish);
    }

    @Override
    public void deletePublish(int pub_id) {
        publishDao.deletePublish(pub_id);
    }

    @Override
    public void updatePublish(publish publish) {
        publishDao.updatePublish(publish);
    }

    @Override
    public publish selectPublish(int pub_id) {
        return publishDao.selectPublish(pub_id);
    }

    @Override
    public List<publish> selectAllPublish() {
        return publishDao.selectAllPublish();
    }

    @Override
    public int queryAuthorIdByEssayId(int pub_id) {
        return publishDao.queryAuthorIdByEssayId(pub_id);
    }

    @Override
    public void deletePubByEssayId(int pub_article_id) {
        publishDao.deletePubByEssayId(pub_article_id);
    }
}
