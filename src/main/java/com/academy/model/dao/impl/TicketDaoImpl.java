package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.TicketDao;
import com.academy.model.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class TicketDaoImpl extends DefaultDaoImpl<Ticket> implements TicketDao {

    @Override
    public void delete(Ticket entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, entity.getId());
        session.delete(ticket);
        // HOT FIX DONE
        transaction.commit();
    }

    @Override
    public List<Ticket> getAll() {
        Session session = DataSource.getInstance().getSession();
        Query query = session.createQuery("from Ticket");
        return query.getResultList();
    }

    @Override
    public Ticket getById(int id) {
        Session session = DataSource.getInstance().getSession();
        return session.get(Ticket.class, id);
    }
}
