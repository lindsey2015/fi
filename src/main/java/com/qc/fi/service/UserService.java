package com.qc.fi.service;

import com.qc.fi.dao.UserDao;
import com.qc.fi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User add(User user) {
        long id = userDao.save(user);
        user.setId(id);
        return user;
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public List<User> list() {
        return userDao.findAllNormalUsers();
    }

    public User getById(long id) {
        return userDao.findOne(id);
    }

    public User getByUserNamePwd(String userName, String password) {
        return userDao.findOne(userName, password);
    }
}