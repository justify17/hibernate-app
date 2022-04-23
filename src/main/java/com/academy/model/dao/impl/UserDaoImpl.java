package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.UserDao;
import com.academy.model.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDaoImpl extends DefaultDaoImpl<User> implements UserDao {

    @Override
    public void delete(User entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, entity.getId());
        session.delete(user);
        transaction.commit();
    }

    @Override
    public List<User> getAll() {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getById(int id) {
        Session session = DataSource.getInstance().getSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> getByRoleId(int roleId) {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from User where id_role = :roleId");
        query.setParameter("roleId", roleId);
        return query.getResultList();
    }
}
