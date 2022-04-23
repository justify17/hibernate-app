package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.RoleDao;
import com.academy.model.entity.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class RoleDaoImpl extends DefaultDaoImpl<Role> implements RoleDao {

    @Override
    public void delete(Role entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Role role = session.get(Role.class,entity.getId());
        session.delete(role);
        transaction.commit();
    }

    @Override
    public List<Role> getAll() {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from Role");
        return query.getResultList();
    }

    @Override
    public Role getById(int id) {
        Session session = DataSource.getInstance().getSession();
        return session.get(Role.class,id);
    }
}
