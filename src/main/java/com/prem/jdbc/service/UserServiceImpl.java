package com.prem.jdbc.service;

import com.prem.jdbc.dao.UserDao;
import com.prem.jdbc.dao.UserDaoImpl;
import com.prem.jdbc.model.User;

import java.util.List;

//for business logic
public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();

    @Override
    public int saveUserInfo(User user) {
//        int saved = userDao.saveUserInfo(user);
//        return saved;
        return  userDao.saveUserInfo(user);
    }

    @Override
    public int updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public int deleteUserInfo(int id) {
        return userDao.deleteUserInfo(id);
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
