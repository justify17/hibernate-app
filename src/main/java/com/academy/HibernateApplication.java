package com.academy;

import com.academy.model.dao.*;
import com.academy.model.dao.impl.*;
import com.academy.model.entity.*;

import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {
        TicketDao ticketDao = new TicketDaoImpl();
        List<Ticket> tickets = ticketDao.getAll();
        System.out.println("");
    }
}
