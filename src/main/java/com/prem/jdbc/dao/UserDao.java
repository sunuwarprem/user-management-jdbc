package com.prem.jdbc.dao;

import com.prem.jdbc.model.User;

import java.util.List;

public interface UserDao {

    int saveUserInfo(User user);

    int updateUserInfo(User user);

    int deleteUserInfo(int id);

    List<User> listUser();

    User getUserById(int id);
}
