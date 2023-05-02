package com.lanyo.foodintroductionsystem.servcie;

import com.lanyo.foodintroductionsystem.pojo.user;

import java.util.List;

public interface UserService {
    void addUser(user user);
    void deleteUser(int user_id);
    void updateUser(user user);
    user selectUser(int user_id);
    List<user> selectAllUser();
    user selectUserByAccount(String user_account);
    user queryUserByName(String user_name);
    void banUser(int user_id);
    void unBanUser(int user_id);
    int countBannedUser();
    int countUsersNumber();
    List<user> queryBannedUser();
}
