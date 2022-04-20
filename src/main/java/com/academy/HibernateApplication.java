package com.academy;

import com.academy.model.dao.AirCompanyDao;
import com.academy.model.dao.AirplaneDao;
import com.academy.model.dao.RouteDao;
import com.academy.model.dao.impl.AirCompanyDaoImpl;
import com.academy.model.dao.impl.AirplaneDaoImpl;
import com.academy.model.dao.impl.RouteDaoImpl;
import com.academy.model.entity.AirCompany;
import com.academy.model.entity.Airplane;
import com.academy.model.entity.Route;

import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {
        RouteDao routeDao = new RouteDaoImpl();
        List<Route> routes = routeDao.getAll();
        System.out.println("");
    }
}
