package com.lanyo.foodintroductionsystem.pojo;

public class like {

    private int like_id;
    private int like_user_id;
    private int like_article_id;

    public like(int like_id, int like_user_id, int like_article_id) {
        this.like_id = like_id;
        this.like_user_id = like_user_id;
        this.like_article_id = like_article_id;
    }

    public int getLike_id() {
        return like_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public int getLike_user_id() {
        return like_user_id;
    }

    public void setLike_user_id(int like_user_id) {
        this.like_user_id = like_user_id;
    }

    public int getLike_article_id() {
        return like_article_id;
    }

    public void setLike_article_id(int like_article_id) {
        this.like_article_id = like_article_id;
    }

    @Override
    public String toString() {
        return "like{" +
                "like_id=" + like_id +
                ", like_user_id=" + like_user_id +
                ", like_article_id=" + like_article_id +
                '}';
    }

}
