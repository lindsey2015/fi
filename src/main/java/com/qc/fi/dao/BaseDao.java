package com.qc.fi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T> {
    private Class clazz;

    @Resource
    protected SessionFactory sessionFactory;

    public BaseDao() {
        ParameterizedType pt = (ParameterizedType) (getClass().getGenericSuperclass());
        this.clazz = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public long save(T entity) {
        return (long) this.getSession().save(entity);
    }

    public void delete(long id) {
        final T entity = findOne(id);
        delete(entity);
    }

    public void delete(T entity) {
        this.getSession().delete(entity);
    }

    public T update(T entity) {
        this.getSession().update(entity);
        return entity;
    }

    public boolean exists(long id) {
        return this.getSession().get(clazz, id) != null;
    }

    public T findOne(long id) {
        return (T) this.getSession().get(clazz, id);
    }

    public List<T> findAll() {
        return this.getSession().createQuery("from " + clazz.getName()).list();
    }

    public long count() {
        return this.getSession().createQuery("from " + clazz.getName()).list().size();
    }
}
