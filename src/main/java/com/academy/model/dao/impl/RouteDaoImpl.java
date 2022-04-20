package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.RouteDao;
import com.academy.model.entity.Route;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class RouteDaoImpl extends DefaultDaoImpl<Route> implements RouteDao {

    @Override
    public void delete(Route entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Route route = session.get(Route.class,entity.getId());
        session.delete(route);
        transaction.commit();
    }

    @Override
    public List<Route> getAll() {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from Route");
        return query.getResultList();
    }

    @Override
    public Route getById(int id) {
        Session session = DataSource.getInstance().getSession();
        return session.get(Route.class,id);
    }
}
