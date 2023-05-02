package com.lanyo.foodintroductionsystem.pojo;

import java.util.Date;

public class comment {
    private int comment_id;
    private int comment_article_id;
    private int comment_user_id;
    private String comment_user_name;
    private String comment_text;
    private Date comment_pub_time;

    public comment(int comment_id, int comment_article_id, int comment_user_id, String comment_user_name, String comment_text, Date comment_pub_time) {
        this.comment_id = comment_id;
        this.comment_article_id = comment_article_id;
        this.comment_user_id = comment_user_id;
        this.comment_user_name = comment_user_name;
        this.comment_text = comment_text;
        this.comment_pub_time = comment_pub_time;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_article_id() {
        return comment_article_id;
    }

    public void setComment_article_id(int comment_article_id) {
        this.comment_article_id = comment_article_id;
    }

    public int getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(int comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public String getComment_user_name() {
        return comment_user_name;
    }

    public void setComment_user_name(String comment_user_name) {
        this.comment_user_name = comment_user_name;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getComment_pub_time() {
        return comment_pub_time;
    }

    public void setComment_pub_time(Date comment_pub_time) {
        this.comment_pub_time = comment_pub_time;
    }

    @Override
    public String toString() {
        return "comment{" +
                "comment_id=" + comment_id +
                ", comment_article_id=" + comment_article_id +
                ", comment_user_id=" + comment_user_id +
                ", comment_user_name='" + comment_user_name + '\'' +
                ", comment_text='" + comment_text + '\'' +
                ", comment_pub_time=" + comment_pub_time +
                '}';
    }
}
