package com.lanyo.foodintroductionsystem.pojo;

public class publish {

    private int pub_id;
    private int pub_author_id;
    private int pub_article_id;

    public publish(int pub_id, int pub_author_id, int pub_article_id) {
        this.pub_id = pub_id;
        this.pub_author_id = pub_author_id;
        this.pub_article_id = pub_article_id;
    }

    public int getPub_id() {
        return pub_id;
    }

    public void setPub_id(int pub_id) {
        this.pub_id = pub_id;
    }

    public int getPub_author_id() {
        return pub_author_id;
    }

    public void setPub_author_id(int pub_author_id) {
        this.pub_author_id = pub_author_id;
    }

    public int getPub_article_id() {
        return pub_article_id;
    }

    public void setPub_article_id(int pub_article_id) {
        this.pub_article_id = pub_article_id;
    }

    @Override
    public String toString() {
        return "publish{" +
                "pub_id=" + pub_id +
                ", pub_author_id=" + pub_author_id +
                ", pub_article_id=" + pub_article_id +
                '}';
    }
}
