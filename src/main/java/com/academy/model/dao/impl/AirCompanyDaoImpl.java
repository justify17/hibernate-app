package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.AirCompanyDao;
import com.academy.model.entity.AirCompany;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AirCompanyDaoImpl extends DefaultDaoImpl<AirCompany> implements AirCompanyDao {

    @Override
    public void delete(AirCompany entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        AirCompany airCompany = session.get(AirCompany.class,entity.getId());
        session.delete(airCompany);
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
