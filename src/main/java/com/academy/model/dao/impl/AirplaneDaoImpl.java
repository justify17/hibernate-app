package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.AirplaneDao;
import com.academy.model.entity.Airplane;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class AirplaneDaoImpl implements AirplaneDao {

    @Override
    public void createOrUpdate(Airplane entity) {

    }

    @Override
    public void delete(Airplane entity) {

    }

    @Override
    public List<Airplane> getAll() {
        return null;
    }

    @Override
    public Airplane getById(int id) {
        return null;
    }

    @Override
    public List<Airplane> getByAirCompanyId(int airCompanyId) {
        Session session = DataSource.getInstance().getSession();

        Query query = session.createQuery("from airplane where id_aircompany = :airCompanyId");
        query.setParameter("airCompanyId",airCompanyId);

        return query.getResultList();
    }
}
