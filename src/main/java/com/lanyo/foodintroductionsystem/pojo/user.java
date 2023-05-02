package com.lanyo.foodintroductionsystem.pojo;

public class user {
    private int user_id;
    private String user_account;
    private String user_pwd;
    private String user_name;
    private String user_authority;
    private boolean user_isBanned;

    public user(int user_id, String user_account, String user_pwd, String user_name, String user_authority, boolean user_isBanned) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_authority = user_authority;
        this.user_isBanned = user_isBanned;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_authority() {
        return user_authority;
    }

    public void setUser_authority(String user_authority) {
        this.user_authority = user_authority;
    }

    public boolean isUser_isBanned() {
        return user_isBanned;
    }

    public void setUser_isBanned(boolean user_isBanned) {
        this.user_isBanned = user_isBanned;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_authority='" + user_authority + '\'' +
                ", user_isBanned=" + user_isBanned +
                '}';
    }
}
