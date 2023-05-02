package com.lanyo.foodintroductionsystem.servcie;

import com.lanyo.foodintroductionsystem.pojo.essay;

import java.util.List;

public interface EssayService {
    void insertEssay(essay essay);
    void deleteEssay(int essay_id);
    void updateEssay(essay essay);
    void updateEssayLikePlus(int essay_id);
    void updateEssayLikeCancel(int essay_id);
    void updateEssayView(int essay_id);
    essay selectEssay(int essay_id);
    List<essay> selectAllEssay();
    List<essay> queryLikelyEssay(String words);
    int queryLatestPublishId();
    String queryAuthorNameByEssayId(int essay_id);
    List<essay> queryEssayByAuthor(int pub_author_id);
    List<essay> queryAllRecommendEssay();
    void lockEssay(int essay_id);
    void unlockEssay(int essay_id);
    void setEssayChecking(int essay_id);
    void unSetEssayChecking(int essay_id);
    int countLockedEssay();
    int countCheckingEssay();
    int countEssaysNumber();
    List<essay> queryLockedEssays();
    List<essay> queryCheckingEssays();
}
