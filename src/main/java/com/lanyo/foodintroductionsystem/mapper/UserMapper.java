package com.lanyo.foodintroductionsystem.mapper;

import com.lanyo.foodintroductionsystem.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
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
