package com.lanyo.foodintroductionsystem.serviceImpl;

import com.lanyo.foodintroductionsystem.dao.UserDao;
import com.lanyo.foodintroductionsystem.pojo.user;
import com.lanyo.foodintroductionsystem.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userSer")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(user user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int user_id) {
        userDao.deleteUser(user_id);
    }

    @Override
    public void updateUser(user user) {
        userDao.updateUser(user);
    }

    @Override
    public user selectUser(int user_id) {
        return userDao.selectUser(user_id);
    }

    @Override
    public List<user> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public user selectUserByAccount(String user_account) {
        return userDao.selectUserByAccount(user_account);
    }

    @Override
    public user queryUserByName(String user_name) {
        return userDao.queryUserByName(user_name);
    }

    @Override
    public void banUser(int user_id) {
        userDao.banUser(user_id);
    }

    @Override
    public void unBanUser(int user_id) {
        userDao.unBanUser(user_id);
    }

    @Override
    public int countBannedUser() {
        return userDao.countBannedUser();
    }

    @Override
    public int countUsersNumber() {
        return userDao.countUsersNumber();
    }

    @Override
    public List<user> queryBannedUser() {
        return userDao.queryBannedUser();
    }
}
