package com.qc.fi.dao;

import com.qc.fi.model.User;
import com.qc.fi.model.UserType;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class UserDao extends BaseDao<User> {
    public User findOne(String userName, String password) {
        return (User) getSession().createQuery("from User u where userName = :userName and password = :password")
                .setParameter("userName", userName)
                .setParameter("password", password)
                .uniqueResult();
    }

    public List<User> findAllNormalUsers() {
        return getSession().createQuery("from User u where userType = :userType")
                .setParameter("userType", UserType.NORMAL.getCode())
                .list();
    }
}
