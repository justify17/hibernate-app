package com.academy;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataSource {
    private static DataSource instance;
    private static EntityManagerFactory entityManagerFactory;

    private DataSource() {
        entityManagerFactory = Persistence.createEntityManagerFactory("by.id_academy");
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public Session getSession(){
        return getEntityManager().unwrap(Session.class);
    }
}
