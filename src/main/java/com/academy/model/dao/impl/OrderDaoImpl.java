package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.OrderDao;
import com.academy.model.entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class OrderDaoImpl extends DefaultDaoImpl<Order> implements OrderDao {

    @Override
    public void delete(Order entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class,entity.getId());
        session.delete(order);
        transaction.commit();
    }

    @Override
    public List<Order> getAll() {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from Order");
        return query.getResultList();
    }

    @Override
    public Order getById(int id) {
        Session session = DataSource.getInstance().getSession();
        return session.get(Order.class,id);
    }
}
