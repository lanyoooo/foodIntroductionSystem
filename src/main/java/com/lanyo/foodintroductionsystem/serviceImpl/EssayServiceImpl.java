package com.lanyo.foodintroductionsystem.serviceImpl;

import com.lanyo.foodintroductionsystem.dao.EssayDao;
import com.lanyo.foodintroductionsystem.pojo.essay;
import com.lanyo.foodintroductionsystem.servcie.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("essaySer")
public class EssayServiceImpl implements EssayService {

    @Autowired
    EssayDao essayDao;

    @Override
    public void insertEssay(essay essay) {
        essayDao.insertEssay(essay);
    }

    @Override
    public void deleteEssay(int essay_id) {
        essayDao.deleteEssay(essay_id);
    }

    @Override
    public void updateEssay(essay essay) {
        essayDao.updateEssay(essay);
    }

    @Override
    public void updateEssayLikePlus(int essay_id) {
        essayDao.updateEssayLikePlus(essay_id);
    }

    @Override
    public void updateEssayLikeCancel(int essay_id) {
        essayDao.updateEssayLikeCancel(essay_id);
    }

    @Override
    public void updateEssayView(int essay_id) {
        essayDao.updateEssayView(essay_id);
    }

    @Override
    public essay selectEssay(int essay_id) {
        return essayDao.selectEssay(essay_id);
    }

    @Override
    public List<essay> selectAllEssay() {
        return essayDao.selectAllEssay();
    }

    @Override
    public List<essay> queryLikelyEssay(String words) {
        return essayDao.queryLikelyEssay(words);
    }

    @Override
    public int queryLatestPublishId() {
        return essayDao.queryLatestPublishId();
    }

    @Override
    public String queryAuthorNameByEssayId(int essay_id) {
        return essayDao.queryAuthorNameByEssayId(essay_id);
    }

    @Override
    public List<essay> queryEssayByAuthor(int pub_author_id) {
        return essayDao.queryEssayByAuthor(pub_author_id);
    }

    @Override
    public List<essay> queryAllRecommendEssay() {
        return essayDao.queryAllRecommendEssay();
    }

    @Override
    public void lockEssay(int essay_id) {
        essayDao.lockEssay(essay_id);
    }

    @Override
    public void unlockEssay(int essay_id) {
        essayDao.unlockEssay(essay_id);
    }

    @Override
    public void setEssayChecking(int essay_id) {
        essayDao.setEssayChecking(essay_id);
    }

    @Override
    public void unSetEssayChecking(int essay_id) {
        essayDao.unSetEssayChecking(essay_id);
    }

    @Override
    public int countLockedEssay() {
        return essayDao.countLockedEssay();
    }

    @Override
    public int countCheckingEssay() {
        return essayDao.countCheckingEssay();
    }

    @Override
    public int countEssaysNumber() {
        return essayDao.countEssaysNumber();
    }

    @Override
    public List<essay> queryLockedEssays() {
        return essayDao.queryLockedEssays();
    }

    @Override
    public List<essay> queryCheckingEssays() {
        return essayDao.queryCheckingEssays();
    }
}
