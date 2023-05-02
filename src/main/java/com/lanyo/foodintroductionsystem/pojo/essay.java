package com.lanyo.foodintroductionsystem.pojo;

import java.util.Date;

public class essay {
    private int essay_id;
    private String essay_title;
    private String essay_text;
    private int essay_like_cnt;
    private int essay_view_cnt;
    private Date essay_pub_time;
    private boolean essay_isLocked;
    private boolean essay_isChecking;

    public essay(int essay_id, String essay_title, String essay_text, int essay_like_cnt, int essay_view_cnt, Date essay_pub_time, boolean essay_isLocked, boolean essay_isChecking) {
        this.essay_id = essay_id;
        this.essay_title = essay_title;
        this.essay_text = essay_text;
        this.essay_like_cnt = essay_like_cnt;
        this.essay_view_cnt = essay_view_cnt;
        this.essay_pub_time = essay_pub_time;
        this.essay_isLocked = essay_isLocked;
        this.essay_isChecking = essay_isChecking;
    }

    public int getEssay_id() {
        return essay_id;
    }

    public void setEssay_id(int essay_id) {
        this.essay_id = essay_id;
    }

    public String getEssay_title() {
        return essay_title;
    }

    public void setEssay_title(String essay_title) {
        this.essay_title = essay_title;
    }

    public String getEssay_text() {
        return essay_text;
    }

    public void setEssay_text(String essay_text) {
        this.essay_text = essay_text;
    }

    public int getEssay_like_cnt() {
        return essay_like_cnt;
    }

    public void setEssay_like_cnt(int essay_like_cnt) {
        this.essay_like_cnt = essay_like_cnt;
    }

    public int getEssay_view_cnt() {
        return essay_view_cnt;
    }

    public void setEssay_view_cnt(int essay_view_cnt) {
        this.essay_view_cnt = essay_view_cnt;
    }

    public Date getEssay_pub_time() {
        return essay_pub_time;
    }

    public void setEssay_pub_time(Date essay_pub_time) {
        this.essay_pub_time = essay_pub_time;
    }

    public boolean isEssay_isLocked() {
        return essay_isLocked;
    }

    public void setEssay_isLocked(boolean essay_isLocked) {
        this.essay_isLocked = essay_isLocked;
    }

    public boolean isEssay_isChecking() {
        return essay_isChecking;
    }

    public void setEssay_isChecking(boolean essay_isChecking) {
        this.essay_isChecking = essay_isChecking;
    }

    @Override
    public String toString() {
        return "essay{" +
                "essay_id=" + essay_id +
                ", essay_title='" + essay_title + '\'' +
                ", essay_text='" + essay_text + '\'' +
                ", essay_like_cnt=" + essay_like_cnt +
                ", essay_view_cnt=" + essay_view_cnt +
                ", essay_pub_time=" + essay_pub_time +
                ", essay_isLocked=" + essay_isLocked +
                ", essay_isChecking=" + essay_isChecking +
                '}';
    }
}
