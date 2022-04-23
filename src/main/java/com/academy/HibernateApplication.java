package com.academy;

import com.academy.model.dao.*;
import com.academy.model.dao.impl.*;
import com.academy.model.entity.*;

import java.util.ArrayList;
import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDaoImpl();
        Order order = orderDao.getById(5);
        System.out.println("");
    }
}
