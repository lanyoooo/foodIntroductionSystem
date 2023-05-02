package com.lanyo.foodintroductionsystem.dao;

import com.lanyo.foodintroductionsystem.mapper.EssayMapper;
import com.lanyo.foodintroductionsystem.pojo.essay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EssayDao {

    @Autowired
    private EssayMapper essayMapper;

    public void insertEssay(essay essay) {
        essayMapper.insertEssay(essay);
    }

    public void deleteEssay(int essay_id) {
        essayMapper.deleteEssay(essay_id);
    }

    public void updateEssay(essay essay) {
        essayMapper.updateEssay(essay);
    }

    public void updateEssayLikePlus(int essay_id) {
        essayMapper.updateEssayLikePlus(essay_id);
    }

    public void updateEssayLikeCancel(int essay_id) {
        essayMapper.updateEssayLikeCancel(essay_id);
    }

    public void updateEssayView(int essay_id) {
        essayMapper.updateEssayView(essay_id);
    }

    public essay selectEssay(int essay_id) {
        return essayMapper.selectEssay(essay_id);
    }

    public List<essay> selectAllEssay() {
        return essayMapper.selectAllEssay();
    }

    public List<essay> queryLikelyEssay(String words) {
        return essayMapper.queryLikelyEssay(words);
    }

    public int queryLatestPublishId() {
        return essayMapper.queryLatestPublishId();
    }

    public String queryAuthorNameByEssayId(int essay_id) {
        return essayMapper.queryAuthorNameByEssayId(essay_id);
    }

    public List<essay> queryEssayByAuthor(int pub_author_id) {
        return essayMapper.queryEssayByAuthor(pub_author_id);
    }

    public List<essay> queryAllRecommendEssay() {
        return essayMapper.queryAllRecommendEssay();
    }

    public void lockEssay(int essay_id) {
        essayMapper.lockEssay(essay_id);
    }

    public void unlockEssay(int essay_id) {
        essayMapper.unlockEssay(essay_id);
    }

    public void setEssayChecking(int essay_id) {
        essayMapper.setEssayChecking(essay_id);
    }

    public void unSetEssayChecking(int essay_id) {
        essayMapper.unSetEssayChecking(essay_id);
    }

    public int countLockedEssay() {
        return essayMapper.countLockedEssay();
    }

    public int countCheckingEssay() {
        return essayMapper.countCheckingEssay();
    }

    public int countEssaysNumber() {
        return essayMapper.countEssaysNumber();
    }

    public List<essay> queryLockedEssays() {
        return essayMapper.queryLockedEssays();
    }

    public List<essay> queryCheckingEssays() {
        return essayMapper.queryCheckingEssays();
    }
}
