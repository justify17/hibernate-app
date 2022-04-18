package com.academy;

import com.academy.model.dao.AirCompanyDao;
import com.academy.model.dao.impl.AirCompanyDaoImpl;
import com.academy.model.entity.AirCompany;

import java.util.List;

public class HibernateApplication {
    public static void main(String[] args) {
        AirCompanyDao airCompanyDao = new AirCompanyDaoImpl();
        AirCompany airCompany = new AirCompany();
        airCompany.setId(11);
        airCompanyDao.delete(airCompany);
        System.out.println("");
    }
}
