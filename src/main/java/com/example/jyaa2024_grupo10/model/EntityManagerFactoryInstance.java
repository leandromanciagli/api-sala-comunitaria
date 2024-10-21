package com.example.jyaa2024_grupo10.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryInstance {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactoryInstance() {}

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("miUP");
        }
        return entityManagerFactory;
    }
}
