package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.AirCompanyDao;
import com.academy.model.entity.AirCompany;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AirCompanyDaoImpl implements AirCompanyDao {

    @Override
    public void createOrUpdate(AirCompany entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
    }

    @Override
    public void delete(AirCompany entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.contains(entity) ? entity : session.merge(entity));
        transaction.commit();
    }

    @Override
    public List<AirCompany> getAll() {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from AirCompany");
        return query.getResultList();
    }

    @Override
    public AirCompany getById(int id) {
        Session session = DataSource.getInstance().getSession();
        return session.get(AirCompany.class,id);
    }
}
