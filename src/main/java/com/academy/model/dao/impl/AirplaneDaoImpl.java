package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.AirplaneDao;
import com.academy.model.entity.Airplane;
import com.academy.model.entity.Route;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AirplaneDaoImpl extends DefaultDaoImpl<Airplane> implements AirplaneDao {

    @Override
    public void delete(Airplane entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Airplane airplane = session.get(Airplane.class, entity.getId());
        session.delete(airplane);
        transaction.commit();
    }

    @Override
    public List<Airplane> getAll() {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from Airplane");
        return query.getResultList();
    }

    @Override
    public Airplane getById(int id) {
        Session session = DataSource.getInstance().getSession();
        return session.get(Airplane.class, id);
    }

    @Override
    public List<Airplane> getByAirCompanyId(int airCompanyId) {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from Airplane where id_aircompany = :airCompanyId");
        query.setParameter("airCompanyId", airCompanyId);
        return query.getResultList();
    }
}
