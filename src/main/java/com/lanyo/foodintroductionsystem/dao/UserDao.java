package com.lanyo.foodintroductionsystem.dao;

import com.lanyo.foodintroductionsystem.mapper.UserMapper;
import com.lanyo.foodintroductionsystem.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public void addUser(user user) {
        userMapper.addUser(user);
    }

    public void deleteUser(int user_id) {
        userMapper.deleteUser(user_id);
    }

    public void updateUser(user user) {
        userMapper.updateUser(user);
    }

    public user selectUser(int user_id) {
        return userMapper.selectUser(user_id);
    }

    public List<user> selectAllUser() {
        return userMapper.selectAllUser();
    }

    public user selectUserByAccount(String user_account) {return userMapper.selectUserByAccount(user_account);}

    public user queryUserByName(String user_name) {
        return userMapper.queryUserByName(user_name);
    }

    public void banUser(int user_id) {
        userMapper.banUser(user_id);
    }

    public void unBanUser(int user_id) {
        userMapper.unBanUser(user_id);
    }

    public int countBannedUser() {
        return userMapper.countBannedUser();
    }

    public int countUsersNumber() {
        return userMapper.countUsersNumber();
    }

    public List<user> queryBannedUser() {
        return userMapper.queryBannedUser();
    }
}
