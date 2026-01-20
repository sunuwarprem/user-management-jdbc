package com.prem.jdbc.service;

import com.prem.jdbc.model.User;

import java.util.List;

public interface UserService {

    int saveUserInfo(User user);

    int updateUserInfo(User user);

    int deleteUserInfo(int id);

    List<User> listUser();

    User getUserById(int id);
}
