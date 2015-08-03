package com.qc.fi.service;

import com.qc.fi.dao.UserDao;
import com.qc.fi.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Resource
    UserDao userDao=new UserDao();

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public void add(User user) {
        userDao.save(user);

    }

    public User getById(int id) {
        return userDao.findOne(id);
    }

    public void update(User user) {
        userDao.update(user);
    }
}